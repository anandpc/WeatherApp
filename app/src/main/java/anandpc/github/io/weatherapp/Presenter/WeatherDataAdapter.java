package anandpc.github.io.weatherapp.Presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import anandpc.github.io.weatherapp.Model.Main;
import anandpc.github.io.weatherapp.Model.SingleWeatherData;
import anandpc.github.io.weatherapp.Model.Weather;
import anandpc.github.io.weatherapp.R;

public class WeatherDataAdapter extends RecyclerView.Adapter<WeatherDataAdapter.DataViewHolder> {

    private Context ctx;
    private SingleWeatherData data;
    private List<anandpc.github.io.weatherapp.Model.List> lists;

    public WeatherDataAdapter(Context ctx, SingleWeatherData data) {
        this.ctx = ctx;
        this.data = data;
        lists = data.getList();
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(ctx).inflate(R.layout.item_layout, parent, false);
        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        Log.i("Data from Adapter", " " + data.toString());

        // Fetching One list item
        anandpc.github.io.weatherapp.Model.List list = lists.get(position);

        // Getting the main instance which has temp and humid data.
        Main main = list.getMain();

        // Converting Temperature from Kelvin to Celsius.
        int temp = (int) (main.getTemp() - 273);

        //  Setting the temp and humid data to the View.
        holder.temp.setText(Integer.toString(temp));
        holder.humid.setText(main.getHumidity().toString());


        Log.i("date", " " + list.getDtTxt());
        // holder.date.setText();

        // Getting Weather instance from list and getting the description
        //  Setting the Description data to the View.
        List<Weather> weathers = list.getWeather();
        holder.description.setText(weathers.get(0).getDescription());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    class DataViewHolder extends RecyclerView.ViewHolder {

        TextView humid, temp, description;

        DataViewHolder(View itemView) {
            super(itemView);
            //date = itemView.findViewById(R.id.date);
            temp = itemView.findViewById(R.id.temp);
            humid = itemView.findViewById(R.id.humidity);
            description = itemView.findViewById(R.id.desc);
        }
    }
}
