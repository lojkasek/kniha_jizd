package com.example.ondra.fuelbook.Entity;

/**
 * Created by Ondra on 17.11.2017.
 */

public class NewFuel {

    public String date;
    public String place;
    public Double price;
    public Double pricesum;
    public Integer acttachometr;


    public NewFuel(String date, String place, Double price, Double pricesum,int acttachometr) {
        this.date = date;
        this.place = place;
        this.price = price;
        this.pricesum = pricesum;
        this.acttachometr = acttachometr;
    }
}
