package com.example.fechahora_ejercicio1;

import android.content.Context;
import android.database.sqlite.*;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DBHelper extends SQLiteOpenHelper{
    String sqlCrearTabla = "CREATE TABLE Personas (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, day INTEGER, month INTEGER,year INTEGER,hour INTEGER,minute INTEGER)";

    public DBHelper(Context contexto, String nombreDB, CursorFactory cf, int version){
        super(contexto,nombreDB,cf,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(sqlCrearTabla);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqld, int ov, int nv) {
        sqld.execSQL("DROP TABLE IF EXISTS Contactos");
        sqld.execSQL(sqlCrearTabla);
    }
}
