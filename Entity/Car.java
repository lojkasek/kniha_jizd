package com.example.ondra.fuelbook.Entity;

/**
 * Created by Ondra on 17.11.2017.
 */

public class Car {

    public String nazev;
    public String spotreba;
    public String tachometr;
    public int idcar;


    public Car(String nazev, String spotreba, String tachometr, int idcar) {
        this.nazev = nazev;
        this.spotreba = spotreba;
        this.tachometr = tachometr;
        this.idcar=idcar;
    }
}

