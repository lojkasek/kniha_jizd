package com.example.ondra.fuelbook.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.example.ondra.fuelbook.R;
import com.example.ondra.fuelbook.database.CarData;

public class NewCar extends Activity {

    EditText NazevET, SpotrebaET, TachometrET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_car);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        NazevET = (EditText) findViewById(R.id.n_nazev);
        SpotrebaET = (EditText) findViewById(R.id.n_spotreba);
        TachometrET = (EditText) findViewById(R.id.n_tachometr);
    }

    public void saveCar(View v) {
        String Nazev = NazevET.getText().toString();
        Double Spotreba = Double.valueOf(SpotrebaET.getText().toString());
        Integer Tachometr = Integer.valueOf(TachometrET.getText().toString());

        CarData car = new CarData(Nazev, Spotreba, Tachometr);
        car.save();
        finish();
    }
}



