package com.example.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by DHW on 2016/7/27.
 */
public class Fragment1 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view1,container,false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Main","第一个销毁了");
    }
}
