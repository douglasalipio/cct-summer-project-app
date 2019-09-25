package com.douglas.android.garageapp.features.book

data class BookModel(
    var uuid: String= "",
    var bookPrice: String = "",
    var bookStatus: String = "Booked",
    var bookVehicle: String = "",
    var bookDate: String = ""
)