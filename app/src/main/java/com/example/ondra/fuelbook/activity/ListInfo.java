package com.example.ondra.fuelbook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import com.example.ondra.fuelbook.Entity.StatisticsEntity;
import com.example.ondra.fuelbook.R;
import com.example.ondra.fuelbook.adapter.StatisticsAdapter;
import com.example.ondra.fuelbook.database.FuelData;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class ListInfo extends Activity {
    public int position;
    private RecyclerView mRecyclerView;
    private StatisticsAdapter statAdapter;
    private HashMap<String,StatisticsEntity> list = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_info);

        Intent intent = getIntent();
        position = intent.getIntExtra("IDC",-1);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view_fuel);
        statAdapter = new StatisticsAdapter(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(statAdapter);
        initDataToList();

        Button btnChart = (Button)findViewById(R.id.btnGraf);
        btnChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Chart.class);
                intent.putExtra("values",list);
                startActivity(intent);
            }
        });

    }
    public void initDataToList(){

        //DATA FROM DB
        List<FuelData> note = FuelData.find(FuelData.class,"ID_CAR = ?",String.valueOf(position));

        if(note != null & !note.isEmpty()){
            for(FuelData fuelData : note){
                DateFormat date = new SimpleDateFormat("dd.MM.yyyy");
                DateFormat Dyear = new SimpleDateFormat("yyyy");
                DateFormat Dmonth = new SimpleDateFormat("MM");
                String month="";
                String year="";
                try {
                    Date fullDate = date.parse(fuelData.datum);
                    month = Dmonth.format(fullDate);
                    year = Dyear.format(fullDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String key = month+"/"+year;

               if(list.containsKey(key))
               {
                   StatisticsEntity r= list.get(key);
                   r.value+=fuelData.celkovaCena;
                   r.litry+=fuelData.litry;
                   list.put(key,r);
               }else list.put(key, new StatisticsEntity(month,year,fuelData.celkovaCena,fuelData.litry) );
            }
        }

        statAdapter.notifyDataSetChanged();
    }
}
