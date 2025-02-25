package com.android.weather.util

import android.content.Context
import android.location.Geocoder
import android.widget.Toast
import com.android.weather.data.domain.Location
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

object LocationHelper {


     fun getCityNameAndAddress(context: Context,latitude: Double, longitude: Double) :Location{
        val geocoder = Geocoder(context, Locale.getDefault())
         var cityName = ""
         var address = ""
        try {
            val addresses = geocoder.getFromLocation(latitude, longitude, 1)
            if (!addresses.isNullOrEmpty()) {
                cityName = addresses[0].locality ?: "Unknown City"
                address = addresses[0].getAddressLine(0) ?: "Unknown Address"

                //Toast.makeText(context, "City: $cityName\nAddress: $address", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, "No address found", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
         return Location(cityName + ", ", address, latitude, longitude)
    }


}