package com.example.fechahora_ejemplo1;

import androidx.appcompat.app.AppCompatActivity;
import android.app.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;
import java.util.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    Button jbnF, jbnH;
    EditText txtDate, txtTime;
    int a, m, d, h, n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jbnF = (Button)findViewById(R.id.xbnF); jbnF.setOnClickListener(this);
        jbnH = (Button)findViewById(R.id.xbnH); jbnH.setOnClickListener(this);
        txtDate = (EditText)findViewById(R.id.xetF);
        txtTime = (EditText)findViewById(R.id.xetH);
    }
    @Override
    public void onClick(View v) {
        if (v == jbnF) {
            Calendar c = Calendar.getInstance();
            a = c.get(Calendar.YEAR);
            m = c.get(Calendar.MONTH);
            d = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dpd = new DatePickerDialog(this, new
                    DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker dp, int ye, int mo, int di) {
                            txtDate.setText(di + "-" + (mo + 1) + "-" + ye);
                        }
                    }, a, m, d);
            dpd.show();
        }
        if (v == jbnH) {
            Calendar c = Calendar.getInstance();
            h = c.get(Calendar.HOUR_OF_DAY);
            n = c.get(Calendar.MINUTE);
            TimePickerDialog tpd = new TimePickerDialog(this, new
                    TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker tp, int ho, int mi) {
                            txtTime.setText(ho + ":" + mi);
                        }
                    }, h, n, false);
            tpd.show();
        }
    }
}