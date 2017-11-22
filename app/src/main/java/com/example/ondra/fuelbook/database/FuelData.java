package com.example.ondra.fuelbook.database;

import com.orm.SugarRecord;

/**
 * Created by Ondra on 17.11.2017.
 */

public class FuelData extends SugarRecord {

    public String datum;
    public Integer km;
    public Double cena;
    public Double celkovaCena;
    public String misto;

    public FuelData(){
    }

    public FuelData(String datum, int km, Double cena, Double celkovaCena, String misto) {
        this.datum = datum;
        this.km = km;
        this.cena = cena;
        this.celkovaCena = celkovaCena;
        this.misto = misto;
    }

}