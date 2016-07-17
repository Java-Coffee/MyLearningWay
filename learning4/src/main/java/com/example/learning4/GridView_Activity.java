package com.example.learning4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

/**
 * Created by DHW on 2016/7/17.
 */
public class GridView_Activity extends AppCompatActivity {

    private GridView gridView;
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    gridView = (GridView) findViewById(R.id.gridview);
    //    gridView.setOnItemClickListener();
    }
}
