package com.example.ondra.fuelbook.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ondra.fuelbook.Entity.Car;
import com.example.ondra.fuelbook.R;

import java.util.List;

/**
 * Created by Ondra on 17.11.2017.
 */



public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder> {

    private List<Car> carList;


    public class MyViewHolder extends RecyclerView.ViewHolder  {
        public TextView title, gasolineUsage, speedmeter;

        public MyViewHolder(View view) {
            super(view);
           // view.setOnClickListener(this);
            title = (TextView) view.findViewById(R.id.nazev);
            gasolineUsage = (TextView) view.findViewById(R.id.spotreba);
            speedmeter = (TextView) view.findViewById(R.id.tachometr);

        }
    }


    public CarAdapter(List<Car> moviesList) {
        this.carList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Car car = carList.get(position);
        holder.title.setText("Název: " + car.nazev);
        holder.speedmeter.setText("Tachometr: " + String.valueOf(car.tachometr));
        holder.gasolineUsage.setText("Palivo: " + String.valueOf(car.spotreba));
    }


    @Override
    public int getItemCount() {
        return carList.size();
    }
}