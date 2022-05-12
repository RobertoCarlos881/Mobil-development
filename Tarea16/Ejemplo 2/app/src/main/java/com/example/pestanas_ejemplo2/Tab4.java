package com.example.pestanas_ejemplo2;

import android.os.*;
import androidx.fragment.app.Fragment;
import android.content.*;
import android.graphics.*;
import android.view.*;

public class Tab4 extends Fragment{
    Paint p;
    int x,y;
    Lienzo l;
    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        l = new Lienzo(this.getContext());
    }
    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle bn) {
        return l;
    }
}
