package anandpc.github.io.weatherapp.View;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import anandpc.github.io.weatherapp.Model.SingleWeatherData;
import anandpc.github.io.weatherapp.Presenter.RetrofitClass;
import anandpc.github.io.weatherapp.R;

public class MainActivity extends AppCompatActivity{

    private EditText editTextCityName;
    private ImageButton btnSearch;
    private RecyclerView recyclerView;

    WeatherDataAdapter weatherDataAdapter;

    public RetrofitClass retrofitClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCityName = findViewById(R.id.editTextCityName);
        btnSearch = findViewById(R.id.btnSearch);
        recyclerView = findViewById(R.id.recyclerView);


        // Recycler View Created and set to display
        // Initially no data so set to "0"
        weatherDataAdapter = new WeatherDataAdapter(this);
        recyclerView.setAdapter(weatherDataAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        retrofitClass = new RetrofitClass();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrofitClass.setCityName(editTextCityName.getText().toString());
                retrofitClass.getData();
                setDataToView();
                notifyAdapter();
                Log.i("buttom","In Button");
            }
        });
    }

    public void setDataToView(){
        SingleWeatherData data = retrofitClass.getWeatherData();
        weatherDataAdapter.setData(data);
    }

    // Call Back method to notify adapter for data set changed.
    public void notifyAdapter(){
        weatherDataAdapter.notifyDataSetChanged();
    }
}