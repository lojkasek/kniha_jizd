package com.example.ondra.fuelbook.Entity;

/**
 * Created by Ondra on 17.11.2017.
 */

public class Car {

    public String nazev;
    public Double spotreba;
    public int tachometr;
    public long id;


    public Car(long id, String nazev, Double spotreba, int tachometr) {
        this.id = id;
        this.nazev = nazev;
        this.spotreba = spotreba;
        this.tachometr = tachometr;
    }
}

