package com.douglas.android.garageapp.features.vehicle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.douglas.android.garageapp.R
import com.douglas.android.garageapp.components.SwipeToDeleteCallback
import com.douglas.android.garageapp.misc.AppExecutors.Companion.uiContext
import com.douglas.android.garageapp.misc.launchSilent
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
        setUpToolbar()
    }

    private fun setUpToolbar() {
        activity?.title = "Vehicles"
    }

    private fun initComponent() {
        vehicleRecyclerView?.apply {
            layoutManager = LinearLayoutManager(context!!)
            adapter = vehicleAdapter
            setHasFixedSize(true)
        }
        addVehicleButton.setOnClickListener { findNavController().navigate(R.id.actionVehicleToVehicleDetailFragment) }
        loadVehicle()
        initDeleteVehicle()
    }

    private fun initDeleteVehicle() {
        val swipeHandler = object : SwipeToDeleteCallback(context!!) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val vehicleModel = vehicleAdapter.getAt(position)
                deleteVehicle(vehicleModel)
                vehicleAdapter.removeAt(position)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        vehicleRecyclerView?.let { itemTouchHelper.attachToRecyclerView(it) }

    }

    private fun deleteVehicle(vehicleModel: VehicleModel) {
        val applesQuery = databaseReference
            .child("vehicleModel").orderByChild("uuid").equalTo(vehicleModel.uuid)

        applesQuery.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (appleSnapshot in dataSnapshot.children) {
                    appleSnapshot.ref.removeValue()
                    vehicleAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                toast("Something wrong...")
            }
        })
    }

    private fun loadVehicle() {
        launchSilent(uiContext) {
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
}
