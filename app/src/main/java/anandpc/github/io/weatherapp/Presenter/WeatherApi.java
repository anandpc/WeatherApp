package anandpc.github.io.weatherapp.Presenter;

import java.util.List;

import anandpc.github.io.weatherapp.Model.SingleWeatherData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/*
 *   https://api.openweathermap.org/data/2.5/weather?q=pune&appid=a7d468fc6a31f31f11ff47927dadc5ac
 * */

public interface WeatherApi {

    @GET("forecast")
    Call<SingleWeatherData> getWeatherData(@Query("q") String city, @Query("appid")String appid);
}
