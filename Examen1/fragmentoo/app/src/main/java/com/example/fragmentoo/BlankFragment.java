package com.example.fragmentoo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BlankFragment extends Fragment {


    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    Button btn1, btn2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_blank,container,false);
        btn1=v.findViewById(R.id.btn1);
        btn2=v.findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent itn = new Intent(getActivity(), MainActivity.class);

                startActivity(itn);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                getActivity().finish(); System.exit(0);
            }
        });
        // Inflate the layout for this fragment
        return v;
    }
}