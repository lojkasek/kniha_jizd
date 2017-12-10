package com.example.ondra.fuelbook.database;

import com.orm.SugarRecord;

/**
 * Created by Ondra on 10.12.2017.
 */

public class Statistics extends SugarRecord {

    public Integer idCar;
    public String mesic;
    public String rok;
    public Double celkemKc;
    public Double celkemKm;

    public Statistics(){
    }

    public Statistics(int idCar, String mesic, String rok, Double celkemKc, Double celkemKm){
        this.idCar=idCar;
        this.mesic=mesic;
        this.rok=rok;
        this.celkemKc=celkemKc;
        this.celkemKm=celkemKm;
    }
}
