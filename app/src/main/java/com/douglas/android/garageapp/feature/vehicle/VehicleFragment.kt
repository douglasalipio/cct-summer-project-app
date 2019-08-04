package com.douglas.android.garageapp.feature.vehicle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import com.douglas.android.garageapp.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.vehicle_fragment.*
import org.jetbrains.anko.support.v4.toast


class VehicleFragment : Fragment() {

    private val vehicleAdapter = VehicleAdapter()
    private val databaseReference = FirebaseDatabase.getInstance().reference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.vehicle_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initComponent()
    }

    private fun initComponent() {
        vehicleRecyclerView?.layoutManager = LinearLayoutManager(context)
        vehicleRecyclerView?.adapter = vehicleAdapter
        addVehicleButton.setOnClickListener { findNavController().navigate(R.id.actionVehicleToVehicleDetailFragment) }
        loadVehicle()
    }

    private fun loadVehicle() {
        databaseReference.child("vehicleModel").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                toast("Database error: $databaseError.message")
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val vehicles = dataSnapshot.children.mapNotNull { it.getValue(VehicleModel::class.java) }
                vehicleAdapter.load(vehicles)
            }
        })
    }
}
