package com.example.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by DHW on 2016/8/17.
 */
public class MyBindService extends Service{
private MyBinder myBinder = new MyBinder();
    @Override
    public void onCreate() {
        Log.i("info","Service--onCreateCommand");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.i("info","Service--onDestroyCommand");
        super.onDestroy();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("info","Service--onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("info","Service--onUnbindCommand");
        return super.onUnbind(intent);
    }
public class MyBinder extends Binder{
    public void Play(){
        Log.i("info","播放");
    }
    public void Pause(){
        Log.i("info","暂停");
    }
    public void Pervious(){
        Log.i("info","上一首");
    }
    public void Next(){
        Log.i("info","下一首");
    }
}
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("info","Service--onBindCommand");
        return myBinder;
    }

}
