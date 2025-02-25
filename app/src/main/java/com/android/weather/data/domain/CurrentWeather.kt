package com.android.weather.data.domain

data class CurrentWeather(
    val time: String,
    val interval: Int,
    val temperature_2m: Double,
    val relative_humidity_2m: Int,
    val is_day: Int,
    val rain: Double,
    val showers: Double,
    val snowfall: Double,
    val weather_code: Int,
    val cloud_cover: Int,
    val wind_speed_10m: Double
)