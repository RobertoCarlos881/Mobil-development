package com.example.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.*;
import android.widget.*;
public class MainActivity extends AppCompatActivity {
    Button jbn;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jbn = (Button)findViewById(R.id.xbn);
        if(ActivityCompat.checkSelfPermission(
                MainActivity.this, Manifest.permission.SEND_SMS)!=
                PackageManager.PERMISSION_GRANTED&&
                ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.SEND_SMS)!=
                        PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                    Manifest.permission.SEND_SMS,},1000);
        }
        jbn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                enviarMensaje("5511927550","Soy ESCOM y estoy enviando un Mensaje");
            }
        });
    }
    private void enviarMensaje (String n, String m){
        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(n,null, m,null,null);
            Toast.makeText(getApplicationContext(), "Mensaje Enviado.",
                    Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Mensaje no enviado, datos incorrectos.", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
        }
    }
}