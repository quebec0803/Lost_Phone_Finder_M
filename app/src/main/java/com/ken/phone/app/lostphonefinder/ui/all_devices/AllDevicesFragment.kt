package com.ken.phone.app.lostphonefinder.ui.all_devices

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ken.phone.app.lostphonefinder.data.models.Device


import com.ken.phone.app.lostphonefinder.databinding.FragmentAllDevicesBinding
import com.ken.phone.app.lostphonefinder.utils.SelectedDeviceSharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllDevicesFragment : Fragment() {

    private var _binding: FragmentAllDevicesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

     private val allDevicesViewModel: AllDevicesViewModel by viewModels()
    val selectedDeviceSharedViewModel:SelectedDeviceSharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       /* val allDevicesViewModel =
            ViewModelProvider(this).get(AllDevicesViewModel::class.java)*/

        _binding = FragmentAllDevicesBinding.inflate(inflater, container, false)

        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addButton.setOnClickListener {
            findNavController().navigate(AllDevicesFragmentDirections.actionAllDevicesFragmentToAddDeviceFragment())
        }


        val adapter = DevicesAdapter(mutableListOf(),object : DevicesAdapter.Callbacks{
            override fun onDeviceSeleted(device: Device) {
                selectedDeviceSharedViewModel.selectDevice(device)
                findNavController().navigate(AllDevicesFragmentDirections.actionAllDevicesFragmentToSingleDeviceFragment())
            }

        })
         binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        allDevicesViewModel.devices.observe(viewLifecycleOwner){
            adapter.devicesList = it
            adapter.notifyDataSetChanged()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


