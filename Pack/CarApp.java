package com.example.ondra.fuelbook.Pack;

import android.app.Application;

import android.app.Application;
import android.widget.TextView;

import com.example.ondra.fuelbook.database.CarData;
import com.facebook.stetho.Stetho;
import com.orm.SugarApp;
import com.orm.SugarContext;
import com.orm.SugarDb;

/**
 * Created by Ondra on 17.11.2017.
 */


public class CarApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
        Stetho.initializeWithDefaults(this);

        /*CarData cc = new CarData("Skoda Fabia", "7,5", "145000", 1);
        cc.save();*/

    }


}
