package com.example.canvaspaint_ejemplo2;

import android.content.*;
import android.graphics.*;
import android.view.View;

public class Lienzo extends View {
    Paint p;
    Path r;
    int x, y, x0, y0;

    public Lienzo(Context c) {
        super(c);
    }

    protected void onDraw(Canvas c) {
        super.onDraw(c);
        p = new Paint();    // Canvas pinta atributos
        r = new Path();     // Paint asigna atributos
        x = c.getWidth();
        x0 = x / 2; // También: getMeasuredWidth(), o getRight(), x=480
        y = c.getHeight();
        y0 = y / 2; // También: getMeasuredHeight(), o getBottom(), y=762

        p.setColor(Color.WHITE); // Fondo blanco
        c.drawPaint(p);

        p.setColor(Color.BLACK); // Texto negro
        p.setTextSize(20);
        c.drawText("0,0", x0 + 5, y0 + 20, p);

        p.setColor(Color.rgb(0, 0, 255)); // Ejes azules
        c.drawLine(x0, 0, x0, y, p);//Dibuja eje Y
        c.drawLine(0, y0, x, y0, p);//Dibuja eje X

        //Dibuja secciones de X
        p.setColor(Color.BLACK);
        c.drawText("-3.14", (x0/2)+10, y0+30, p);
        c.drawText("3.14", (3*x0/2)-30, y0+30, p);
        c.drawLine(Float.parseFloat((x0/2)+23+""), y0-10, Float.parseFloat((x0/2)+23+""), y0+10, p);
        c.drawLine(Float.parseFloat((3*x0/2)-23+""), y0-10, Float.parseFloat((3*x0/2)-23+""), y0+10, p);

        //Dibuja secciones de Y
        c.drawText("500", (x/2)-50, 250, p);
        c.drawText("-500", (x/2)-50, y-250, p);
        c.drawText("150", (x/2)-50, (y/2)-150, p);
        c.drawText("-150", (x/2)-50, (y/2)+150, p);
        c.drawLine((x/2)-10,250,(x/2)+10,250, p);
        c.drawLine((x/2)-10,(y)-250,(x/2)+10,(y)-250, p);
        c.drawLine((x/2)-10,(y/2)-150,(x/2)+10,(y/2)-150, p);
        c.drawLine((x/2)-10,(y/2)+150,(x/2)+10,(y/2)+150, p);

        p.setColor(Color.BLUE);
        c.drawText("senA", 20, 20, p);

        p.setColor(Color.RED);
        c.drawText("cosA", 20, 50, p);

        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(2);
        p.setAntiAlias(true);
        r = new Path();
        x = getMeasuredWidth();
        r.moveTo(0, 0);
        p.setColor(Color.BLUE);
        for (int i = 1; i < x; i++)
            r.lineTo(i, (float) Math.sin(i/50f) * (-150f));
        r.offset(46, y0);
        c.drawPath(r, p);

        r = new Path();
        r.moveTo(0, 0);
        p.setColor(Color.RED);
        for (int i = 1; i < x; i++)
            r.lineTo(i, (float) Math.cos(i / 50f) * (-500f));
        r.offset(46, y0);
        c.drawPath(r, p);
    }
}
