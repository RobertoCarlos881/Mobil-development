package com.example.webview_ejemplo1;

import android.content.Context;
import android.database.sqlite.*;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DatabaseHelper extends SQLiteOpenHelper {
    String sqlCreate = "CREATE TABLE Paginas (id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT)";
    public DatabaseHelper(Context c, String s, CursorFactory cf, int v){
        super(c, s, cf, v);
    }
    @Override
    public void onCreate(SQLiteDatabase db){ db.execSQL(sqlCreate);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqld, int ov, int nv) {
        sqld.execSQL("DROP TABLE IF EXISTS Paginas");
        sqld.execSQL(sqlCreate);
    }
}
