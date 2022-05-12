package com.example.sensores_ejercicio4;

import java.util.*;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.hardware.*;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView jlv1 = (ListView) findViewById(R.id.xlv1);
        final SensorListAdapter adapter = new SensorListAdapter(this,R.layout.sensor_list_element);
        jlv1.setAdapter(adapter);

        for(final SensorElement s : getSensores()){
            adapter.add(s);
        }
    }

    private List<SensorElement> getSensores(){
        List<SensorElement> lista = new ArrayList<SensorElement>();

        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor s;
        List<Sensor> l = sm.getSensorList(Sensor.TYPE_ALL);
        int cantSensores = l.size();

        for(int i=0;i<cantSensores;i++){
            s = l.get(i);
            switch(i%7){
                case 0:
                    lista.add(new SensorElement(
                            s.getName(),
                            s.getVendor(),
                            s.getType(),
                            s.getPower(),
                            s.getResolution(),
                            s.getMaximumRange(),
                            R.drawable.compass64
                    ));
                    break;
                case 1:
                    lista.add(new SensorElement(
                            s.getName(),
                            s.getVendor(),
                            s.getType(),
                            s.getPower(),
                            s.getResolution(),
                            s.getMaximumRange(),
                            R.drawable.android64
                    ));
                    break;
                case 2:
                    lista.add(new SensorElement(
                            s.getName(),
                            s.getVendor(),
                            s.getType(),
                            s.getPower(),
                            s.getResolution(),
                            s.getMaximumRange(),
                            R.drawable.speed64
                    ));
                    break;
                case 3:
                    lista.add(new SensorElement(
                            s.getName(),
                            s.getVendor(),
                            s.getType(),
                            s.getPower(),
                            s.getResolution(),
                            s.getMaximumRange(),
                            R.drawable.monitor64
                    ));
                    break;
                case 4:
                    lista.add(new SensorElement(
                            s.getName(),
                            s.getVendor(),
                            s.getType(),
                            s.getPower(),
                            s.getResolution(),
                            s.getMaximumRange(),
                            R.drawable.processor64
                    ));
                    break;
                case 5:
                    lista.add(new SensorElement(
                            s.getName(),
                            s.getVendor(),
                            s.getType(),
                            s.getPower(),
                            s.getResolution(),
                            s.getMaximumRange(),
                            R.drawable.bright64
                    ));
                    break;
                case 6:
                    lista.add(new SensorElement(
                            s.getName(),
                            s.getVendor(),
                            s.getType(),
                            s.getPower(),
                            s.getResolution(),
                            s.getMaximumRange(),
                            R.drawable.lamp64
                    ));
                    break;
            }
        }

        return lista;
    }
}