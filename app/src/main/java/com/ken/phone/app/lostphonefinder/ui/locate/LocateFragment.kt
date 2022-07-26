package com.ken.phone.app.lostphonefinder.ui.locate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ken.phone.app.lostphonefinder.R
import com.ken.phone.app.lostphonefinder.databinding.FragmentLocateBinding

class LocateFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    lateinit var binding: FragmentLocateBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocateBinding.inflate(inflater,container,false)
        return binding.root
    }

}