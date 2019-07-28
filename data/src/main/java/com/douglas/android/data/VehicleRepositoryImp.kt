package com.douglas.android.data

import com.douglas.android.data.vehicle.VehicleService
import com.douglas.android.data.vehicle.model.VehicleModelToVehicleMapper
import com.douglas.android.domain.veichle.VehicleRepository
import com.douglas.android.domain.veichle.model.VehicleResult


class VehicleRepositoryImp constructor(
    private val vehicleService: VehicleService,
    private val mapper: VehicleModelToVehicleMapper
) : VehicleRepository {

    override suspend fun getVehicle(): VehicleResult =
        try {
            val linesStatus = vehicleService.getVehicle().await()
                .map { mapper.map(it) }
            VehicleResult.Success(linesStatus)
        } catch (throwable: Throwable) {
            VehicleResult.Error
        }
}