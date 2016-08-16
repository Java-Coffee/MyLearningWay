package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by DHW on 2016/8/16.
 */
public class BC3 extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String s =  intent.getStringExtra("msg");
        Log.i("info","receive3"+s);
        //接收广播信息后数据处理
        Bundle bundle = new Bundle();
        bundle.putString("test","广播处理的数据");
        setResultExtras(bundle);
    }
}
