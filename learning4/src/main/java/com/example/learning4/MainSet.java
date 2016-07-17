package com.example.learning4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by DHW on 2016/7/17.
 */
public class MainSet extends AppCompatActivity {
    private Button button1;
    private Button button2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_set);
        button1 = (Button) findViewById(R.id.date_time);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainSet.this,Date_Time_Activity.class);
                MainSet.this.startActivity(intent1);
            }
        });
        button2 = (Button) findViewById(R.id.gridview);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainSet.this,GridView_Activity.class);
                MainSet.this.startActivity(intent2);
            }
        });
    }
}
