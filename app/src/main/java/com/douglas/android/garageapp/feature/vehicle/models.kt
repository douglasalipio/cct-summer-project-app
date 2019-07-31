package com.douglas.android.garageapp.feature.vehicle

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VehicleModel(var uuid: String = "", var registration: String, var brand: String, var model: String, var mileage: String)

data class VehicleInfoModel(
    @SerializedName("brand")
    @Expose
    var brand: String = "",
    @SerializedName("models")
    @Expose
    var models: List<String> = listOf()
)