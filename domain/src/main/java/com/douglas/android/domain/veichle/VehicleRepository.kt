package com.douglas.android.domain.veichle

import com.douglas.android.domain.veichle.model.VehicleResult

interface VehicleRepository {

    suspend fun getVehicle(): VehicleResult
}