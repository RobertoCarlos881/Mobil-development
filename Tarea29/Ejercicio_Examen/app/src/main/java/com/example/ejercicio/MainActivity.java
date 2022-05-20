package com.example.ejercicio;

import android.Manifest;
import android.app.*;
import android.content.*;
import android.content.pm.PackageManager;
import android.location.*;
import android.os.*;
import android.util.Log;
import android.view.*;
import android.view.View.*;
import android.widget.*;

import androidx.core.app.ActivityCompat;

public class MainActivity extends Activity {
    Button btnActualizar, btnDesactivar;
    TextView lblLatitud, lblLongitud, lblPrecision;
    TextView lblEstado;
    LocationManager locManager;
    LocationListener locListener;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        btnActualizar = (Button) findViewById(R.id.BtnActualizar);
        btnDesactivar = (Button) findViewById(R.id.BtnDesactivar);
        lblLatitud = (TextView) findViewById(R.id.LblPosLatitud);
        lblLongitud = (TextView) findViewById(R.id.LblPosLongitud);
        lblPrecision = (TextView) findViewById(R.id.LblPosPrecision);
        lblEstado = (TextView) findViewById(R.id.LblEstado);
        btnActualizar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                iniciaLocalizacion();
            }
        });
        btnDesactivar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                locManager.removeUpdates(locListener);
            }
        });
    }

    private void iniciaLocalizacion() {
        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location loc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        mostrarPosicion(loc);
        locListener	= new LocationListener() {
            public void onLocationChanged(Location location){	mostrarPosicion(location); }
            public void onProviderDisabled(String provider){	lblEstado.setText("Proveedor OFF"); }
            public void onProviderEnabled(String provider){		lblEstado.setText("Proveedor ON"); }
            public void onStatusChanged(String provider, int status, Bundle extras){
                Log.i("", "Proveedor status: " + status);
                lblEstado.setText("Proveedor status: " + status);
            }
        };
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30000, 0, locListener);
    }
    private void mostrarPosicion(Location loc) {
        if(loc != null){
            lblLatitud.setText("Latitud: " + String.valueOf(loc.getLatitude()));
            lblLongitud.setText("Longitud: " + String.valueOf(loc.getLongitude()));
            lblPrecision.setText("Precision: " + String.valueOf(loc.getAccuracy()));
            Log.i("", String.valueOf(loc.getLatitude() + " - " + String.valueOf(loc.getLongitude())));
        }else{
            lblLatitud.setText("Latitud: (sin_datos)");
            lblLongitud.setText("Longitud: (sin_datos)");
            lblPrecision.setText("Precision: (sin_datos)");
        }
    }
}