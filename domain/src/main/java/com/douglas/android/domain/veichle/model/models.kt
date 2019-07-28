package com.douglas.android.domain.veichle.model

data class Vehicle(val uuid: String, val registration: String, val make: String, val model: String, val mileage: String)

sealed class VehicleResult {
    data class Success(val vehicles: List<Vehicle>) : VehicleResult()
    object Error : VehicleResult()
}

