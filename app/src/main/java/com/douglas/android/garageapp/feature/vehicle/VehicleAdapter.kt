package com.douglas.android.garageapp.feature.vehicle

import android.annotation.SuppressLint
import android.system.Os.bind
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.douglas.android.garageapp.R
import kotlinx.android.synthetic.main.vehicle_item.view.*

@SuppressLint("SetTextI18n")
class VehicleAdapter : RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>() {

    private val vehicles = mutableListOf<VehicleModel>()

    fun load(vehicles: List<VehicleModel>) {
        this.vehicles.clear()
        this.vehicles.addAll(vehicles)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.vehicle_item, parent, false)
        return VehicleViewHolder(itemView)
    }

    override fun getItemCount() = vehicles.size

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        holder.bind(vehicles[position])
    }

    class VehicleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(vehicle: VehicleModel) {
            with(itemView) {
                vehicleItemBrand.text = vehicle.brand
                vehicleItemModel.text = vehicle.model
                vehicleItemRegistration.text = vehicle.registration
                vehicleItemMileage.text = "${vehicle.mileage} KM"
            }
        }
    }
}