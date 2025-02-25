package com.android.weather.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.android.weather.R
import com.android.weather.data.domain.HourlyUnits
import com.android.weather.data.domain.HourlyWeather
import com.android.weather.databinding.HourlyForecastItemBinding
import com.android.weather.util.Forecast
import com.android.weather.util.Helper

class HourlyForecastAdapter(
    private val context: Context,
    val response: HourlyWeather,
    val units: HourlyUnits,
    val sunrise:String,
    val sunset:String
):RecyclerView.Adapter<HourlyForecastAdapter.HourlyForecastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyForecastViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.hourly_forecast_item,
            parent,
            false
        )
        return HourlyForecastViewHolder(view)
    }

    override fun getItemCount(): Int {
        return response.time.size
    }

    override fun onBindViewHolder(holder: HourlyForecastViewHolder, position: Int) {
        holder.binding.apply {
            hourlyTime.text = Helper.formatHour12Hour(response.time[position])
            hourlyTemp.text = response.temperature_2m[position].toInt().toString()
            hourlyTempUnit.text = units.temperature_2m

            val img = ContextCompat.getDrawable(
                context,
                Forecast.getForecastPng(
                    response.weather_code[position],
                    Helper.isDayOrNight(
                        response.time[position],
                        sunrise,
                        sunset
                    )
                )
            )
            hourlyForecastImg.setImageDrawable(img)
        }
    }

    class HourlyForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = HourlyForecastItemBinding.bind(itemView)
    }

}