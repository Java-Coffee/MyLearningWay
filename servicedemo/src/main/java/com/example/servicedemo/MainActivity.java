package com.example.servicedemo;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Intent intent1, intent2;
    private MyBindService.MyBinder myBinder;
    ServiceConnection conn = new ServiceConnection() {
        @Override//启动源与service连接成功时调用此方法
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            myBinder = (MyBindService.MyBinder)iBinder;
                   // service = ((MyBindService.MyBinder)iBinder).getService();
        }

        @Override//service意外断开获丢失时调用此方法
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i("info","onServiceDisconnected");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                intent1 = new Intent(MainActivity.this, MyStartService.class);
                startService(intent1);
                break;
            case R.id.stop:
                stopService(intent1);
                break;
            case R.id.bind:
                Log.i("info","click bind");
                intent2 = new Intent(MainActivity.this, MyBindService.class);
                bindService(intent2, conn, Service.BIND_AUTO_CREATE);
                break;
            case R.id.unbind:
                unbindService(conn);
                break;
            case R.id.play:
                myBinder.Play();
                break;
            case R.id.pause:
                myBinder.Pause();
                break;
            case R.id.pervious:
                myBinder.Pervious();
                break;
            case R.id.next:
                myBinder.Next();
                break;
            default:
                break;
        }
    }
}
