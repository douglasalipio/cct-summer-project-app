package com.douglas.android.garageapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.douglas.android.garageapp.feature.vehicle.VehicleDialogFragment
import kotlinx.android.synthetic.main.fragment_bottomsheet.*

class GarageSheetDialog : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottomsheet, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navigation_view.setNavigationItemSelectedListener { menuItem ->

            when (menuItem.itemId) {
                R.id.addVehicleItem -> {
                    activity?.let {
                        val bottomNavDrawerFragment = VehicleDialogFragment()
                        bottomNavDrawerFragment.show(it.supportFragmentManager, bottomNavDrawerFragment.tag)
                    }
                }
            }
            true
        }
    }
}