package com.example.hilos;

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
            int num = Integer.parseInt(jet1.getText().toString());
            Thread.sleep(num*1000);
        }catch (NumberFormatException e){
            Toast.makeText(this,"Ingresar los segundos.", Toast.LENGTH_SHORT).show();
        } catch (InterruptedException e) { }
    }
}