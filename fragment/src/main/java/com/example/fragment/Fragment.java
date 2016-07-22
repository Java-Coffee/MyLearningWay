package com.example.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by DHW on 2016/7/22.
 */
public class Fragment extends AppCompatActivity {
    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);
        button = (Button) findViewById(R.id.Button);
        textView = (TextView) findViewById(R.id.textview);
        button.setText("改变");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("改变了此处的文字");
            }
        });
    }
}
