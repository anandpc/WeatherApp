package anandpc.github.io.weatherapp.Presenter;

import android.util.Log;

import anandpc.github.io.weatherapp.Model.SingleWeatherData;
import anandpc.github.io.weatherapp.Presenter.ApiModule.RetrofitClass;

public class Presenter {

   public void getDataFromApi(String cityName){
       RetrofitClass retrofitClass = new RetrofitClass(cityName);


    }
}
