package com.example.sharedpreferencesdemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.SharedPreferences.Editor;

public class MainActivity extends AppCompatActivity {
    private EditText username,password;
    private CheckBox save;
    private Button login,cancel;
    SharedPreferences pref;
    Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //定义Sharedpreferences对象
        //SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        pref = getSharedPreferences("mypref",MODE_PRIVATE);
        //生成编辑器对象
        editor= pref.edit();
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        save = (CheckBox) findViewById(R.id.saveusername);
        login = (Button) findViewById(R.id.login);
        cancel = (Button) findViewById(R.id.cancel);
        String name = pref.getString("UserName","");
        if (name == null){
            save.setChecked(false);
        }else {
            save.setChecked(true);
            username.setText(name);
        }
    }
public void doClick(View v){
 switch (v.getId()){
     case R.id.login:
         String name = username.getText().toString().trim();
         String passwd = password.getText().toString().trim();
         if ("admin".equals(name) && "123456".equals(passwd)){
             if (save.isChecked()){
                 editor.putString("UserName",name);
                 editor.commit();
                 Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
             }
             else {
                 editor.remove("UserName");
                 editor.commit();
             }
         }
         else {
             Toast.makeText(MainActivity.this,"禁止登录",Toast.LENGTH_SHORT).show();
         }
         break;
     case R.id.cancel:
         break;
     default:
         break;
 }
}
}
