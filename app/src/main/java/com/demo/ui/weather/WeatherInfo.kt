package com.demo.ui.weather

import android.os.Bundle
import android.util.Log
import com.demo.R
import com.demo.databinding.ActivityWeatherBinding
import com.demo.ui.base.BaseActivity
import com.demo.BR
import com.demo.ui.weather.weatherResponse.WeatherResponse

class WeatherInfo : BaseActivity<ActivityWeatherBinding , WeatherViewModel>(), WeatherNav{

    override val bindingVariable: Int
        get() = BR.weatherVM
    override val layoutId: Int
        get() = R.layout.activity_weather
    override val viewModel = WeatherViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        init()
    }


    override fun init() {

        if (checkIfInternetOn(tryAgainClick = { init() })) {
            viewModel.weatherInfoApi()
        }

    }



    override fun onWeather(weather: WeatherResponse) {

        Log.e("res >>>>",""+weather.data!!.clouds.all)

    }

}