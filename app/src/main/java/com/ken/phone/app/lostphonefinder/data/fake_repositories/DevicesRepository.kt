package com.ken.phone.app.lostphonefinder.data.fake_repositories

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.toObject
import com.ken.phone.app.lostphonefinder.data.models.Device
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class DevicesRepository constructor(val firestore: FirebaseFirestore) {

    val myDevices: Flow<List<Device>> = callbackFlow {
        // Reference to use in Firestore
        var eventsCollection: Query? = null
        try {
            eventsCollection = firestore
                .collection("devices")
                .whereEqualTo("ownerUuID","")
        } catch (e: Throwable) {
            // If Firebase cannot be initialized, close the stream of data
            // flow consumers will stop collecting and the coroutine will resume
            close(e)
        }

        // Registers callback to firestore, which will be called on new events
        val subscription = eventsCollection?.addSnapshotListener { value, error ->
            if (error != null) {
                Log.w("startlisteningMethod", "Listen failed.", error)
                return@addSnapshotListener
            }
            var devicesList: MutableList<Device> = mutableListOf()
            for (document in value!!) {
                val dev = document.toObject<Device>()
                devicesList.add(dev)
            }
            //offer(devicesList)
            trySend(devicesList).isSuccess
        }
        // The callback inside awaitClose will be executed when the flow is
        // either closed or cancelled.
        // In this case, remove the callback from Firestore
        awaitClose { subscription?.remove() }
    }
}