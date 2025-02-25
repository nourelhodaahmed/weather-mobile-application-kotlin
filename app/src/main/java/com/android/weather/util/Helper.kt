package com.android.weather.util

import com.android.weather.data.domain.HourlyWeather
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

object Helper {

    fun formatCurrentDateTime(dateTimeString: String): String {
        // Define the input format
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")

        // Parse the input string to LocalDateTime
        val dateTime = LocalDateTime.parse(dateTimeString, inputFormatter)

        // Get the current date
        val today = LocalDateTime.now(ZoneId.systemDefault()).toLocalDate()

        // Check if the date is today
        val dayLabel = if (dateTime.toLocalDate() == today) "Today" else dateTime.format(DateTimeFormatter.ofPattern("dd MMM"))

        // Define the output format
        val outputFormatter = DateTimeFormatter.ofPattern("h:mm a")

        // Format and return the result
        return "$dayLabel, ${dateTime.format(DateTimeFormatter.ofPattern("ddMMM"))} ${dateTime.format(outputFormatter)}"
    }

    fun formatDailyDate(inputDate: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd MMM", Locale.getDefault()) // "MMM" gives month abbreviation

        val date = inputFormat.parse(inputDate)
        return outputFormat.format(date ?: return "Invalid Date").uppercase()
    }

    fun formatHour12Hour(timeString: String): String {
        // Define the date-time format
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")

        // Parse the input string into LocalDateTime
        val dateTime = LocalDateTime.parse(timeString, formatter)

        // Format it into 12-hour format with leading zeros (hh:mm a -> e.g., 06:00 PM)
        val outputFormatter = DateTimeFormatter.ofPattern("hh:mm a") // 'hh' ensures leading zero

        return dateTime.format(outputFormatter)
    }

    fun isDayOrNight(dateTimeString: String, sunriseString: String, sunsetString: String): Int {
        // Define formatter for full date-time strings
        val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")

        // Parse input time, sunrise, and sunset
        val dateTime = LocalDateTime.parse(dateTimeString, dateTimeFormatter)
        val sunrise = LocalDateTime.parse(sunriseString, dateTimeFormatter).toLocalTime()
        val sunset = LocalDateTime.parse(sunsetString, dateTimeFormatter).toLocalTime()

        // Extract the time part of dateTime
        val currentTime = dateTime.toLocalTime()

        // Check if it's day or night
        return if (currentTime.isAfter(sunrise) && currentTime.isBefore(sunset)) 1 else 0
    }

    fun isSameDayAndHourAfterOrEqual(dateTime1: String, dateTime2: String): Boolean {
        // Define the date-time formatter
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")

        // Parse both date-time strings
        val dt1 = LocalDateTime.parse(dateTime1, formatter)
        val dt2 = LocalDateTime.parse(dateTime2, formatter)

        // Check if they are on the same day
        val sameDay = dt1.toLocalDate().isEqual(dt2.toLocalDate())

        // Check if dt1 is after or equal to dt2 (including minutes)
        val timeAfterOrEqual = dt1.isAfter(dt2) || dt1.isEqual(dt2)

        return sameDay && timeAfterOrEqual
    }

    fun NextHoursAday(hourlyWeather: HourlyWeather, currentTime: String): HourlyWeather {

        var time: MutableList<String> = mutableListOf<String>()
        var temperature_2m: MutableList<Double> = mutableListOf<Double>()
        var relative_humidity_2m: MutableList<Int> = mutableListOf<Int>()
        var showers: MutableList<Double> = mutableListOf<Double>()
        var snowfall: MutableList<Double> = mutableListOf<Double>()
        var weather_code: MutableList<Int> = mutableListOf<Int>()
        var cloud_cover: MutableList<Int> = mutableListOf<Int>()

        for(i in 0 until hourlyWeather.time.size){
            if(Helper.isSameDayAndHourAfterOrEqual(hourlyWeather.time[i], currentTime)) {
                time.add(hourlyWeather.time[i])
                temperature_2m.add(hourlyWeather.temperature_2m[i])
                relative_humidity_2m.add(hourlyWeather.relative_humidity_2m[i])
                showers.add(hourlyWeather.showers[i])
                snowfall.add(hourlyWeather.snowfall[i])
                weather_code.add(hourlyWeather.weather_code[i])
                cloud_cover.add(hourlyWeather.cloud_cover[i])
            }
        }
        return HourlyWeather(time,temperature_2m,relative_humidity_2m, showers, snowfall, weather_code, cloud_cover)
    }


}