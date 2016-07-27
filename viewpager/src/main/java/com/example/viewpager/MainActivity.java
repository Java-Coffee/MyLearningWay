package com.example.viewpager;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<View> viewList;
    private List<String> taplist;
    private ViewPager viewPager;
    private PagerTitleStrip tabStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewList = new ArrayList<View>();
        taplist = new ArrayList<String>();

        //通过view对象作为viewpager数据源
        View view1 = View.inflate(this, R.layout.view1, null);
        View view2 = View.inflate(this, R.layout.view2, null);
        View view3 = View.inflate(this, R.layout.view3, null);
        View view4 = View.inflate(this, R.layout.view4, null);
        taplist.add("第一页");
        taplist.add("第二页");
        taplist.add("第三页");
        taplist.add("第四页");
        tabStrip = (PagerTitleStrip) findViewById(R.id.tab);
        tabStrip.setBackgroundColor(Color.BLUE);
        tabStrip.setTextColor(Color.RED);
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);
        MyPagerAdapter adapter = new MyPagerAdapter(viewList, taplist);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

    }
}
