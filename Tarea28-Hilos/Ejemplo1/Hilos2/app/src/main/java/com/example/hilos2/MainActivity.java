package com.example.hilos2;

import android.app.*;
import android.os.*;
import android.view.View;
import android.view.View.*;
import android.widget.*;

public class MainActivity extends Activity implements OnClickListener {
    private EditText jet1;
    private Button
            jbn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jet1 = (EditText) findViewById(R.id.xet1);
        jbn1 = (Button) findViewById(R.id.xbn1);
        jbn1.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        try{
            final int num = Integer.parseInt(jet1.getText().toString());
            new Thread(new Runnable(){
                public void run() {
                    try {
                        Thread.sleep(num*1000);
                    } catch (InterruptedException ie) {}
                }
            }).start();
        }catch (NumberFormatException e){
            Toast.makeText(this,"ingresar segundos...", Toast.LENGTH_SHORT).show();
        }
    }
}