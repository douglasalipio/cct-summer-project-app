package com.douglas.android.domain.veichle

import com.douglas.android.domain.veichle.model.VehicleResult

open class VehicleInteractor constructor(private val vehicleRepository: VehicleRepository) {

    suspend fun execute(): VehicleResult {
        return vehicleRepository.getVehicle()
    }
}
