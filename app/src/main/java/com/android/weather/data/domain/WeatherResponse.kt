package com.android.weather.data.domain

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    val latitude: Double,
    val longitude: Double,
    val generationtime_ms: Double,
    val utc_offset_seconds: Int,
    val timezone: String,
    val timezone_abbreviation: String,
    val elevation: Double,
    val current_units: CurrentUnits,
    @SerializedName("current") val currentWeather: CurrentWeather,
    val hourly_units: HourlyUnits,
    @SerializedName("hourly") val hourlyWeather: HourlyWeather,
    val daily_units: DailyUnits,
    @SerializedName("daily") val dailyWeather: DailyWeather
)
