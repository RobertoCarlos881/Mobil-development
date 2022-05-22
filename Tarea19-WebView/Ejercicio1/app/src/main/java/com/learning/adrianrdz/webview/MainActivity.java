package com.learning.adrianrdz.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.*;
import android.widget.*;
public class MainActivity extends Activity implements OnClickListener{
    Button jbn1, jbn2, jbn3, jbn4, jbn5;
    ListView lv_history;
    WebSettings ws;
    WebView wv;
    EditText jet;
    String s="https://www.google.com/";
    public void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_main);
        jbn1 = (Button) findViewById(R.id.xbn1);
        jbn1.setOnClickListener(this);
        jbn2 = (Button) findViewById(R.id.xbn2);
        jbn2.setOnClickListener(this);
        jbn3 = (Button) findViewById(R.id.xbn3);
        jbn3.setOnClickListener(this);
        jbn4 = (Button) findViewById(R.id.xbn4);
        jbn4.setOnClickListener(this);
        jbn5 = (Button) findViewById(R.id.xbn5);
        jbn5.setOnClickListener(this);

        lv_history = (ListView) findViewById(R.id.lv_history);

        jet = (EditText) findViewById(R.id.xet);
        wv = (WebView) findViewById(R.id.xwv);
        wv.setWebViewClient(new Cliente());
        ws = wv.getSettings();
        ws.setBuiltInZoomControls(true);
        ws.setJavaScriptEnabled(true);
        ws.setUseWideViewPort(true);
    }
    class Cliente extends WebViewClient{
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            return false;
        }
        public void onPageFinished(WebView view, String url){
            jet.setText(url);
        }
    }
    public void onClick(View v){ int id = v.getId(); switch(id){
        case R.id.xbn1: wv.goBack(); break;
        case R.id.xbn2: wv.loadUrl(s); break;
        case R.id.xbn3: wv.goForward(); break;
        case R.id.xbn4: wv.loadUrl(jet.getText() + ""); break;
        case R.id.xbn5: showHistory(); break;
    }

    }

    private void showHistory(){
        WebBackForwardList currentList = wv.copyBackForwardList();
        int currentSize = currentList.getSize();
        String[] history = new String[currentSize];
        for(int i = 0; i < currentSize; ++i){
            WebHistoryItem item = currentList.getItemAtIndex(i);
            history[i] = item.getTitle();
        }
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, history);
        lv_history.setAdapter(adapter);
    }
}