package com.example.learning3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener {
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
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);

    }
    //创建一个getData方法
    private List<Map<String,Object>> getData() {
        for (int i = 0; i < 20; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("pic", R.drawable.camera);
            map.put("text", "camera" + i);
            dataList.add(map);
        }
        return dataList;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String text = listView.getItemAtPosition(i)+"";
        Toast.makeText(this,"position = "+i+"text="+ text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
    switch (i){
        case SCROLL_STATE_FLING://手指离开屏幕前用力滑动一下，视图依靠惯性继续滑动
            Map<String,Object>map = new HashMap<String, Object>();
            map.put("pic",R.drawable.clock);
            map.put("text","滑动增加项");
            dataList.add(map);
            simpleAdapter.notifyDataSetChanged();    //通知UI刷新界面，动态更新视图中所包含的数据
            break;
        case SCROLL_STATE_IDLE://手指离开屏幕，视图停止
            break;
        case SCROLL_STATE_TOUCH_SCROLL://手指在屏幕上持续滑动
            break;


    }

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {

    }
}
