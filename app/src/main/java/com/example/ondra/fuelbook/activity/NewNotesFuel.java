package com.example.ondra.fuelbook.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import com.example.ondra.fuelbook.R;
import com.example.ondra.fuelbook.database.FuelData;
import java.util.Calendar;

public class NewNotesFuel extends Activity implements View.OnClickListener{

    DatePicker myDate;
    EditText FuelDateET, FuelKmET, FuelPriceET, FuelPriceSumET, FuelPlaceET;
    Button btnDatePicker,btnSave;
    private int mYear, mMonth, mDay;
    int id_car;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_notes_fuel);

        FuelDateET = findViewById(R.id.FuelDate);
        FuelKmET = findViewById(R.id.FuelKm);
        FuelPriceET = findViewById(R.id.FuelPrice);
        FuelPriceSumET = findViewById(R.id.FuelPriceSum);
        FuelPlaceET = findViewById(R.id.FuelPlace);

        btnDatePicker=(Button)findViewById(R.id.btn_date);
        btnSave=(Button)findViewById(R.id.button);

        btnDatePicker.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        
        //ziskani id auta
        intent = getIntent();
        if(intent != null) {
            id_car = intent.getIntExtra("IDC", -1);
            //Toast.makeText(this, "ID AUTA " + id_car, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btnDatePicker) {
            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            FuelDateET.setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }

        if(v == btnSave){
            String FuelDate = FuelDateET.getText().toString();
            Integer FuelKm = Integer.valueOf(FuelKmET.getText().toString());
            Double FuelPrice = Double.valueOf(FuelPriceET.getText().toString());
            Double FuelPriceSum = Double.valueOf(FuelPriceSumET.getText().toString());
            String FuelPlace = FuelPlaceET.getText().toString();

            Double litry = FuelPriceSum/FuelPrice;

            FuelData fuel= new FuelData(FuelDate, FuelKm, FuelPrice, FuelPriceSum, FuelPlace, id_car, litry);
            fuel.save();

            setResult(Activity.RESULT_OK, intent);
            finish();
        }

    }
}
