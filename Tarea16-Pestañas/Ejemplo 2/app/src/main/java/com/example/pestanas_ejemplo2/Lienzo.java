package com.example.pestanas_ejemplo2;

import android.os.*;
import android.content.*;
import android.graphics.*;
import android.view.*;

public class Lienzo extends View{
    Paint p;
    int x, y;

    public Lienzo(Context c){
        super(c);
    }

    protected void onDraw(Canvas c){
        super.onDraw(c); // Canvas pinta atributos
        p = new Paint(); // Paint asigna atributos
        x = c.getWidth(); 
        y = c.getHeight(); 
        p.setColor(Color.WHITE); // Fondo blanco
        c.drawPaint(p);

        float centroX = x/2, centroY = y/2, radio=centroX/2;

        for(int i = 0;i<15;i++){//El limite del for determina la 'profundidad' de la figura
            //Pintar cuadrados rojos
            p.setColor(Color.RED);
            c.drawRect(centroX-radio,centroY-radio,centroX+radio,centroY+radio,p);

            //Pintar circulos blancos
            p.setColor(Color.WHITE);
            c.drawCircle(centroX,centroY,radio,p);

            radio = (float) Math.sqrt((radio*radio)/2);
        }
    }
}
