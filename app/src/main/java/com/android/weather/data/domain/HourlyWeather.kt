package com.android.weather.data.domain

data class HourlyWeather(
    val time: List<String>,
    val temperature_2m: List<Double>,
    val relative_humidity_2m: List<Int>,
    val showers: List<Double>,
    val snowfall: List<Double>,
    val weather_code: List<Int>,
    val cloud_cover: List<Int>
)
