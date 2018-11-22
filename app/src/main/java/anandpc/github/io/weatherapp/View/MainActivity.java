package anandpc.github.io.weatherapp.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import anandpc.github.io.weatherapp.Presenter.Presenter;
import anandpc.github.io.weatherapp.R;

public class MainActivity extends AppCompatActivity {

    private EditText cityName;
    private ImageButton btnSearch;
    private Presenter presenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName = findViewById(R.id.cityName);
        btnSearch = findViewById(R.id.btnSearch);
        recyclerView = findViewById(R.id.recyclerView);

        presenter = new Presenter();
        final WeatherDataAdapter weatherDataAdapter = new WeatherDataAdapter(this);
        recyclerView.setAdapter(weatherDataAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getDataFromApi(cityName.getText().toString());
                weatherDataAdapter.notifyDataSetChanged();
            }
        });
    }
}