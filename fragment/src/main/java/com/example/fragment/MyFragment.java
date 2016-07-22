package com.example.fragment;


import android.app.*;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by DHW on 2016/7/22.
 */
public class MyFragment extends android.app.Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment,container,false);
        TextView text = (TextView) view.findViewById(R.id.textview);
        text.setText("静态加载Fragment");
        return view;
    }
}
