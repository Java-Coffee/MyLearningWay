package com.example.learning3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private SimpleAdapter simpleAdapter;
    private List<Map<String,Object>>dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataList = new ArrayList<Map<String,Object>>();
        listView = (ListView) findViewById(R.id.listView);
        String[] arrayText={"选项1","选项2","选项3","选项4"};
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayText);
        //1.创建一个SimpleAdapter对象，为第三个参数创建布局文件
        simpleAdapter = new SimpleAdapter(this,getData(),R.layout.item,new String[]{"pic","text"},new int[]{R.id.pic,R.id.text});

        //listView.setAdapter(arrayAdapter);
        listView.setAdapter(simpleAdapter);
    }
    //创建一个getData方法
    private List<Map<String,Object>> getData(){
        for(int i = 0;i < 20;i++){
            Map<String,Object>map = new HashMap<String,Object>();
            map.put("pic",R.drawable.camera);
            map.put("text","camera"+ i);
            dataList.add(map);
        }
        return dataList;
    }
}
