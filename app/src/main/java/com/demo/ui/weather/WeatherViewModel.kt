package com.demo.ui.weather

import com.demo.R
import com.demo.appUtils.AppConstants
import com.demo.appUtils.NetworkResponseCallback
import com.demo.data.local.AppPreference
import com.demo.ui.base.BaseViewModel
import com.demo.ui.weather.weatherResponse.WeatherResponse

class WeatherViewModel : BaseViewModel<WeatherNav>(){


    fun weatherInfoApi() {

        navigator!!.showProgress()
        disposable.add(
            WeatherResponse().doNetworkRequest(prepareRequestHashMap(),
                AppPreference,
                object : NetworkResponseCallback<WeatherResponse> {
                    override fun onResponse(weather: WeatherResponse) {
                        navigator!!.hideProgress()

                            navigator!!.onWeather(weather)

                    }

                    override fun onFailure(message: String) {
                        navigator!!.hideProgress()
                        //navigator!!.showNetworkError(navigator!!.getStringResource(R.string.http_some_other_error))
                    }

                    override fun onServerError(error: String) {
                        navigator!!.hideProgress()
                        /*if (error != "")
                            navigator!!.showNetworkError(error)
                        else
                            navigator!!.showNetworkError(navigator!!.getStringResource(R.string.http_some_other_error))*/
                    }

                    override fun onSessionExpire(error: String) {
                        navigator!!.hideProgress()
                    }

                    override fun onAppVersionUpdate(msg: String) {
                        navigator!!.hideProgress()

                    }

                    override fun onErrorMessage(erroeMessage: String) {
                        navigator!!.hideProgress()
                    }

                })
        )
    }

    var hashMap = HashMap<String , Any>()
    private fun prepareRequestHashMap(): java.util.HashMap<String, Any> {

        hashMap["APPID"] = AppConstants.appid
        hashMap["q"] = AppConstants.city

        return hashMap
    }

}