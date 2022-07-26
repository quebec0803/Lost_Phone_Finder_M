package com.ken.phone.app.lostphonefinder.ui.add_device

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ken.phone.app.lostphonefinder.R
import com.ken.phone.app.lostphonefinder.databinding.FragmentAddDeviceBinding
import com.ken.phone.app.lostphonefinder.databinding.FragmentStatusBinding


class AddDeviceFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    lateinit var binding: FragmentAddDeviceBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddDeviceBinding.inflate(inflater,container,false)
        return binding.root
    }


}