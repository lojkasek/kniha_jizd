package com.example.ondra.fuelbook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.ondra.fuelbook.Entity.Car;
import com.example.ondra.fuelbook.R;
import com.example.ondra.fuelbook.adapter.CarAdapter;
import com.example.ondra.fuelbook.database.CarData;

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
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(carAdapter);

        initDataToList();

        mRecyclerView.addOnItemTouchListener(new CarTouchListener(new CarTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent i = new Intent(ListCar.this, OptionsCar.class);
                i.putExtra("IDC", position);
                startActivityForResult(i,3);
            }
            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        }

        public void initDataToList(){
            //DATA FROM DB
            List<CarData> cars = CarData.listAll(CarData.class);


            if(cars != null & !cars.isEmpty()){
                for(CarData carData : cars){
                    carList.add(new Car(carData.getId(), carData.nazev, carData.spotreba, carData.tachometr));
                }
            }

            //DATA FROM DB CONVERT DO CAR LIST ENTITY

            carAdapter.notifyDataSetChanged();
        }
}
