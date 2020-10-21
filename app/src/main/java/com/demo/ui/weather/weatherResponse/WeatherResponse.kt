package com.demo.ui.weather.weatherResponse

import Api
import com.demo.appUtils.NetworkResponseCallback
import com.demo.appUtils.Parser
import com.demo.data.remote.ApiFactory
import com.demo.ui.base.BaseResponse

import com.google.gson.annotations.SerializedName
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*

class WeatherResponse : BaseResponse<WeatherResponse, String, Any>() {

    var data : WeatherBean? = null


    override fun doNetworkRequest(requestParam: HashMap<String, Any>, vararg: Any, networkResponseCallback: NetworkResponseCallback<WeatherResponse>): Disposable {
        val api = ApiFactory.getClientWithoutHeader().create(Api::class.java)


        return api.getWeather( requestParam["q"] as String , requestParam["APPID"] as String )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ networkResponseCallback.onResponse(it) },
                        { throwable -> Parser.parseErrorResponse(throwable, networkResponseCallback) })
    }

data class WeatherBean(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)

data class Clouds(
    val all: Int
)

data class Coord(
    val lat: Double,
    val lon: Double
)

data class Main(
    val feels_like: Double,
    val humidity: Int,
    val pressure: Int,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double
)

data class Sys(
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
)

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)

data class Wind(
    val deg: Int,
    val gust: Double,
    val speed: Double
)



}
