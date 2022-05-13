package com.example.fragmentoo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;


public class Tabla
{
    // Variables de la clase

    private TableLayout tabla;          // Layout donde se pintará la tabla
    private ArrayList<TableRow> filas;  // Array de las filas de la tabla
    private Activity actividad;
    private Resources rs;
    private int FILAS, COLUMNAS;        // Filas y columnas de nuestra tabla

    public Tabla(Activity actividad, TableLayout tabla)
    {
        this.actividad = actividad;
        this.tabla = tabla;
        rs = this.actividad.getResources();
        FILAS = COLUMNAS = 0;
        filas = new ArrayList<TableRow>();
    }

    public void agregarFilaTabla(ArrayList<String> elementos,int n)
    {
        TableRow.LayoutParams layoutCelda;
        TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow fila = new TableRow(actividad);
        fila.setLayoutParams(layoutFila);

        for(int i = 0; i< elementos.size(); i++)
        {
            TextView texto = new TextView(actividad);
            texto.setText(String.valueOf(elementos.get(i)));
            texto.setGravity(Gravity.CENTER_HORIZONTAL);
            texto.setTextAppearance(actividad, R.style.estilo_celda);
            if(n==1){
                texto.setBackgroundResource(R.drawable.tabla_celda);
            }else{
                texto.setBackgroundResource(R.drawable.tabla_celda_cabecera);
            }
            if(i==elementos.size()-1){
                texto.setBackgroundResource(R.drawable.tabla_celda);
            }
            layoutCelda = new TableRow.LayoutParams(obtenerAnchoPixelesTexto(texto.getText().toString()), TableRow.LayoutParams.WRAP_CONTENT);
            texto.setLayoutParams(layoutCelda);

            fila.addView(texto);
        }

        tabla.addView(fila);
        filas.add(fila);

        FILAS++;
    }

    public void agregarColumnasTabla(int columnas,int n)
    {
        for(int i = 0; i < columnas; i++)
        {
            TableRow.LayoutParams layoutCelda;
            TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
            TableRow fila = new TableRow(actividad);
            fila.setLayoutParams(layoutFila);

            TextView texto = new TextView(actividad);
            texto.setText("");
            texto.setGravity(Gravity.CENTER_HORIZONTAL);
            texto.setTextAppearance(actividad, R.style.estilo_celda);
            if(n==1){
                texto.setBackgroundResource(R.drawable.tabla_celda);
            }else{
                texto.setBackgroundResource(R.drawable.tabla_celda_cabecera);
            }

            layoutCelda = new TableRow.LayoutParams(obtenerAnchoPixelesTexto(""), TableRow.LayoutParams.WRAP_CONTENT);
            texto.setLayoutParams(layoutCelda);

            fila.addView(texto);
            tabla.addView(fila);
            filas.add(fila);
        }

        COLUMNAS += columnas;
    }

    public void eliminarFila(int indicefilaeliminar)
    {
        if( indicefilaeliminar > 0 && indicefilaeliminar < FILAS )
        {
            tabla.removeViewAt(indicefilaeliminar);
            FILAS--;
        }
    }

    public int getFilas()
    {
        return FILAS;
    }

    public int getColumnas()
    {
        return COLUMNAS;
    }

    public int getCeldasTotales()
    {
        return FILAS * COLUMNAS;
    }

    private int obtenerAnchoPixelesTexto(String texto)
    {
        Paint p = new Paint();
        Rect bounds = new Rect();
        p.setTextSize(50);

        p.getTextBounds(texto, 0, texto.length(), bounds);
        return bounds.width();
    }

}