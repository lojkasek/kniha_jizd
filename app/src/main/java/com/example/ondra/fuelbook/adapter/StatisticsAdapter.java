package com.example.ondra.fuelbook.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ondra.fuelbook.Entity.StatisticsEntity;
import com.example.ondra.fuelbook.R;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;


/**
 * Created by Ondra on 17.12.2017.
 */

public class StatisticsAdapter extends RecyclerView.Adapter<StatisticsAdapter.MyViewHolder>{

    private HashMap<String,StatisticsEntity> statisticsList;
    private String[] mKeys;
    public StatisticsAdapter(HashMap<String,StatisticsEntity> l) {
        this.statisticsList = l;
        mKeys = l.keySet().toArray(new String[l.size()]);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.info_row, parent, false);

        return new StatisticsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        StatisticsEntity entity = statisticsList.get(this.statisticsList.keySet().toArray()[position]);
        holder.month.setText("Mesic: "+entity.month);
        holder.year.setText("Rok: "+entity.year);
        holder.value.setText("Částka: "+String.valueOf(entity.value));
        NumberFormat formatter = new DecimalFormat("#0.00");
        holder.litry.setText("Litry: "+String.valueOf(formatter.format(entity.litry)));
    }

    @Override
    public int getItemCount() {
        return statisticsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView month,year,value,litry;

        public MyViewHolder(View view) {
            super(view);
            month = (TextView) view.findViewById(R.id.month);
            year = (TextView) view.findViewById(R.id.year);
            value = (TextView) view.findViewById(R.id.value);
            litry = (TextView) view.findViewById(R.id.litry);
        }
    }

}
