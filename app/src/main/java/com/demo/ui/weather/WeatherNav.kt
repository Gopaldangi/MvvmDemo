package com.demo.ui.weather

import com.demo.appUtils.CommonNavigator
import com.demo.ui.weather.weatherResponse.WeatherResponse

interface WeatherNav : CommonNavigator {

    fun onWeather(weather: WeatherResponse)

}