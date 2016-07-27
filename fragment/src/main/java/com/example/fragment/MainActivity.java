package com.example.fragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
private RadioGroup radioGroup;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.buttonTest);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
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
                MyFragment2 fragment2 = new MyFragment2();
                android.app.FragmentManager fragmentmanager = getFragmentManager();
                FragmentTransaction beginTransaction = fragmentmanager.beginTransaction();
                beginTransaction.add(R.id.frame,fragment2);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
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
