package com.example.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

/**
 * Created by DHW on 2016/8/4.
 */

public class ProgressBarActivity extends AppCompatActivity{
    private ProgressBar progressBar;
    private MyAsyncTask myAsyncTask;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbar);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(myAsyncTask != null && myAsyncTask.getStatus() == AsyncTask.Status.RUNNING){
            //只是将异步任务标记为取消状态
            myAsyncTask.cancel(true);
        }
    }

    class MyAsyncTask extends AsyncTask<Void,Integer,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            for(int i = 0;i < 100;i++){
                if(isCancelled()){
                    break;
                }
                publishProgress(i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if(isCancelled()){
                return;
            }
            progressBar.setProgress(values[0]);
        }
    }
}
