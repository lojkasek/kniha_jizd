package com.example.ondra.fuelbook.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ondra.fuelbook.Entity.Car;
import com.example.ondra.fuelbook.R;
import com.example.ondra.fuelbook.adapter.CarAdapter;

import java.util.ArrayList;
import java.util.List;


public class ListCar extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private CarAdapter carAdapter;
    private List<Car> carList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_car);
        getActionBar().setDisplayHomeAsUpEnabled(true);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        carAdapter = new CarAdapter(carList);
        carAdapter.setCallback(new CarAdapter.CarAdapterOnClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getApplicationContext(), "Pozice " + position, Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), OptionsCar.class));
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(carAdapter);

        initDataToList();
        }

        public void initDataToList(){
            carList.add(new Car("Skoda Octavia", "7.5", "15200", 1));
            carList.add(new Car("Ford", "7.5", "150000", 2));
            carList.add(new Car("Opel", "7.5", "36000",3 ));
            carAdapter.notifyDataSetChanged();
        }
}
