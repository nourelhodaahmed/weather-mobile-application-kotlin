package com.android.weather.util

object Forecast {

    fun getForecastPng(weatherCode : Int, isDay : Int):Int{
        return when(weatherCode){
            Constants.ForecastCode.CLEAR_SKY -> {
                if (isDay == 1) Constants.ForecastLogo.CLEAR_SKY else Constants.ForecastLogo.CLEAR_SKY_NIGHT
            }
            Constants.ForecastCode.MAINLY_CLEAR ->{
                if (isDay == 1) Constants.ForecastLogo.MAINLY_CLEAR else Constants.ForecastLogo.MAINLY_CLEAR_NIGHT
            }
            Constants.ForecastCode.FOG -> Constants.ForecastLogo.FOG
            Constants.ForecastCode.DRIZZLE_HIGH -> Constants.ForecastLogo.DRIZZLE_HIGH
            Constants.ForecastCode.DRIZZLE_MODERATE ->{
                if (isDay == 1) Constants.ForecastLogo.DRIZZLE_MODERATE else Constants.ForecastLogo.DRIZZLE_MODERATE_NIGHT
            }
            Constants.ForecastCode.DRIZZLE_LIGHT -> Constants.ForecastLogo.DRIZZLE_LIGHT
            Constants.ForecastCode.DEPOSITING_RIME_FOG -> Constants.ForecastLogo.DEPOSITING_RIME_FOG
            Constants.ForecastCode.FREEZING_DRIZZLE_HIGHT -> Constants.ForecastLogo.FREEZING_DRIZZLE_HIGHT
            Constants.ForecastCode.FREEZING_DRIZZLE_LIGHT -> Constants.ForecastLogo.FREEZING_DRIZZLE_LIGHT
            Constants.ForecastCode.FREEZING_RAIN_HIGH -> Constants.ForecastLogo.FREEZING_RAIN_HIGH
            Constants.ForecastCode.FREEZING_RAIN_LIGHT -> Constants.ForecastLogo.FREEZING_RAIN_LIGHT
            Constants.ForecastCode.OVERCAST -> Constants.ForecastLogo.OVERCAST
            Constants.ForecastCode.PARTLY_CLOUD ->{
                if (isDay == 1) Constants.ForecastLogo.PARTLY_CLOUD else Constants.ForecastLogo.PARTLY_CLOUD_NIGHT
            }
            Constants.ForecastCode.RAIN_HEAVY -> Constants.ForecastLogo.RAIN_HEAVY
            Constants.ForecastCode.RAIN_LIGHT -> Constants.ForecastLogo.RAIN_LIGHT
            Constants.ForecastCode.RAIN_MODERATE -> Constants.ForecastLogo.RAIN_MODERATE
            Constants.ForecastCode.RAIN_SHOWER_HEAVY -> Constants.ForecastLogo.RAIN_SHOWER_HEAVY
            Constants.ForecastCode.RAIN_SHOWER_LIGHT -> Constants.ForecastLogo.RAIN_SHOWER_LIGHT
            Constants.ForecastCode.RAIN_SHOWER_MODRATE -> Constants.ForecastLogo.RAIN_SHOWER_MODRATE
            Constants.ForecastCode.SNOW_GRAINS -> Constants.ForecastLogo.SNOW_GRAINS
            Constants.ForecastCode.SNOW_MODERATE -> Constants.ForecastLogo.SNOW_MODERATE
            Constants.ForecastCode.SNOW_LIGHT -> Constants.ForecastLogo.SNOW_LIGHT
            Constants.ForecastCode.SNOW_HEAVY -> Constants.ForecastLogo.SNOW_HEAVY
            Constants.ForecastCode.SNOW_SHOWER_HEAVY -> Constants.ForecastLogo.SNOW_SHOWER_HEAVY
            Constants.ForecastCode.SNOW_SHOWER_LIGHT -> Constants.ForecastLogo.SNOW_SHOWER_LIGHT
            Constants.ForecastCode.THUNDER_STORM -> Constants.ForecastLogo.THUNDER_STORM
            Constants.ForecastCode.THUNDER_STORM_HAIL_HEAVY -> Constants.ForecastLogo.THUNDER_STORM_HAIL_HEAVY
            Constants.ForecastCode.THUNDER_STORM_HAIL_LIGHT -> Constants.ForecastLogo.THUNDER_STORM_HAIL_LIGHT
            else -> Constants.ForecastLogo.CLEAR_SKY
        }
    }

    fun getForecastName(weatherCode : Int):String{
        return when(weatherCode){
            Constants.ForecastCode.CLEAR_SKY -> "CLEAR SKY"
            Constants.ForecastCode.MAINLY_CLEAR ->"MAINLY CLEAR"
            Constants.ForecastCode.FOG -> "FOG"
            Constants.ForecastCode.DRIZZLE_HIGH -> "DRIZZLE HIGH"
            Constants.ForecastCode.DRIZZLE_MODERATE ->"DRIZZLE MODERATE"
            Constants.ForecastCode.DRIZZLE_LIGHT -> "DRIZZLE LIGHT"
            Constants.ForecastCode.DEPOSITING_RIME_FOG -> "RIME FOG"
            Constants.ForecastCode.FREEZING_DRIZZLE_HIGHT -> "HIGH FREEZING DRIZZLE"
            Constants.ForecastCode.FREEZING_DRIZZLE_LIGHT -> "LIGHT FREEZING DRIZZLE"
            Constants.ForecastCode.FREEZING_RAIN_HIGH -> "HIGH FREEZING RAIN"
            Constants.ForecastCode.FREEZING_RAIN_LIGHT -> "LIGHT REEZING RAIN"
            Constants.ForecastCode.OVERCAST -> "CLOUDY"
            Constants.ForecastCode.PARTLY_CLOUD -> "PARTLY CLOUD"
            Constants.ForecastCode.RAIN_HEAVY -> "HEAVY RAIN"
            Constants.ForecastCode.RAIN_LIGHT -> "LIGHT RAIN"
            Constants.ForecastCode.RAIN_MODERATE -> "MODERATE RAIN"
            Constants.ForecastCode.RAIN_SHOWER_HEAVY -> "HEAVY RAIN SHOWER"
            Constants.ForecastCode.RAIN_SHOWER_LIGHT -> "LIGHT RAIN SHOWER"
            Constants.ForecastCode.RAIN_SHOWER_MODRATE -> "MODRATE RAIN SHOWER"
            Constants.ForecastCode.SNOW_GRAINS -> "SNOW GRAINS"
            Constants.ForecastCode.SNOW_MODERATE -> "MODERATE SNOW"
            Constants.ForecastCode.SNOW_LIGHT -> "LIGHT SNOW"
            Constants.ForecastCode.SNOW_HEAVY -> "HEAVY SNOW"
            Constants.ForecastCode.SNOW_SHOWER_HEAVY -> "HEAVY SNOW SHOWER"
            Constants.ForecastCode.SNOW_SHOWER_LIGHT -> "LIGHT SNOW SHOWER"
            Constants.ForecastCode.THUNDER_STORM -> "THUNDER STORM"
            Constants.ForecastCode.THUNDER_STORM_HAIL_HEAVY -> "HEAVY THUNDER STORM"
            Constants.ForecastCode.THUNDER_STORM_HAIL_LIGHT -> "LIGHT THUNDER STORM"
            else -> "CLEAR SKY"
        }
    }

}