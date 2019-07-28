package com.douglas.android.data.vehicle

import com.douglas.android.data.vehicle.model.VehicleModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface VehicleService {

    @GET("Line/Mode/tube/Status")
    fun getVehicle(): Deferred<List<VehicleModel>>
}