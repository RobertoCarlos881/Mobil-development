package com.example.sensores_ejercicio4;

public class SensorElement {
    private final String nomSensor, fabSensor;
    private final int tipo, icono;
    private final float power, resolution, maxRange;

    public SensorElement(String n, String f, int t, float pow, float res, float mR, int ico){
        this.nomSensor = n;
        this.fabSensor = f;
        this.tipo = t;
        this.power = pow;
        this.resolution = res;
        this.maxRange = mR;
        this.icono = ico;
    }

    String getNombre(){
        return this.nomSensor;
    }

    String getFabricante(){
        return this.fabSensor;
    }

    int getTipo(){
        return this.tipo;
    }

    float getPotencia(){
        return this.power;
    }

    float getResolucion(){
        return this.resolution;
    }

    float getRangoMaximo(){
        return this.maxRange;
    }

    int getIcono(){
        return this.icono;
    }
}
