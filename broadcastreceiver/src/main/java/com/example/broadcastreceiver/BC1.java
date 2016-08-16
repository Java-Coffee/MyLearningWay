package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by DHW on 2016/8/16.
 */
public class BC1 extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String s =  intent.getStringExtra("msg");
        Log.i("info","receive1"+s);
        Bundle bundle = getResultExtras(true);
        String s1 = bundle.getString("test");
        Log.i("info","接收到处理数据"+s1);//运行后s1结果为null，说明普通广播不能接收处理的数据
        //abortBroadcast();可以截断广播
    }
}
