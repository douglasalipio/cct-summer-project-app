package com.douglas.android.garageapp.features.vehicle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.navArgs
import com.douglas.android.garageapp.R
import com.douglas.android.garageapp.misc.AppExecutors.Companion.uiContext
import com.douglas.android.garageapp.misc.launchSilent
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.vehicle_detail_fragment.*
import kotlinx.android.synthetic.main.vehicle_detail_fragment.vehicleMileage
import org.jetbrains.anko.support.v4.toast


class VehicleDetailFragment : BottomSheetDialogFragment() {

    private val databaseReference = FirebaseDatabase.getInstance().reference
    private val args: VehicleDetailFragmentArgs by navArgs()
    private val defaultBrands = mutableListOf<InfoModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.vehicle_detail_fragment, container, false)
        defaultBrands.addAll(infoModelMapper(view.context))
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveVehicleButton.setOnClickListener { saveVehicle() }
        iniComponents()
        loadVehicle()
    }

    private fun iniComponents() {
        val brandsNames = mutableListOf<String>()
        defaultBrands.forEach { brand -> brandsNames.add(brand.brand) }
        val brandAdapter = ArrayAdapter(context, R.layout.dropdown_book_service_item, brandsNames)
        vehicleBrand?.setAdapter(brandAdapter)
        vehicleBrand?.setOnItemClickListener { parent, view, position, id ->
            val modelAdapter =
                ArrayAdapter(context, R.layout.dropdown_book_service_item, defaultBrands[position].models)
            vehicleModel?.setAdapter(modelAdapter)
        }
    }

    private fun loadVehicle() {
        if (args.vehicleId > 0) {
            databaseReference.child(args.vehicleId.toString()).addValueEventListener(object : ValueEventListener {
                override fun onCancelled(databaseError: DatabaseError) {
                    toast("Database error: $databaseError.message")
                }

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val vehicleSelected = dataSnapshot.getValue(VehicleModel::class.java)
                }
            })
        }
    }

    private fun saveVehicle() {
        val key = databaseReference.child("vehicleModel").push().key
        val vehicle = VehicleModel(
            registration = vehicleRegister?.text.toString(),
            brand = vehicleBrand?.text.toString(),
            model = vehicleModel?.text.toString(),
            mileage = vehicleMileage?.text.toString()
        )
        launchSilent(uiContext) {
            key?.let {
                vehicle.uuid = key
                databaseReference.child("vehicleModel").child(key).setValue(vehicle)
                dismiss()
            }
        }
    }
}