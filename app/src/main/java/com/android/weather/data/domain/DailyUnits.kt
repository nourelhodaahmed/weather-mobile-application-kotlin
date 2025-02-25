package com.android.weather.data.domain

data class DailyUnits(
    val time: String,
    val weather_code: String,
    val temperature_2m_max: String,
    val temperature_2m_min: String,
    val sunrise: String,
    val sunset: String,
    val rain_sum: String,
    val showers_sum: String,
    val snowfall_sum: String
)
