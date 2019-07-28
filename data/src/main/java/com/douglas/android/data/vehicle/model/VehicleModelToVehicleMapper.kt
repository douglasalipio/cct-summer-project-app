package com.douglas.android.data.vehicle.model

import com.douglas.android.domain.Mapper
import com.douglas.android.domain.veichle.model.Vehicle

class VehicleModelToVehicleMapper : Mapper<VehicleModel, Vehicle> {

    override fun map(from: VehicleModel): Vehicle {
        return Vehicle(
            uuid = from.uuid,
            registration = from.registration,
            make = from.make,
            model = from.model,
            mileage = from.mileage
        )
    }
}