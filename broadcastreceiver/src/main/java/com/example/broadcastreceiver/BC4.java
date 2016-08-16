package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by DHW on 2016/8/16.
 */
public class BC4 extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("info","接收到滞留广播信息");
    }
}
