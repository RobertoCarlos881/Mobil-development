package com.example.pestanas_ejemplo2;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTabHost;
import android.content.*;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {
    private FragmentTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost= (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(),android.R.id.tabcontent);
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Pestaña 1"), Tab1.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Pestaña 2"), Tab2.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Pestaña 3"), Tab3.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator("Pestaña 4"), Tab4.class, null);
    }
}