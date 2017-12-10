package com.example.ondra.fuelbook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.example.ondra.fuelbook.Entity.NewFuel;
import com.example.ondra.fuelbook.R;

import com.example.ondra.fuelbook.adapter.FuelAdapter;
import com.example.ondra.fuelbook.database.FuelData;

import java.util.ArrayList;
import java.util.List;

public class ListFuel extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FuelAdapter fuelAdapter;
    private List<NewFuel> fuelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fuel);
        getActionBar().setDisplayHomeAsUpEnabled(true);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view_fuel);
        fuelAdapter = new FuelAdapter(fuelList);
       /* fuelAdapter.setCallback(new CarAdapter.CarAdapterOnClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getApplicationContext(), "Pozice " + position, Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), OptionsCar.class));
            }
        });*/
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(fuelAdapter);

        initDataToList();

    }

    public void initDataToList(){
        //fuelList.add(new NewFuel("22.5.2012", "Ostrava", 28.5, 1000.0, 145000));
        //fuelList.add(new NewFuel("30.5.2012", "Kopřivnice", 29.8, 200.0, 150000));
        //fuelList.add(new NewFuel("22.5.2012", "Ostravice", 30.5, 1000.0, 160000));

        //DATA FROM DB
        List<FuelData> note = FuelData.listAll(FuelData.class);


        if(note != null & !note.isEmpty()){
            for(FuelData fuelData : note){
                fuelList.add(new NewFuel(fuelData.datum, fuelData.misto, fuelData.cena, fuelData.celkovaCena,fuelData.km));
            }
        }



        fuelAdapter.notifyDataSetChanged();
    }

}
