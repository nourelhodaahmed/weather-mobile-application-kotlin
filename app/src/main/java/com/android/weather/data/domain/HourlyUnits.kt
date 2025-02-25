package com.android.weather.data.domain

data class HourlyUnits(
    val time: String,
    val temperature_2m: String,
    val relative_humidity_2m: String,
    val showers: String,
    val snowfall: String,
    val weather_code: String,
    val cloud_cover: String
)
