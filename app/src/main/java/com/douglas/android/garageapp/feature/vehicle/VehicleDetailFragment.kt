package com.douglas.android.garageapp.feature.vehicle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.douglas.android.garageapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class VehicleDetailFragment : BottomSheetDialogFragment() {

    fun newInstance(): Fragment {
        return VehicleDetailFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.vehicle_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}