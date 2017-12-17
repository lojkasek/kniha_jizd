package com.example.ondra.fuelbook.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import com.example.ondra.fuelbook.Entity.StatisticsEntity;
import com.example.ondra.fuelbook.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.ColumnChartView;

public class Chart extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        ColumnChartView chart = (ColumnChartView) findViewById(R.id.chart);
        Intent intent = getIntent();
        HashMap<String, StatisticsEntity> hashMap = (HashMap<String, StatisticsEntity>)intent.getSerializableExtra("values");

        List<Column> columns = new ArrayList<Column>();
        List<SubcolumnValue> values;
        ArrayList<AxisValue> axisValueX = new ArrayList<>();
        Axis axisX = new Axis().setTextColor(Color.BLACK);
        Axis axisY = new Axis().setHasLines(true).setTextColor(Color.BLACK);

        int id = 0;
        for(StatisticsEntity entity : hashMap.values())
        {
            values = new ArrayList<SubcolumnValue>();
            values.add(new SubcolumnValue((float)entity.value, ChartUtils.pickColor()));
            axisValueX.add(new AxisValue(id).setLabel(entity.month+"/"+entity.year));
            Column column = new Column(values);
            column.setHasLabels(true);
            columns.add(column);
            id++;

        }
        ColumnChartData data = new ColumnChartData(columns);
        axisX.setValues(axisValueX);
        axisX.setName("Datum");
        axisY.setName("Cena");

        data.setAxisXBottom(axisX);
        data.setAxisYLeft(axisY);
        chart.setColumnChartData(data);

    }
}
