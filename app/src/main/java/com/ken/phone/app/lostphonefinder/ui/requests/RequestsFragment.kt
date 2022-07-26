package com.ken.phone.app.lostphonefinder.ui.requests

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ken.phone.app.lostphonefinder.R
import com.ken.phone.app.lostphonefinder.databinding.FragmentMessageBinding
import com.ken.phone.app.lostphonefinder.databinding.FragmentRequestsBinding


class RequestsFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    lateinit var binding: FragmentRequestsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRequestsBinding.inflate(inflater,container,false)
        return binding.root
    }


}