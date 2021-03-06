package com.example.audiovideo_ejemplo2;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.View.*;
import android.widget.*;
import android.net.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    Button jbn;
    VideoView vvw;
    Uri uri;
    MediaController mcr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jbn = (Button) findViewById(R.id.xbn);
        jbn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        vvw = (VideoView) findViewById(R.id.xvv1);
        uri = Uri.parse("android.resource://com.example.audiovideo_ejemplo2/"+R.raw.this_is_love);
        mcr = new MediaController(this);
        vvw.setMediaController(mcr);
        vvw.setVideoURI(uri);
        vvw.start();
    }
}