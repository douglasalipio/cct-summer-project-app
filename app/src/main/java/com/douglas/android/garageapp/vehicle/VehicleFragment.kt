package com.douglas.android.garageapp.vehicle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.douglas.android.garageapp.R
import kotlinx.android.synthetic.main.vehicle_fragment.*

class VehicleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.vehicle_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vehicleFloatButton.setOnClickListener {
           // view.findNavController().navigate(R.id.vehicleFragment_to_vehicleDetailFragment)

        }
    }

}
