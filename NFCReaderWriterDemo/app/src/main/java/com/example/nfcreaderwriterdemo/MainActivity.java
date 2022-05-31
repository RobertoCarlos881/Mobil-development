package com.example.nfcreaderwriterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private static final int DIALOG_WRITE_URL = 1;
    private EditText mMyUrl;
    private Button mMyWriteUrlButton;
    private boolean mWriteUrl = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMyUrl = (EditText) findViewById(R.id.myUrl);
        mMyWriteUrlButton = (Button) findViewById(R.id.myWriteUrlButton);

        mMyWriteUrlButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mWriteUrl = true;
                MainActivity.this.showDialog(DIALOG_WRITE_URL);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id, Bundle args) {
        switch (id) {
            case DIALOG_WRITE_URL:
                return new AlertDialog.Builder(this)
                        .setTitle("Write URL to tag..")
                        .setMessage("Touch tag to start writing.")
                        .setCancelable(true)
                        .setNeutralButton(android.R.string.cancel,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface d, int arg) {
                                        d.cancel();
                                    }
                                })
                        .setOnCancelListener(new DialogInterface.OnCancelListener() {
                            public void onCancel(DialogInterface d) {
                                mWriteUrl = false;
                            }
                        }).create();
        }
        return null;
    }
}