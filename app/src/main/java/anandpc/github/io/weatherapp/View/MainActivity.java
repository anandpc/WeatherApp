package anandpc.github.io.weatherapp.View;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import anandpc.github.io.weatherapp.Presenter.RetrofitClass;
import anandpc.github.io.weatherapp.R;

public class MainActivity extends AppCompatActivity{

    private EditText editTextCityName;
    private RecyclerView recyclerView;
    private TextView cityName;
    public RetrofitClass retrofitClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCityName = findViewById(R.id.editTextCityName);
        ImageButton btnSearch = findViewById(R.id.btnSearch);
        recyclerView = findViewById(R.id.recyclerView);
        cityName = findViewById(R.id.cityName);

        // Creating instance of retrofit to call the API on button click
        retrofitClass = new RetrofitClass(this,recyclerView);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //  Taking input of city name to call the API.
                retrofitClass.setCityName(editTextCityName.getText().toString());

                //  Setting the city Name as Title in the main layout
                cityName.setText(editTextCityName.getText().toString()+ " FORECAST");

                // Now Calling the API to fetch tha data.
                retrofitClass.getData();
            }
        });
    }

}