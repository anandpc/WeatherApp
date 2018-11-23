package anandpc.github.io.weatherapp.Presenter;

import anandpc.github.io.weatherapp.Model.SingleWeatherData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    //  API String which get's Query Parameters i.e "forecast?q=pune&appid=a7d468fc6a31f31f11ff47927dadc5ac"
    @GET("forecast")
    Call<SingleWeatherData> getWeatherData(@Query("q") String city, @Query("appid")String appid);
}
