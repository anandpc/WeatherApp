package anandpc.github.io.weatherapp.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import anandpc.github.io.weatherapp.R;

public class WeatherDataAdapter extends RecyclerView.Adapter<WeatherDataAdapter.DataViewHolder> {

    Context ctx;

    public WeatherDataAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(ctx).inflate(R.layout.item_layout,parent,false);
        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        /*
        * Displaying Static data
        * */
        int i=0;
        while (i < 20){

            holder.cityName.setText("Pune");
            holder.temp.setText("25");
            holder.description.setText("cold with fog");
            i++;
        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        TextView cityName,temp,description;

        public DataViewHolder(View itemView) {
            super(itemView);
            cityName = itemView.findViewById(R.id.cityName);
            temp = itemView.findViewById(R.id.temp);
            description = itemView.findViewById(R.id.description);
        }
    }
}
