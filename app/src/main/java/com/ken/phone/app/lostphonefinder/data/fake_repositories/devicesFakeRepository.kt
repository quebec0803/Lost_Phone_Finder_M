package com.ken.phone.app.lostphonefinder.data.fake_repositories

import android.util.Log
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.model.Document
import com.ken.phone.app.lostphonefinder.data.models.Device
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class devicesFakeRepository @Inject constructor() {


    val myDevices: Flow<List<Device>> = callbackFlow {
        val list: MutableList<Device> = mutableListOf()
        coroutineScope {
            launch(Dispatchers.IO) {
                while (true) {
                    try {
                        list.clear()
                        list.add(Device("Pixel 5A","find_phone_321","uuid","fcm"))
                        list.add(Device("Samsung A31","find_phone_381","uuid","fcm"))
                        list.add(Device("OnePlus Nord20","find_phone_331","uuid","fcm"))
                        list.add(Device("Nokia 3120","find_phone_328","uuid","fcm"))
                        trySend(list)
                        delay(5000)
                    } catch (ex: Exception) {
                        close(ex)
                       // break
                    }
                }
            }
        }



        // The callback inside awaitClose will be executed when the flow is
        // either closed or cancelled.
        // In this case, remove the callback from Firestore
        awaitClose {list.clear() }
    }
}