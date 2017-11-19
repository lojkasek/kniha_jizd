package com.example.ondra.fuelbook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ondra.fuelbook.R;

public class OptionsCar extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_car);
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
