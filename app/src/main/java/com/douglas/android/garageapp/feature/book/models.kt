package com.douglas.android.garageapp.feature.book

import java.util.*

data class BookModel(
    var uuid: String= "",
    var bookPrice: String = "",
    var bookStatus: String = "Booked",
    var bookVehicle: String = "",
    var bookDate: String = ""
)