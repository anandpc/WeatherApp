package anandpc.github.io.weatherapp.Presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    Context ctx;
    RecyclerView recyclerView;

    private String cityName;

    // Constructor.
    public RetrofitClass(Context ctx,RecyclerView recyclerView) {
        this.ctx = ctx;
        this.recyclerView = recyclerView;
    }

    // Setting of cityName.
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    public void getData() {

        // Creates the retrofit with base URL adds GSONConverterFactory to Map data to POJO class.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Getting isntance of weatherApi
        WeatherApi weatherApi = retrofit.create(WeatherApi.class);

        // will save the response data.
        String API_KEY = "a7d468fc6a31f31f11ff47927dadc5ac";
        Call<SingleWeatherData> singleWeatherData = weatherApi.getWeatherData(cityName, API_KEY);

        // Calling the API
        singleWeatherData.enqueue(new Callback<SingleWeatherData>() {

            @Override
            public void onResponse(Call<SingleWeatherData> call, Response<SingleWeatherData> response) {

                SingleWeatherData data = response.body();

                if(data != null && data.getCod().equals("200")){

                    // Set data to recycler View here only.
                    WeatherDataAdapter adapter = new WeatherDataAdapter(ctx ,data);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(ctx));

                    Log.i("data from RetrofitClass", " Data : " + data.toString());

                }else if(data == null){

                    // Alerting the user if no response is been received.
                    final AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                    builder.setMessage("City Not Found");
                    builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.show();
                }
            }

            @Override
            public void onFailure(Call<SingleWeatherData> call, Throwable t) {

                // Alerting the user if no response is been received.
                final AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setMessage("No Internet Connection");
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
    }
}
