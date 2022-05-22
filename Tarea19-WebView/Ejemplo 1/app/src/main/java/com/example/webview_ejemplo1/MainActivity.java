package com.example.webview_ejemplo1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.*;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.*;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    ImageButton jbn1, jbn2, jbn3, jbn4,jbn5;
    WebSettings ws;
    WebView wv;
    EditText jet;
    SQLiteDatabase sqld;
    String s="https://www.google.com/";
    static final int READ_BLOCK_SIZE = 100;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        DatabaseHelper dbh = new DatabaseHelper(this, "DBHistorial", null, 1);
        sqld = dbh.getWritableDatabase();
        jbn1 = (ImageButton) findViewById(R.id.xbn1);
        jbn1.setOnClickListener(this);
        jbn2 = (ImageButton) findViewById(R.id.xbn2);
        jbn2.setOnClickListener(this);
        jbn3 = (ImageButton) findViewById(R.id.xbn3);
        jbn3.setOnClickListener(this);
        jbn4 = (ImageButton) findViewById(R.id.xbn4);
        jbn4.setOnClickListener(this);
        jbn5 = (ImageButton) findViewById(R.id.xbn5);
        jbn5.setOnClickListener(this);
        jet = (EditText) findViewById(R.id.xet);
        wv = (WebView) findViewById(R.id.xwv);
        wv.setWebViewClient(new Cliente());
        ws = wv.getSettings();
        ws.setBuiltInZoomControls(false);
        ws.setJavaScriptEnabled(true);
        ws.setUseWideViewPort(true);

        wv.loadUrl(s);
        agregaHistorial(s);
    }

    class Cliente extends WebViewClient{
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            return false;
        }
        public void onPageFinished(WebView view, String url){
            jet.setText(url);
        }
    }

    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.xbn1:
                wv.goBack();
                break;
            case R.id.xbn2:
                wv.loadUrl(s);
                agregaHistorial(s);
                break;
            case R.id.xbn3:
                wv.goForward();
                break;
            case R.id.xbn4:
                wv.loadUrl(jet.getText() + "");
                agregaHistorial(jet.getText().toString());
                break;
            case R.id.xbn5:
                //Iniciar el intent con historial
                Intent i = new Intent(MainActivity.this,HistorialActivity.class);
                startActivityForResult(i,1);

                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null)
            wv.loadUrl(data.getStringExtra("PAGINA"));
    }

    void agregaHistorial(String url){
        ContentValues cv = new ContentValues();
        cv.put("url", url);
        sqld.insert("Paginas", null, cv);
    }
}