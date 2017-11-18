package com.example.ondra.fuelbook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ondra.fuelbook.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openN_car(View v)
    {
        Intent intent = new Intent(getApplicationContext(), NewCar.class);
        startActivity(intent);
    }

    public void openL_car(View v)
    {
        Intent intent = new Intent(getApplicationContext(), ListCar.class);
        startActivity(intent);
    }
}
