package com.example.mybaseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ItemBean>itemBeanList;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        itemBeanList = new ArrayList<>();
        for (int i = 0; i < 20;i++)
        {
            itemBeanList.add(new ItemBean(R.mipmap.ic_launcher,"这是标题"+i,"这是内容"+i));
        }
        MyAdapter adapter = new MyAdapter(this,itemBeanList);
        listView.setAdapter(adapter);

    }
}
