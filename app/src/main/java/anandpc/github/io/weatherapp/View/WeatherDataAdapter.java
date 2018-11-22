package anandpc.github.io.weatherapp.View;

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
import anandpc.github.io.weatherapp.Presenter.RetrofitClass;
import anandpc.github.io.weatherapp.R;

public class WeatherDataAdapter extends RecyclerView.Adapter<WeatherDataAdapter.DataViewHolder> {

    Context ctx;
    SingleWeatherData data;

    public void setData(SingleWeatherData data) {
        this.data = data;
    }

    public WeatherDataAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(ctx).inflate(R.layout.item_layout, parent, false);
        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        Log.i("buttom","In onBind View Holder");

        Log.i("Data : "," " );

        /*
        SingleWeatherData data = retrofitClass.getSingleWeatherData();

        holder.cityName.setText(data.getCity().getName());
        List<anandpc.github.io.weatherapp.Model.List> lists = data.getList();


        anandpc.github.io.weatherapp.Model.List list = lists.get(position);
        Main main = list.getMain();

        holder.temp.setText(main.getTemp().toString());
        holder.humid.setText(main.getHumidity().toString());
        holder.date.setText(list.getDtTxt());
        List<Weather> weathers = list.getWeather();

        holder.description.setText(weathers.get(position).getDescription());
        */
    }

    @Override
    public int getItemCount() {

        Log.i("buttom","In Adapter Get Item Count");
        return 1;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        TextView date, humid, temp, description, cityName;

        public DataViewHolder(View itemView) {
            super(itemView);
            cityName = itemView.findViewById(R.id.cityName);
            date = itemView.findViewById(R.id.date);
            temp = itemView.findViewById(R.id.temp);
            humid = itemView.findViewById(R.id.humidity);
            description = itemView.findViewById(R.id.desc);
        }
    }
}
