package com.example.sensores_ejemplo1;

import android.app.Activity;
import android.content.Context;
import android.hardware.*;
import android.widget.TextView;
import java.util.*;
import android.os.Bundle;

public class MainActivity extends Activity {
    TextView jtv;
    Sensor s;
    SensorManager sm;
    List <Sensor> l;
    String c, v;
    int n, t;
    float p, r, d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jtv = (TextView) findViewById(R.id.xtv);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        l = sm.getSensorList(Sensor.TYPE_ALL);
        n = l.size();
        jtv.append("\nSensores detectados: " + n + "\n");
        for(int i=0; i<n; i++){
            s = l.get(i);
            t = s.getType();
            c = s.getName();
            v = s.getVendor();
            p = s.getPower();
            r = s.getResolution();
            d = s.getMaximumRange();
            jtv.append("\nTipo de sensor: " + t + ", " + c);
            jtv.append("\nProveedor: " + v);
            jtv.append("\nPotencia (ma): " + p);
            jtv.append("\nMáxima resolución: " + r);
            jtv.append(", rango: " + d + "\n");
        }
    }
}