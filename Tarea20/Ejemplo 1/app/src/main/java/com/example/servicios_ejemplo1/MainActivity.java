package com.example.servicios_ejemplo1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private TextView jtv,jtvPause;
    private Button jbn,jbnDetener;
    public boolean  isD = false;
    public boolean isT =  true;
    public double time;
    public double timePause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jtv = (TextView) findViewById(R.id.xtvT);
        jtvPause = findViewById(R.id.xtvPause);
        jbn = (Button) findViewById(R.id.xbnI);
        jbnDetener = findViewById(R.id.xbnDetener);
        Button stopButton = (Button) findViewById(R.id.xbnT);
        jbnDetener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isD){
                    jtvPause.setVisibility(View.VISIBLE);
                    jbnDetener.setText("Reanudar");
                    timePause = time;
                    stopCrono();
                    isD = true;
                }
                else{
                    jbnDetener.setText("Detener");
                    jtvPause.setVisibility(View.INVISIBLE);
                    isD = false;
                    initCrono();
                }
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                stopCrono();
                isT = true;
                isD = false;
                jbnDetener.setVisibility(View.INVISIBLE);
                jtvPause.setVisibility(View.INVISIBLE);
                stopButton.setVisibility(view.INVISIBLE);
            }
        });
        jbn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                initCrono();
                time = 0;
                isT = false;
                timePause = 0;
                jbnDetener.setVisibility(View.VISIBLE);
                stopButton.setVisibility(View.VISIBLE);
            }
        });

        MiCrono.setUpdateListener(this);
    }

    @Override
    protected void onDestroy() {
        stopCrono();
        super.onDestroy();
    }

    private void initCrono() {
        Intent in = new Intent(this, MiCrono.class);
        startService(in);
    }

    private void stopCrono() {
        Intent in = new Intent(this, MiCrono.class);
        stopService(in);
    }

    public void refreshCrono(double t) {
        time = t + timePause;
        if(isT)jtv.setText("0.0 segs");
        else if(isD){
            jtv.setText(String.format("%.2f", timePause) + " segs");
        }
        else{
            jtv.setText(String.format("%.2f", time) + " segs");
        }
    }
}