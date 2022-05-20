package com.example.dibujoamano_ejemplo1;

import android.content.Context;
import android.os.*;
import android.app.*;
import android.view.*;
import android.graphics.*;


public class MainActivity extends Activity {
    Lienzo l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            pn.setStyle(Paint.Style.STROKE);
            pn.setStrokeWidth(3);
            pn.setColor(Color.BLACK);
            c.drawColor(Color.rgb(250, 250, 100));
            if(s == "00") pt.moveTo(x, y);
            if(s == "xy") pt.lineTo(x, y);
            c.drawPath(pt, pn);
        }
        public boolean onTouchEvent(MotionEvent e){
            x = e.getX();
            y = e.getY();
            if(e.getAction() == MotionEvent.ACTION_DOWN) s = "00";
            if(e.getAction() == MotionEvent.ACTION_MOVE) s = "xy";
            invalidate();
            return true;
        }
    }
}