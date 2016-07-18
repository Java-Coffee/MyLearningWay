package com.example.learning4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DHW on 2016/7/17.
 */
public class GridView_Activity extends AppCompatActivity {

    private GridView gridView;
    private List<Map<String,Object>>datalist;
    private SimpleAdapter adapter;
    private int[] icon = {R.drawable.address_book,R.drawable.calendar,R.drawable.camera,
            R.drawable.clock,R.drawable.games_control,R.drawable.messenger,R.drawable.ringtone,
            R.drawable.settings,R.drawable.speech_balloon,R.drawable.weather,R.drawable.world,
            R.drawable.youtube
    };
    private String[] iconName = {"通讯录","计算器","照相机","闹钟","游戏","短信",
            "铃声","设置","语音","天气","浏览器","视频"
    };
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    gridView = (GridView) findViewById(R.id.gridview);
        datalist = new ArrayList<Map<String, Object>>();
        adapter = new SimpleAdapter(this,getData(),R.layout.item_view,new String[]{"image","text"},new int[]{R.id.image,R.id.text});
        //getData();
        gridView.setAdapter(adapter);
    //    gridView.setOnItemClickListener();
    }

    private List<Map<String,Object>> getData() {
        for(int i=0;i<icon.length;i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image",icon[i]);
            map.put("text",iconName[i]);
            datalist.add(map);
        }
        return datalist;
    }
}
