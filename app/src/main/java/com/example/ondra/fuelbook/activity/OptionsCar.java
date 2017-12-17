package com.example.ondra.fuelbook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ondra.fuelbook.R;
import com.example.ondra.fuelbook.database.CarData;

public class OptionsCar extends Activity {

    int id_car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_car);

        Intent intent = getIntent();
        if(intent != null) {
            id_car = intent.getIntExtra("IDC", -1);
            //Toast.makeText(this, "Optins Car ID AUTA " + id_car, Toast.LENGTH_LONG).show();
        }
        TextView txtCar = findViewById(R.id.txtCar);
        CarData note = CarData.findById(CarData.class,id_car+1);
        txtCar.setText(note.nazev);

    }

    public void openListFuel(View v)
    {
        Intent intent = new Intent(getApplicationContext(), ListFuel.class);
        intent.putExtra("IDC",id_car);
        startActivityForResult(intent,1);
    }

    public void openNewNotesFuel(View v)
    {
        Intent intent = new Intent(getApplicationContext(), NewNotesFuel.class);
        intent.putExtra("IDC",id_car);
        startActivityForResult(intent,2);
    }
    public void openStatistics(View v)
    {
        Intent intent = new Intent(getApplicationContext(), ListInfo.class);
        intent.putExtra("IDC",id_car);
        startActivityForResult(intent,3);
    }
}
