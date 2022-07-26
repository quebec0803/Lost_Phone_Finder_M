package com.ken.phone.app.lostphonefinder.ui.all_devices

import androidx.lifecycle.*
import com.ken.phone.app.lostphonefinder.data.fake_repositories.devicesFakeRepository
import com.ken.phone.app.lostphonefinder.data.models.Device
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllDevicesViewModel @Inject constructor(private val repository: devicesFakeRepository) : ViewModel() {

    private val _devices = MutableLiveData<List<Device>>()
    val devices: LiveData<List<Device>> = _devices


    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    init {
        viewModelScope.launch {
            // Trigger the flow and consume its elements using collect
            repository.myDevices.collect { list ->
                _devices.value =   list
                // Update View with the latest favorite news
            }
        }
    }
    val text: LiveData<String> = _text
}