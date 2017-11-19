package com.example.ondra.fuelbook.database;

import com.orm.SugarRecord;

/**
 * Created by Ondra on 17.11.2017.
 */

public class CarData extends SugarRecord {

    public String nazev;
    public String spotreba;
    public String tachometr;
    public int idcar;


    public CarData(){
    }

    public CarData(String nazev, String spotreba, String tachometr, int idcar) {
        this.nazev = nazev;
        this.spotreba = spotreba;
        this.tachometr = tachometr;
        this.idcar=idcar;
    }

}