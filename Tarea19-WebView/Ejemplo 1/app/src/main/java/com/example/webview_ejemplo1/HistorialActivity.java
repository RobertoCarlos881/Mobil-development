package com.example.webview_ejemplo1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.*;
import android.view.View;
import android.widget.*;
import android.view.View.*;

public class HistorialActivity extends AppCompatActivity implements OnClickListener {
    LinearLayout jllHistory;
    String pagina,id;
    SQLiteDatabase sqld;

    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_historial);

        DatabaseHelper dbh = new DatabaseHelper(this, "DBHistorial", null, 1);
        sqld = dbh.getWritableDatabase();
        jllHistory = findViewById(R.id.xllHistory);

        abrir();
    }

    public void abrir(){
        Cursor c = sqld.rawQuery("SELECT id,url FROM Paginas", null);
        if (c.moveToFirst()) {
            do {
                id = c.getString(0);
                pagina = c.getString(1);
                Button temp = new Button(this);
                temp.setText(pagina+"");
                temp.setOnClickListener(this);
                temp.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                jllHistory.addView(temp);
            } while(c.moveToNext());
        }
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent();
        i.putExtra("PAGINA",((Button) view).getText().toString());
        setResult(RESULT_OK,i);
        finish();
    }
}
