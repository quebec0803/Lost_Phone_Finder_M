package com.ken.phone.app.lostphonefinder.ui.all_devices

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ken.phone.app.lostphonefinder.data.models.Device
import com.ken.phone.app.lostphonefinder.databinding.ItemDeviceBinding

class DevicesAdapter(var devicesList: List<Device>,val callbacks: Callbacks) :
    RecyclerView.Adapter<DevicesAdapter.ViewHolder>() {

    class ViewHolder(deviceItemBinding: ItemDeviceBinding) :
        RecyclerView.ViewHolder(deviceItemBinding.root) {
        val deviceName: TextView
        val deviceId: TextView

        init {
            deviceName = deviceItemBinding.tvDeviceName
            deviceId = deviceItemBinding.tvDeviceId
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemDeviceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.deviceName.text = devicesList[position].deviceNick
        holder.deviceId.text = devicesList[position].deviceId
        holder.itemView.setOnClickListener {
            callbacks.onDeviceSeleted(devicesList[position])
        }
    }

    override fun getItemCount(): Int {
       return devicesList.size
    }

interface Callbacks{
    fun onDeviceSeleted(device: Device)
}
}