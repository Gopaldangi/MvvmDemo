import com.demo.ui.weather.weatherResponse.WeatherResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("weather")
    fun getWeather(@Query("q") city: String, @Query("APPID") appid: String): Observable<WeatherResponse>

}
