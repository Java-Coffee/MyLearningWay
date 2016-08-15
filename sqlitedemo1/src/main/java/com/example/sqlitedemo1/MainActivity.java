package com.example.sqlitedemo1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBOpenHelper helper = new DBOpenHelper(MainActivity.this,"stu.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor c = db.rawQuery("select * from studb",null);

    }
}
