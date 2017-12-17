package com.example.ondra.fuelbook.Entity;

import java.io.Serializable;

/**
 * Created by Ondra on 17.12.2017.
 */

public class StatisticsEntity implements Serializable{
    public String month;
    public String year;
    public double value;
    public Double litry;


    public StatisticsEntity(String m, String y, Double v,Double litry) {
        this.month = m;
        this.year = y;
        this.value = v;
        this.litry = litry;
    }
}
