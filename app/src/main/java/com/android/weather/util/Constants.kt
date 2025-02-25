package com.android.weather.util

import com.android.weather.R

object Constants {

    object PERMISSION_CODE{
        const val PERMISSION_REQUEST_ACCESS_LOCATION = 100
    }

    object LOG_TAG_NAMES{
        const val MainActivity_LOG_TAG= "MAIN_ACTIVITY"
    }

    object ForecastLogo{
        val CLEAR_SKY = R.drawable.clear_sky
        val CLEAR_SKY_NIGHT = R.drawable.moon_clear
        val MAINLY_CLEAR = R.drawable.mainly_clear
        val MAINLY_CLEAR_NIGHT = R.drawable.mainly_clear_night
        val PARTLY_CLOUD = R.drawable.partly_cloud
        val PARTLY_CLOUD_NIGHT = R.drawable.partly_cloud_night
        val OVERCAST = R.drawable.overcast
        val FOG = R.drawable.foggy
        val DEPOSITING_RIME_FOG = R.drawable.rime_fog
        val DRIZZLE_LIGHT = R.drawable.light_drizzle
        val DRIZZLE_MODERATE = R.drawable.moderate_drizzle
        val DRIZZLE_MODERATE_NIGHT = R.drawable.drizzle_modrate_night
        val DRIZZLE_HIGH = R.drawable.heavy_drizzle
        val FREEZING_DRIZZLE_LIGHT = R.drawable.freezing_drizzle
        val FREEZING_DRIZZLE_HIGHT = R.drawable.freezing_drizzle
        val RAIN_LIGHT = R.drawable.moderate_rain
        val RAIN_MODERATE = R.drawable.moderate_rain
        val RAIN_HEAVY = R.drawable.heavy_rain
        val FREEZING_RAIN_LIGHT = R.drawable.freezing_rain_light
        val FREEZING_RAIN_HIGH = R.drawable.freezing_rain_heavy
        val SNOW_LIGHT = R.drawable.snow
        val SNOW_MODERATE = R.drawable.snow
        val SNOW_HEAVY = R.drawable.snow_heavy
        val SNOW_GRAINS = R.drawable.sonw_grains
        val RAIN_SHOWER_LIGHT = R.drawable.rain_shower
        val RAIN_SHOWER_MODRATE = R.drawable.rain_shower
        val RAIN_SHOWER_HEAVY = R.drawable.rain_shower
        val SNOW_SHOWER_LIGHT = R.drawable.snow_shower
        val SNOW_SHOWER_HEAVY = R.drawable.snow_shower_heavy
        val THUNDER_STORM = R.drawable.thunder_storm
        val THUNDER_STORM_HAIL_LIGHT = R.drawable.thunder_storm_hail_light
        val THUNDER_STORM_HAIL_HEAVY = R.drawable.thunder_storm_hail_heavy
    }

    object ForecastCode{
        const val CLEAR_SKY = 0
        const val MAINLY_CLEAR = 1
        const val PARTLY_CLOUD = 2
        const val OVERCAST = 3
        const val FOG = 45
        const val DEPOSITING_RIME_FOG = 48
        const val DRIZZLE_LIGHT = 51
        const val DRIZZLE_MODERATE = 53
        const val DRIZZLE_HIGH = 55
        const val FREEZING_DRIZZLE_LIGHT = 56
        const val FREEZING_DRIZZLE_HIGHT = 57
        const val RAIN_LIGHT = 61
        const val RAIN_MODERATE = 63
        const val RAIN_HEAVY = 65
        const val FREEZING_RAIN_LIGHT = 66
        const val FREEZING_RAIN_HIGH = 67
        const val SNOW_LIGHT = 71
        const val SNOW_MODERATE = 73
        const val SNOW_HEAVY = 75
        const val SNOW_GRAINS = 77
        const val RAIN_SHOWER_LIGHT = 80
        const val RAIN_SHOWER_MODRATE = 81
        const val RAIN_SHOWER_HEAVY = 82
        const val SNOW_SHOWER_LIGHT = 85
        const val SNOW_SHOWER_HEAVY = 86
        const val THUNDER_STORM = 95
        const val THUNDER_STORM_HAIL_LIGHT = 96
        const val THUNDER_STORM_HAIL_HEAVY = 99
    }

}