package anandpc.github.io.weatherapp.Presenter.ApiModule;

import android.util.Log;

import anandpc.github.io.weatherapp.Model.SingleWeatherData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
*   https://api.openweathermap.org/data/2.5/weather?q=pune&appid=a7d468fc6a31f31f11ff47927dadc5ac
* */

public class RetrofitClass {

    public final String API_KEY = "a7d468fc6a31f31f11ff47927dadc5ac";

    public RetrofitClass(String city) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApi weatherApi = retrofit.create(WeatherApi.class);
        Call<SingleWeatherData> singleWeatherData = weatherApi.getWeatherData(city,API_KEY);

        singleWeatherData.enqueue(new Callback<SingleWeatherData>() {
            @Override
            public void onResponse(Call<SingleWeatherData> call, Response<SingleWeatherData> response) {
                SingleWeatherData data = response.body();
                Log.i("data","Data Captured");
                Log.i("data"," Data : "+data.toString());
            }

            @Override
            public void onFailure(Call<SingleWeatherData> call, Throwable t) {
                Log.i("error","Error occured");
            }
        });
    }
}
