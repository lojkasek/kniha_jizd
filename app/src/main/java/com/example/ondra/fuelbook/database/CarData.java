package com.example.ondra.fuelbook.database;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by Ondra on 17.11.2017.
 */

public class CarData extends SugarRecord {

    public String nazev;
    public Double spotreba;
    public Integer tachometr;


    public CarData(){
    }

    public CarData(String nazev, Double spotreba, int tachometr) {
        this.nazev = nazev;
        this.spotreba = spotreba;
        this.tachometr = tachometr;
    }


}