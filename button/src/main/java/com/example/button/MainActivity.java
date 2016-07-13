package com.example.button;

import android.content.SyncStatusObserver;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.example.button.R.drawable.picture2;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private Button clickButton;
    private GoogleApiClient client;
    private AutoCompleteTextView AutoComplete;
    private ToggleButton Togbtn;
    private ImageView ImgView;
    private String[] Input = {"Beijing", "Beijing2", "Beijing3", "Shanghai", "Shanghai1", "Shanghai2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickButton = (Button) findViewById(R.id.click);
        AutoComplete = (AutoCompleteTextView) findViewById(R.id.Auto1);
        Togbtn = (ToggleButton) findViewById(R.id.Togglebtn);
        ImgView = (ImageView) findViewById(R.id.ImageView);
        Togbtn.setOnCheckedChangeListener(this);
        clickButton.setOnClickListener(new MyOnClickListener() {
            @Override
            public void onClick(View v) {
                super.onClick(v);
                Toast.makeText(MainActivity.this, "按钮被点击", Toast.LENGTH_LONG).show();
            }
        });
        //        clickButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println("button被点击");
//            }
//        });
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Input);
        AutoComplete.setAdapter(adapter);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        ImgView.setBackgroundResource(b ? R.drawable.picture1 : R.drawable.picture2);
    }
}

class MyOnClickListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        v.setAlpha(0.5f);
    }
}
