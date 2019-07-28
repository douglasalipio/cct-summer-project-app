package com.douglas.android.data.vehicle.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VehicleModel(val uuid: String, val registration: String, val make: String, val model: String, val mileage: String)

data class VehicleInfoModel(
    @SerializedName("brand")
    @Expose
    var brand: String = "",
    @SerializedName("models")
    @Expose
    var models: List<String> = listOf()
)