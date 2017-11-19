package com.example.ondra.fuelbook.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ondra.fuelbook.R;

public class NewNotesFuel extends Activity {

    TextView FuelDate, FuelKm, FuelPrice, FuelPriceSum, FuelPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_notes_fuel);

        FuelDate = (TextView) findViewById(R.id.FuelDate);
        FuelKm = (TextView) findViewById(R.id.FuelKm);
        FuelPrice = (TextView) findViewById(R.id.FuelPrice);
        FuelPriceSum = (TextView) findViewById(R.id.FuelPriceSum);
        FuelPlace = (TextView) findViewById(R.id.FuelPlace);
    }
}
