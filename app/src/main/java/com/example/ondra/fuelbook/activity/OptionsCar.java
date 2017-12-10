package com.example.ondra.fuelbook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ondra.fuelbook.R;

public class OptionsCar extends Activity {

    int id_car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_car);

        Intent intent = getIntent();
        if(intent != null) {
            id_car = intent.getIntExtra("ID_CARS", -1);
            Toast.makeText(this, "ID AUTA " + id_car, Toast.LENGTH_LONG).show();
        }

    }

    public void openListFuel(View v)
    {
        Intent intent = new Intent(getApplicationContext(), ListFuel.class);
        startActivity(intent);
    }

    public void openNewNotesFuel(View v)
    {
        Intent intent = new Intent(getApplicationContext(), NewNotesFuel.class);
        startActivity(intent);
    }
}
