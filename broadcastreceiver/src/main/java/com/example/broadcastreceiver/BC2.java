package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by DHW on 2016/8/16.
 */
public class BC2 extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String s =  intent.getStringExtra("msg");
        Log.i("info","receive2"+s);
    }
}
