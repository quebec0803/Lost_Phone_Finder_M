package com.ken.phone.app.lostphonefinder.ui.message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ken.phone.app.lostphonefinder.R
import com.ken.phone.app.lostphonefinder.databinding.FragmentLocateBinding
import com.ken.phone.app.lostphonefinder.databinding.FragmentMessageBinding


class MessageFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    lateinit var binding: FragmentMessageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMessageBinding.inflate(inflater,container,false)
        return binding.root
    }

}