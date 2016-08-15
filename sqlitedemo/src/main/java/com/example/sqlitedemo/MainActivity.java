package com.example.sqlitedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建数据库，并且打开
        SQLiteDatabase db = openOrCreateDatabase("user.db",MODE_PRIVATE,null);


        db.execSQL("create table if not exists usertb(_id integer primary key autoincrement," +
                "name text not null,age integer not null,sex text not null)");
        //使用sql语句操作数据库
        db.execSQL("insert into usertb(name,age,sex) values('张三',18,'女')");
        db.execSQL("insert into usertb(name,age,sex) values('李四',19,'男')");
        db.execSQL("insert into usertb(name,age,sex) values('王三',20,'男')");
        //使用ContentValues函数操作数据库
        ContentValues values = new ContentValues();
        values.put("name","赵");
        values.put("age",17);
        values.put("sex","女");
        long rowId = db.insert("usertb",null,values);
        values.clear();
        values.put("name","孙");
        values.put("age",22);
        values.put("sex","男");
        long rowId1 = db.insert("usertb",null,values);

        values.put("sex","女");
        db.update("usertb",values,"_id>?",new String[]{"3"});//将ID大于三的所有人性别改成女
        db.delete("usertb","name like ?",new String[]{"%三%"});//将所有名字中带有三的人删除
        Cursor c = db.query("usertb",null,"_id>?",new String[]{"0"},null,null,"name");
        if (c != null){
            String [] columns = c.getColumnNames();
            while (c.moveToNext()){
                for (String columnName:columns){
                    Log.i("info",c.getString(c.getColumnIndex(columnName)));
                }
            }
            c.close();
        }


        Cursor cursor = db.rawQuery("select * from usertb",null);
        if (cursor != null){
            while (cursor.moveToNext()){
                Log.i("info","_id:"+cursor.getInt(cursor.getColumnIndex("_id")));
                Log.i("info","name"+cursor.getString(cursor.getColumnIndex("name")));
                Log.i("info","age"+cursor.getInt(cursor.getColumnIndex("age")));
                Log.i("info","sex"+cursor.getString(cursor.getColumnIndex("sex")));
            }
            cursor.close();
        }
        db.close();
    }
}
