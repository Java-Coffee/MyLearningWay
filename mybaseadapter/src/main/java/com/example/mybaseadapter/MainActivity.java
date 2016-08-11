package com.example.mybaseadapter;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ItemBean>itemBeanList;
    private ListView listView;
    private String Url = "http://www.imooc.com/api/teacher?type=4&num=30";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
/*        itemBeanList = new ArrayList<>();
        for (int i = 0; i < 20;i++)
        {
            itemBeanList.add(new ItemBean(R.mipmap.ic_launcher,"这是标题"+i,"这是内容"+i));
        }
        MyAdapter adapter = new MyAdapter(this,itemBeanList);
        listView.setAdapter(adapter);*/
        new myAsyncTask().execute(Url);

    }
    private List<ItemBean> getJsonData(String url){
        List<ItemBean> itemBeanList = new ArrayList<>();
        try {
            InputStream input = new URL(url).openStream();
            Log.d("JSurl", String.valueOf(input));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String jsonStream = readStream(new URL(url).openStream());
            Log.d("TAG", "getJsonData: "+ jsonStream);
            JSONObject jsonObject;
            ItemBean itemBean;
            try {
                jsonObject = new JSONObject(jsonStream);
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for (int i = 0;i < jsonArray.length();i++){
                    jsonObject = jsonArray.getJSONObject(i);
                    itemBean = new ItemBean();
                    itemBean.ItemImageID = jsonObject.getString("picSmall");
                    itemBean.ItemTitle = jsonObject.getString("name");
                    itemBean.ItemContent = jsonObject.getString("description");
                    itemBeanList.add(itemBean);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemBeanList;
    }

    private String readStream(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        String result = "";
        Log.d("TAGR","这里是result" + result);
        try {
            String line = "";
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while ((line = bufferedReader.readLine()) != null){
                result += line;

            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
        class myAsyncTask extends AsyncTask<String, Void, List<ItemBean>> {
            @Override
            protected List<ItemBean> doInBackground(String... strings) {
                Log.d("AsT","执行异步加载");
                Log.d("UrL",strings[0]);
                return getJsonData(strings[0]);
            }

            @Override
            protected void onPostExecute(List<ItemBean> itemBean) {
                super.onPostExecute(itemBean);
                MyAdapter adapter = new MyAdapter(MainActivity.this,itemBean);
                listView.setAdapter(adapter);
            }
        }
    }