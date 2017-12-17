package com.example.ondra.fuelbook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Xml;
import android.view.View;
import android.widget.Toast;

import com.example.ondra.fuelbook.R;
import com.example.ondra.fuelbook.database.CarData;
import com.example.ondra.fuelbook.database.FuelData;

import org.xmlpull.v1.XmlSerializer;

import java.io.FileWriter;
import java.io.StringWriter;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openN_car(View v)
    {
        Intent intent = new Intent(getApplicationContext(), NewCar.class);
        startActivity(intent);
    }

    public void openL_car(View v)
    {
        Intent intent = new Intent(getApplicationContext(), ListCar.class);
        startActivity(intent);
    }
    public void btnExport(View v)
    {
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        FileWriter outputStream;
        try
        {
            serializer.setOutput(writer);
            serializer.startDocument("UTF-8",true);
            serializer.startTag("","Auta");
            for(CarData car : CarData.listAll(CarData.class))
            {
                serializer.startTag("","Auto");
                serializer.attribute("","Nazev",car.nazev);
                serializer.attribute("","Spotreba",car.spotreba.toString());
                serializer.attribute("","Puvodni_Tachometr",car.tachometr.toString());

                for(FuelData fuel :  FuelData.find(FuelData.class,"ID_CAR = ?",String.valueOf(car.getId()-1)))
                {
                    serializer.startTag("","Tankovani");
                    serializer.attribute("","Datum",fuel.datum);
                    serializer.attribute("","Km",fuel.km.toString());
                    serializer.attribute("","Cena_za_litr",fuel.cena.toString());
                    serializer.attribute("","Celkova_Cena",fuel.celkovaCena.toString());
                    serializer.attribute("","Misto",fuel.misto);
                    serializer.attribute("","Litry",fuel.litry.toString());
                    serializer.endTag("","Tankovani");
                }

                serializer.endTag("", "Auto");
            }
            serializer.endTag("","Auta");
            serializer.endDocument();
            outputStream = new FileWriter(Environment.getExternalStorageDirectory() + "/vystup.xml");
            outputStream.write(writer.toString());
            outputStream.close();
            Toast.makeText(this, "Data byla ulozena.", Toast.LENGTH_LONG).show();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
