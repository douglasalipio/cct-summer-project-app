package com.douglas.android.domain.veichle

class Vehicle(val id: String, val registration: String, val make: String, model: String, mileage: String)

sealed class VehicleResult {
    data class Success(val linesStatus: List<Vehicle>) : VehicleResult()
    object Error : VehicleResult()
}