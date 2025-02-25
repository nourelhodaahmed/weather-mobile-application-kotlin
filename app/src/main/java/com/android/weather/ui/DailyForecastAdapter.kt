package com.android.weather.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.android.weather.R
import com.android.weather.data.domain.WeatherResponse
import com.android.weather.databinding.DailyForecastItemBinding
import com.android.weather.util.Forecast
import com.android.weather.util.Helper

class DailyForecastAdapter(private val context: Context, val weatherResponse: WeatherResponse)
    :RecyclerView.Adapter<DailyForecastAdapter.DailyForecastViewHolder>() {

    class DailyForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = DailyForecastItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyForecastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.daily_forecast_item,
            parent,
            false
        )
        return DailyForecastViewHolder(view)
    }

    override fun getItemCount(): Int {
        return weatherResponse.dailyWeather.time.size - 1
    }

    override fun onBindViewHolder(holder: DailyForecastViewHolder, position: Int) {
        holder.binding.apply {
            dailyDate.text = Helper.formatDailyDate(weatherResponse.dailyWeather.time[position+1])
            dailyMaxTemp.text = weatherResponse.dailyWeather.temperature_2m_max[position+1].toInt().toString()
            dailyMinTemp.text = weatherResponse.dailyWeather.temperature_2m_min[position+1].toInt().toString()
            tempUnit1.text = weatherResponse.daily_units.temperature_2m_max
            tempUnit2.text = weatherResponse.daily_units.temperature_2m_max
            dailyForecastName.text = Forecast.getForecastName(weatherResponse.dailyWeather.weather_code[position+1])

            val img = ContextCompat.getDrawable(
                context,
                Forecast.getForecastPng(
                    weatherResponse.dailyWeather.weather_code[position+1],
                    1
                )
            )
            dailyForecastImg.setImageDrawable(img)

        }
    }
}