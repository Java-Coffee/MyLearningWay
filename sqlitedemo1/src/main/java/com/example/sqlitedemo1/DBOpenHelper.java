package com.example.sqlitedemo1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DHW on 2016/8/15.
 */
public class DBOpenHelper extends SQLiteOpenHelper {
    public DBOpenHelper(Context context, String name) {
        super(context, name, null, 1);
    }

    @Override//创建数据库时调用，一般建库建表放在这里
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists usertb(_id integer primary key autoincrement," +
                "name text not null,age integer not null,sex text not null)");
        sqLiteDatabase.execSQL("insert into usertb(name,age,sex) values('张三',18,'女')");
    }

    @Override//数据库版本发生更新时调用
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
