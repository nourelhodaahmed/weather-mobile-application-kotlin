package com.android.weather.data.domain


data class Location(
    var cityName: String,
    var address: String,
    var latitude: Double,
    var longitude: Double
)
