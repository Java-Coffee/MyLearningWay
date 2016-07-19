package com.example.learning4;

/**
 * Created by DHW on 2016/7/19.
 */

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Spinner_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    private TextView textView;
    private List<String> list;
    private ArrayAdapter<String> adapter;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        spinner = (Spinner) findViewById(R.id.spinner);
        textView = (TextView) findViewById(R.id.textview);
        list = new ArrayList<String>();
        list.add("北京");
        list.add("上海");
        list.add("广州");
        list.add("深圳");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        //给数组适配器设置加载样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        textView.setText("你的选择是北京");
        spinner.setOnItemSelectedListener(this);

    }


    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String cityName = adapter.getItem(i);
        textView.setText("你的选择是" + cityName);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}