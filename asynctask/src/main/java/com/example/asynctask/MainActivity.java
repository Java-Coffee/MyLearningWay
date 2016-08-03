package com.example.asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 构建AsyncTask子类的参数
 * AsyncTask<Params,Progress,Result>是一个抽象类
 * 通常用于被继承，继承AsyncTask需要指定如下三个泛型参数：
 * Params:启动任务时输入参数的类型
 * Progress:后台任务执行中返回进度值的类型
 * Result:后台执行任务完成后的返回结果的类型
 */

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private ProgressBar progressBar;
private static String Url = "http://b.hiphotos.baidu.com/zhidao/pic/item/b3b7d0a20cf431ad3aa108004836acaf2edd989c.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        imageView = (ImageView) findViewById(R.id.image);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute(Url);
    }
    class MyAsyncTask extends AsyncTask<String,Void,Bitmap>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            progressBar.setVisibility(View.GONE);
            imageView.setImageBitmap(bitmap);
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            //获取传递进来的参数
            String url = strings[0];
            Bitmap bitmap = null;
            URLConnection urlConnection;
            InputStream inputStream;
            try {
                urlConnection = new URL(url).openConnection();
                inputStream = urlConnection.getInputStream();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                Thread.sleep(3000);
                //通过decodeStream方法解析输入流
                bitmap = BitmapFactory.decodeStream(bufferedInputStream);
                inputStream.close();
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return bitmap;
        }
    }
}
