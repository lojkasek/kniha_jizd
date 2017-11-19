package com.example.ondra.fuelbook.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ondra.fuelbook.Entity.NewFuel;
import com.example.ondra.fuelbook.R;

import java.util.List;

/**
 * Created by Ondra on 17.11.2017.
 */

public class FuelAdapter extends RecyclerView.Adapter<FuelAdapter.MyViewHolder> {

    private List<NewFuel> fuelList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView dateT, placeT, priceT, pricesumT, acttachometrT;

        public MyViewHolder(View view) {
            super(view);
            dateT = (TextView) view.findViewById(R.id.date);
            placeT = (TextView) view.findViewById(R.id.place);
            priceT = (TextView) view.findViewById(R.id.price);
            pricesumT = (TextView) view.findViewById(R.id.pricesum);
            acttachometrT = (TextView) view.findViewById(R.id.acttachometr);
        }
    }


    public FuelAdapter(List<NewFuel> moviesList) {
        this.fuelList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_fuel, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NewFuel fuel = fuelList.get(position);
        holder.dateT.setText(fuel.date);
        holder.placeT.setText(fuel.place);
        holder.priceT.setText(String.valueOf(fuel.price));
        holder.pricesumT.setText(String.valueOf(fuel.pricesum));
        holder.acttachometrT.setText(String.valueOf(fuel.acttachometr));
    }

    @Override
    public int getItemCount() {
        return fuelList.size();
    }
}
