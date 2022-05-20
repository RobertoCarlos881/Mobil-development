package com.example.lampara_ejercicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.DialogInterface;
import android.hardware.camera2.*;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private CameraManager mCameraManager;
    private String mCameraId;
    private ToggleButton toggleButton;
    private boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isFlashAvailable = getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT);

        if (!isFlashAvailable) {
            showNoFlashError();
        }

        mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            mCameraId = mCameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        toggleButton = findViewById(R.id.LED);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                status = isChecked;
                switchFlashLight();
            }
        });
    }

    public void showNoFlashError() {
        AlertDialog alert = new AlertDialog.Builder(this)
                .create();
        alert.setTitle("Error");
        alert.setMessage("Tu dispositivo no cuenta con flash.");
        alert.setButton(DialogInterface.BUTTON_POSITIVE, "Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.show();
    }

    public void switchFlashLight() {
        //Creación del hilo
        new Thread(new Runnable(){
            public void run() {
                while(status){
                    try {
                        //////////////////////////////////////////////////////////////////////////////
                        //Primeros ciclos cortos
                        //////////////////////////////////////////////////////////////////////////////
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                try {
                                    //Encender lámpara
                                    mCameraManager.setTorchMode(mCameraId, true);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        //Mantener encendida 250ms
                        Thread.sleep(250);
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                try {
                                    //Apagar lámpara
                                    mCameraManager.setTorchMode(mCameraId, false);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        //Mantener apagada 250ms
                        Thread.sleep(250);
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                try {
                                    //Encender lámpara segunda vez
                                    mCameraManager.setTorchMode(mCameraId, true);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        //Mantener encendida 250ms
                        Thread.sleep(250);
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                try {
                                    //Apagar lampara segunda vez
                                    mCameraManager.setTorchMode(mCameraId, false);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        //Mantener apagada 250ms
                        Thread.sleep(250);
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                try {
                                    //Encender lámpara tercera vez
                                    mCameraManager.setTorchMode(mCameraId, true);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        //Mantener encendida 250ms
                        Thread.sleep(250);
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                try {
                                    //Apagar lampara
                                    mCameraManager.setTorchMode(mCameraId, false);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        //Mantener apagada 250ms
                        Thread.sleep(250);
                        //////////////////////////////////////////////////////////////////////////////
                        //Ciclos Largos
                        //////////////////////////////////////////////////////////////////////////////
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                try {
                                    mCameraManager.setTorchMode(mCameraId, true);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                try {
                                    mCameraManager.setTorchMode(mCameraId, false);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        Thread.sleep(250);
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                try {
                                    mCameraManager.setTorchMode(mCameraId, true);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                try {
                                    mCameraManager.setTorchMode(mCameraId, false);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        Thread.sleep(250);
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                try {
                                    mCameraManager.setTorchMode(mCameraId, true);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                try {
                                    mCameraManager.setTorchMode(mCameraId, false);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        Thread.sleep(250);
                        //////////////////////////////////////////////////////////////////////////////
                        //Segundos ciclos cortos
                        //////////////////////////////////////////////////////////////////////////////
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                try {
                                    mCameraManager.setTorchMode(mCameraId, true);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        Thread.sleep(250);
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                try {
                                    mCameraManager.setTorchMode(mCameraId, false);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        Thread.sleep(250);
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                try {
                                    mCameraManager.setTorchMode(mCameraId, true);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        Thread.sleep(250);
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                try {
                                    mCameraManager.setTorchMode(mCameraId, false);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        Thread.sleep(250);
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                try {
                                    mCameraManager.setTorchMode(mCameraId, true);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        Thread.sleep(250);
                        runOnUiThread(new Runnable() {
                            @Override public void run() {
                                try {
                                    mCameraManager.setTorchMode(mCameraId, false);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        //Esperar 1.5s entre ciclo y ciclo
                        Thread.sleep(1500);
                    } catch (InterruptedException ie) {}
                }
            }
        }).start();
    }
}