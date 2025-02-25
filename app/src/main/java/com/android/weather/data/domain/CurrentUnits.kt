package com.android.weather.data.domain

data class CurrentUnits(
    val time: String,
    val interval: String,
    val temperature_2m: String,
    val relative_humidity_2m: String,
    val is_day: String,
    val rain: String,
    val showers: String,
    val snowfall: String,
    val weather_code: String,
    val cloud_cover: String,
    val wind_speed_10m: String
)
