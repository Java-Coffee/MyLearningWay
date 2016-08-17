package com.example.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by DHW on 2016/8/17.
 */
public class MyStartService extends Service{
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
    public void onStart(Intent intent, int startId) {
        Log.i("info","Service--onStartCommand");
        super.onStart(intent, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("info","Service--onBindCommand");
        return null;
    }
}
