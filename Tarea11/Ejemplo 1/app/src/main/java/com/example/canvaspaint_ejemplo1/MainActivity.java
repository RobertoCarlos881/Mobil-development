package com.example.canvaspaint_ejemplo1;

import android.app.Activity;

import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Lienzo l = new Lienzo(this);
        setContentView(l);
    }
}