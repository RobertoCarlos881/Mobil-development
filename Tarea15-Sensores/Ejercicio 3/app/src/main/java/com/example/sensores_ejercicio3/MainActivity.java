package com.example.sensores_ejercicio3;

import androidx.appcompat.app.AppCompatActivity;
import android.hardware.*;
import android.content.*;
import android.os.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    //Orientacion
    private SensorManager sensorManager;
    private float[] accelerometerReading = new float[3];
    private float[] mMagnetometerReading = new float[3];
    private float[] rotationMatrix = new float[9];
    private float[] mOrientationAngles = new float[3];
    TextView jtvOrientacion,jtvOrientacionX,jtvOrientacionY,jtvOrientacionZ;
    //Proximidad
    float distance;
    TextView jtvProximidadValor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        jtvOrientacion = findViewById(R.id.xtvOrientacion);
        jtvOrientacionX = findViewById(R.id.xtvOrientacionX);
        jtvOrientacionY = findViewById(R.id.xtvOrientacionY);
        jtvOrientacionZ = findViewById(R.id.xtvOrientacionZ);
        jtvProximidadValor = findViewById(R.id.xtvProximidadValor);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
        // You must implement this callback in your code.
    }

    @Override
    protected void onResume() {
        super.onResume();

        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer,
                    SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_UI);
        }
        Sensor magneticField = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (magneticField != null) {
            sensorManager.registerListener(this, magneticField,
                    SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_UI);
        }
        Sensor proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if(proximity != null){
            sensorManager.registerListener(this,proximity,SensorManager.SENSOR_DELAY_NORMAL,SensorManager.SENSOR_DELAY_UI);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Don't receive any more updates from either sensor.
        sensorManager.unregisterListener(this);
    }

    // Get readings from accelerometer and magnetometer. To simplify calculations,
    // consider storing these readings as unit vectors.
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            System.arraycopy(event.values, 0, accelerometerReading,
                    0, accelerometerReading.length);
        } else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            System.arraycopy(event.values, 0, mMagnetometerReading,
                    0, mMagnetometerReading.length);
        } else if (event.sensor.getType() == Sensor.TYPE_PROXIMITY){
            distance = event.values[0];
        }
        updateOrientationAngles();
        updateValues();
    }

    // Compute the three orientation angles based on the most recent readings from
    // the device's accelerometer and magnetometer.
    public void updateOrientationAngles() {
        // Update rotation matrix, which is needed to update orientation angles.
        SensorManager.getRotationMatrix(rotationMatrix, null,
                accelerometerReading, mMagnetometerReading);

        // "mRotationMatrix" now has up-to-date information.

        SensorManager.getOrientation(rotationMatrix, mOrientationAngles);

        // "mOrientationAngles" now has up-to-date information.

    }

    void updateValues(){
        jtvOrientacionX.setText(mOrientationAngles[0]+"");
        jtvOrientacionY.setText(mOrientationAngles[1]+"");
        jtvOrientacionZ.setText(mOrientationAngles[2]+"");
        jtvProximidadValor.setText(distance+"");
    }
}