package com.douglas.android.garageapp.features.vehicle

import android.content.Context
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.BufferedReader

@IgnoreExtraProperties
data class VehicleModel(
    var uuid: String = "",
    var registration: String = "",
    var brand: String = "",
    var model: String = "",
    var mileage: String = ""
)

data class InfoModel(
    @SerializedName("brand")
    @Expose
    var brand: String = "",
    @SerializedName("models")
    @Expose
    var models: List<String> = listOf()
)

fun infoModelMapper(context: Context): List<InfoModel> {
    val carListJson = context.assets.open("car_list.json").bufferedReader().use(BufferedReader::readText)
    val gson = GsonBuilder().create()
    val infoModels = gson.fromJson(carListJson, Array<InfoModel>::class.java).toList()
    return infoModels
}

