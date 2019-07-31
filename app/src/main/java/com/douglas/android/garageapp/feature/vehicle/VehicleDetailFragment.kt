package com.douglas.android.garageapp.feature.vehicle

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.douglas.android.garageapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.vehicle_detail_fragment.*


class VehicleDetailFragment : BottomSheetDialogFragment() {

    private val database = FirebaseDatabase.getInstance().reference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.vehicle_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveVehicleButton.setOnClickListener { saveVehicle() }
    }

    private fun saveVehicle() {
        val key = database.child("vehicle").push().key
        val vehicle = VehicleModel(
            registration = vehicleBrand?.text.toString(),
            brand = vehicleBrand?.text.toString(),
            model = vehicleModel?.text.toString(),
            mileage = vehicleMileage?.text.toString()
        )
        runCatching {
            key?.let {
                vehicle.uuid = key
                database.child("vehicle").child(key).setValue("vehicle")
            }
        }

    }
}