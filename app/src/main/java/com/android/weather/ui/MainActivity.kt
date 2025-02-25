package com.android.weather.ui

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.android.weather.data.domain.HourlyUnits
import com.android.weather.data.domain.HourlyWeather
import com.android.weather.data.domain.Location
import com.android.weather.data.domain.WeatherResponse
import com.android.weather.databinding.ActivityMainBinding
import com.android.weather.util.Constants
import com.android.weather.util.Forecast
import com.android.weather.util.Helper
import com.android.weather.util.LocationHelper
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.io.IOException

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val LOG_TAG: String = Constants.LOG_TAG_NAMES.MainActivity_LOG_TAG
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate

    var currentLocation: Location = Location("Cairo ,", " ", 27.0,30.0)

    val interceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun setup() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        getCurrentLocation()
    }

    override fun callbacks() {

        log("hello")
    }

    private fun makeAPIRequest(){
        val url:HttpUrl = getUrl()

        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                log(e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                log("sucess")
                response.body?.string()?.let { responseString->
                    log(responseString)
                    val result= Gson().fromJson(responseString,WeatherResponse::class.java)
                    runOnUiThread {
                        binding?.apply {
                            progressBar.visibility = View.GONE
                        }
                        bindData(result)
                        val adapterList = Helper.NextHoursAday(result.hourlyWeather, result.currentWeather.time)
                        bindHourlyAdapter(
                            adapterList,
                            result.hourly_units,
                            result.dailyWeather.sunrise[0],
                            result.dailyWeather.sunset[0]
                        )
                        bindDailyAdapter(result)
                    }
                }

            }

        })
    }

    private fun getUrl(): HttpUrl {

        return HttpUrl.Builder()
            .scheme("https")
            .host("api.open-meteo.com")
            .addPathSegment("v1")
            .addPathSegment("forecast")
            .addQueryParameter("latitude", currentLocation.latitude.toString())
            .addQueryParameter("longitude", currentLocation.longitude.toString())
            .addQueryParameter(
                "current",
                "temperature_2m,relative_humidity_2m,is_day,rain,showers,snowfall,weather_code,cloud_cover,wind_speed_10m"
            )
            .addQueryParameter(
                "hourly",
                "temperature_2m,relative_humidity_2m,showers,snowfall,weather_code,cloud_cover"
            )
            .addQueryParameter(
                "daily",
                "weather_code,temperature_2m_max,temperature_2m_min,sunrise,sunset,rain_sum,showers_sum,snowfall_sum"
            ) // Removed extra commas
            .addQueryParameter("timezone", "auto") // No need to manually encode
            .build()
    }


    fun bindData(Data: WeatherResponse){
        binding?.apply {
            currentCity.text = currentLocation.cityName
            timeZone.text = Data.timezone_abbreviation
            currentTemp.text = Data.currentWeather.temperature_2m.toInt().toString()
            currentDate.text = Helper.formatCurrentDateTime(Data.currentWeather.time)
            tempUnit.text = Data.current_units.temperature_2m
            tempUnit1.text = Data.current_units.temperature_2m
            tempUnit2.text = Data.current_units.temperature_2m
            todayMaxTemp.text = Data.dailyWeather.temperature_2m_max[0].toInt().toString()
            todayMinTemp.text = Data.dailyWeather.temperature_2m_min[0].toInt().toString()
            currentForecastName.text = Forecast.getForecastName(Data.currentWeather.weather_code)
            val img = ContextCompat.getDrawable(
                this@MainActivity,
                Forecast.getForecastPng(
                    Data.currentWeather.weather_code,
                    Data.currentWeather.is_day
                )
            )
            currentForecastImg.setImageDrawable(img)
        }
    }

    fun bindHourlyAdapter(Data: HourlyWeather, units: HourlyUnits, sunrise: String, sunset:String){
        val adapter = HourlyForecastAdapter(this@MainActivity, Data, units, sunrise, sunset)
        binding?.hourlyRecycler?.adapter = adapter
    }

    fun bindDailyAdapter(Data: WeatherResponse){
        val adapter = DailyForecastAdapter(this@MainActivity, Data)
        binding?.dailyRecycler?.adapter = adapter
    }

    fun getCurrentLocation(){

        log("in get current location")

        if (!checkPermission()) {
            requestPermission()
            return
        }
        if (!isLocationEnabled()) {
            log("Turn on Location")
            Toast.makeText(this, "Turn on Location", Toast.LENGTH_SHORT).show()
            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            startActivity(intent)
            return
        }

        fusedLocationProviderClient.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, null)
            .addOnSuccessListener { location ->
                if (location != null) {
                    log("location is right")
                    //Toast.makeText(this,"get sucessfully",Toast.LENGTH_SHORT).show()
                    currentLocation = LocationHelper.getCityNameAndAddress(
                        this,
                        location.latitude.toDouble(),
                        location.longitude.toDouble()
                    )

                    log("Latitude: ${currentLocation.latitude}")
                    log("Longitude: ${currentLocation.longitude}")
                    log("city: ${currentLocation.cityName}")
                    log("address: ${currentLocation.address}")

                    makeAPIRequest()

                } else {
                    log("location null")
                    Toast.makeText(this,"Null Recieved",Toast.LENGTH_SHORT).show()

                    makeAPIRequest()
                }
            }

    }

    private fun isLocationEnabled(): Boolean{
        val locationManager: LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION),
            Constants.PERMISSION_CODE.PERMISSION_REQUEST_ACCESS_LOCATION)
    }

    private fun checkPermission(): Boolean {

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        )
        {
            return true
        }
        return false
    }


}