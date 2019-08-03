package com.douglas.android.garageapp.feature.vehicle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.douglas.android.garageapp.R
import com.douglas.android.garageapp.misc.AppExecutors.Companion.uiContext
import com.douglas.android.garageapp.misc.launchSilent
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.book_detail_fragment.*
import kotlinx.android.synthetic.main.vehicle_detail_fragment.*
import kotlinx.android.synthetic.main.vehicle_detail_fragment.vehicleMileage
import org.jetbrains.anko.support.v4.toast


class VehicleDetailFragment : BottomSheetDialogFragment() {

    private val databaseReference = FirebaseDatabase.getInstance().reference

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
        val key = databaseReference.child("vehicleModel").push().key
        val vehicle = VehicleModel(
            registration = vehicleBrand?.text.toString(),
            brand = vehicleBrand?.text.toString(),
            model = vehicleModel?.text.toString(),
            mileage = vehicleMileage?.text.toString()
        )
        launchSilent(uiContext) {
            key?.let {
                vehicle.uuid = key
                databaseReference.child("vehicleModel").child(key).setValue(vehicle).addOnCompleteListener {
                    if (it.isSuccessful)
                        dismiss()
                    else
                        toast(it.exception?.message.toString())
                }
            }
        }
    }
}