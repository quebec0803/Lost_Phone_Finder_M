package com.ken.phone.app.lostphonefinder.ui.single_device

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ken.phone.app.lostphonefinder.R
import com.ken.phone.app.lostphonefinder.data.models.Device
import com.ken.phone.app.lostphonefinder.databinding.FragmentSingleDeviceBinding
import com.ken.phone.app.lostphonefinder.utils.SelectedDeviceSharedViewModel
import io.grpc.NameResolver


class SingleDeviceFragment : Fragment() {


    lateinit var binding: FragmentSingleDeviceBinding
    val viewModel: SingleDeviceViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
    //val nav: SingleDeviceFragmentArgs by navArgs()

    val selectedDeviceSharedViewModel: SelectedDeviceSharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSingleDeviceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //var selectedDevice:Device = nav.device
        var selectedDevice: Device = selectedDeviceSharedViewModel.device.value!!

        binding.deviceNick.text = selectedDevice.deviceNick
        binding.actionsDetails.text =
            "Perform following actions to find ${selectedDevice.deviceNick}"

        binding.actionLocate.apply {
            actionName.text = "Locate"
            icon.setImageResource(R.drawable.ic_locate)
            root.setOnClickListener {
                findNavController().navigate(SingleDeviceFragmentDirections.actionSingleDeviceFragmentToLocateFragment())
            }
        }
        binding.actionLock.apply {
            actionName.text = "Lock"
            icon.setImageResource(R.drawable.ic_lock)
        }
        binding.actionRing.apply {
            actionName.text = "Ring"
            icon.setImageResource(R.drawable.ic_ring)
        }
        binding.actionVibrate.apply {
            actionName.text = "Vibrate"
            icon.setImageResource(R.drawable.ic_vibrate)
        }
        binding.actionWipe.apply {
            actionName.text = "Wipe"
            icon.setImageResource(R.drawable.ic_wipe)
        }

        binding.actionStatus.apply {
            actionName.text = "Status"
            icon.setImageResource(R.drawable.ic_status)
            root.setOnClickListener {
                findNavController().navigate(SingleDeviceFragmentDirections.actionSingleDeviceFragmentToStatusFragment())
            }
        }
        binding.actionMessage.apply {
            actionName.text = "Message"
            icon.setImageResource(R.drawable.ic_hope_message)
            root.setOnClickListener {
                findNavController().navigate(SingleDeviceFragmentDirections.actionSingleDeviceFragmentToMessageFragment())
            }
        }
    }

}