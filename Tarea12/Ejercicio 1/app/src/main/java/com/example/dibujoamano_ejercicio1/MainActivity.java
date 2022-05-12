package com.example.dibujoamano_ejercicio1;

import android.content.Context;
import android.os.*;
import androidx.appcompat.app.*;
import android.view.*;
import android.graphics.*;
public class MainActivity extends AppCompatActivity{
    Lienzo l;
    public void onCreate(Bundle b){
        super.onCreate(b);
        l = new Lienzo(this);
        setContentView(l);
    }
    class Lienzo extends View{
        Path pt;
        Paint pn;
        String s;
        float x, y;
        public Lienzo(Context c){
            super(c);
            pt = new Path();
        }
        public void onDraw(Canvas c){
            pn = new Paint();

            c.drawRGB(255, 255, 0);

            pn.setStyle(Paint.Style.STROKE);
            pn.setStrokeWidth(3);
            pn.setColor(Color.BLACK);
            c.drawColor(Color.rgb(250, 250, 100));
            if(s == "00") pt.moveTo(x, y);
            if(s == "xy") pt.lineTo(x, y);
            c.drawPath(pt, pn);

            pn.setARGB(255, 255, 0, 0);
            pn.setStrokeWidth(4);
            pn.setStyle(Paint.Style.STROKE);
            c.drawCircle(500, 500, 20, pn);
            c.drawCircle(100, 750, 20, pn);
            c.drawCircle(300, 1200, 20, pn);
        }
        public boolean onTouchEvent(MotionEvent e){
            if(e.getAction() == MotionEvent.ACTION_DOWN){
                x = e.getX();
                y = e.getY();
                s = "00";
            }
            if(e.getAction() == MotionEvent.ACTION_UP){
                x = e.getX();
                y = e.getY();
                s = "xy";
            }
            invalidate();
            return true;
        }
    }
}