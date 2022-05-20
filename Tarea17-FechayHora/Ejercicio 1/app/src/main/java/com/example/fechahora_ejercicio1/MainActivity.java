package com.example.fechahora_ejercicio1;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.view.View.OnClickListener;
import android.widget.*;
import android.view.*;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.database.*;
import java.util.*;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    ImageButton jbtnFecha, jbtnHora;
    Button jbtnGuardar, jbtnMostrar;
    TextView jtvLista;
    EditText jetNombre, jetFecha, jetHora;
    int a1, m1, d1, a2, m2, d2, h1, n1, h2, n2;
    SQLiteDatabase base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jbtnFecha = findViewById(R.id.xbtnFecha);
        jbtnHora = findViewById(R.id.xbtnHora);
        jbtnGuardar = findViewById(R.id.xbtnGuardar);
        jbtnMostrar = findViewById(R.id.xbtnMostrar);
        jtvLista = findViewById(R.id.xtvLista);
        jetNombre = findViewById(R.id.xetNombre);
        jetFecha = findViewById(R.id.xetFecha);
        jetHora = findViewById(R.id.xetHora);

        jbtnFecha.setOnClickListener(this);
        jbtnHora.setOnClickListener(this);
        jbtnGuardar.setOnClickListener(this);
        jbtnMostrar.setOnClickListener(this);

        DBHelper configDB = new DBHelper(this,"DBPersonas",null,1);
        base = configDB.getWritableDatabase();

        mostrar();
    }

    @Override
    public void onClick(View v){
        if(v == jbtnFecha){
            Calendar c = Calendar.getInstance();
            a1 = c.get(Calendar.YEAR);
            m1 = c.get(Calendar.MONTH);
            d1 = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialogoFecha = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker dp, int ye, int mo, int di) {
                        a2 = ye;
                        m2 = mo+1;
                        d2 = di;
                        jetFecha.setText(d2+"/"+m2+"/"+a2);
                    }
                },
                a1,
                m1,
                d1
            );
            dialogoFecha.show();
        }
        if(v == jbtnHora){
            Calendar c = Calendar.getInstance();
            h1 = c.get(Calendar.HOUR_OF_DAY);
            n1 = c.get(Calendar.MINUTE);
            TimePickerDialog tpd = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker tp, int ho, int mi) {
                            h2 = ho;
                            n2 = mi;
                            jetHora.setText(h2+":"+String.format("%02d",n2));
                        }
                    },
                    h1,
                    n1,
                    false
            );
            tpd.show();
        }
        if(v == jbtnGuardar){
            ContentValues cv = new ContentValues();
            cv.put("nombre",jetNombre.getText().toString());
            cv.put("day",d2);
            cv.put("month",m2);
            cv.put("year",a2);
            cv.put("hour",h2);
            cv.put("minute",n2);

            base.insert("Personas",null,cv);

            jetNombre.setText("");
            jetFecha.setText("");
            jetHora.setText("");
            mostrar();
        }
        if(v == jbtnMostrar)
            mostrar();
    }

    private void mostrar(){
        int id,dia,mes,anio,hora,minuto;
        String nombre;
        Cursor c = base.rawQuery("SELECT id,nombre,day,month,year,hour,minute FROM Personas", null);

        jtvLista.setText("");

        if (c.moveToFirst()) {
            do {
                id = Integer.parseInt(c.getString(0));
                nombre = c.getString(1);
                dia = Integer.parseInt(c.getString(2));
                mes = Integer.parseInt(c.getString(3));
                anio = Integer.parseInt(c.getString(4));
                hora = Integer.parseInt(c.getString(5));
                minuto = Integer.parseInt(c.getString(6));
                jtvLista.append(" " + id + "\t" + nombre + "\t\t" + dia + "/" + mes + "/" + anio + "\t\t" + hora + ":" + String.format("%02d",minuto) + "\n");
            } while(c.moveToNext());
        }
    }
}