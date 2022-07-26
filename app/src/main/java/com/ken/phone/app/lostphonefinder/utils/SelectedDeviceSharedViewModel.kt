package com.ken.phone.app.lostphonefinder.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ken.phone.app.lostphonefinder.data.models.Device

class SelectedDeviceSharedViewModel:ViewModel() {

    private val _device = MutableLiveData<Device>()
    val device: LiveData<Device> = _device
    fun selectDevice(device:Device){
        _device.value = device
    }
}