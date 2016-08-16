package com.example.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //动态注册Broadcast
        IntentFilter intentFilter = new IntentFilter("BC_1");
        BC3 bc3 = new BC3();
        registerReceiver(bc3, intentFilter);

    }
    public void doClick(View v){
        switch (v.getId()){
            case R.id.send1:
                Intent intent1 = new Intent();
                intent1.putExtra("msg","这是一条普通广播");
                intent1.setAction("BC_1");
                sendBroadcast(intent1);
                break;
            case R.id.send2:
                Intent intent2 = new Intent();
                intent2.putExtra("msg","这是一条有序广播");
                intent2.setAction("BC_1");
                sendOrderedBroadcast(intent2,null);
            case R.id.send3:
                Intent intent3 = new Intent();
                intent3.putExtra("msg","这是一条异步广播");
                intent3.setAction("BC_4");
                sendStickyBroadcast(intent3);
                IntentFilter intentFilter1 = new IntentFilter("BC_4");
                BC4 bc4 = new BC4();
                registerReceiver(bc4,intentFilter1);
            default:
                break;
        }
    }
}
