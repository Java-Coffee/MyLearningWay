package com.example.fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch(i){
            case R.id.first :
                Toast.makeText(MainActivity.this,"1",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,Fragment.class);
                startActivity(intent);
                break;
            case R.id.second:
                Toast.makeText(MainActivity.this,"2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.thrid:
                Toast.makeText(MainActivity.this,"3",Toast.LENGTH_SHORT).show();
                break;
            case R.id.forth:
                Toast.makeText(MainActivity.this,"4",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
