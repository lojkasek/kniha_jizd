package com.example.ondra.fuelbook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ondra.fuelbook.R;
import com.example.ondra.fuelbook.database.FuelData;

public class NewNotesFuel extends Activity {


    EditText FuelDateET, FuelKmET, FuelPriceET, FuelPriceSumET, FuelPlaceET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_notes_fuel);

        FuelDateET = findViewById(R.id.FuelDate);
        FuelKmET = findViewById(R.id.FuelKm);
        FuelPriceET = findViewById(R.id.FuelPrice);
        FuelPriceSumET = findViewById(R.id.FuelPriceSum);
        FuelPlaceET = findViewById(R.id.FuelPlace);
    }


    public void saveFuel(View v) {
        String FuelDate = FuelDateET.getText().toString();
        Integer FuelKm = Integer.valueOf(FuelKmET.getText().toString());
        Double FuelPrice = Double.valueOf(FuelPriceET.getText().toString());
        Double FuelPriceSum = Double.valueOf(FuelPriceSumET.getText().toString());
        String FuelPlace = FuelPlaceET.getText().toString();

        FuelData fuel= new FuelData(FuelDate, FuelKm, FuelPrice, FuelPriceSum, FuelPlace);
        fuel.save();

        startActivity(new Intent(getApplicationContext(), OptionsCar.class));

    }

}
