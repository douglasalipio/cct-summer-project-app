package com.douglas.android.garageapp.feature.vehicle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController


import com.douglas.android.garageapp.R
import kotlinx.android.synthetic.main.vehicle_fragment.*


class VehicleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.vehicle_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        addVehicleButton.setOnClickListener { findNavController().navigate(R.id.actionVehicleToVehicleDetailFragment) }
    }
}
