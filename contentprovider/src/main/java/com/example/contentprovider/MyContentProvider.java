package com.example.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by DHW on 2016/8/15.
 */
public class MyContentProvider extends ContentProvider{
    @Override//在ContentProvider创建后调用
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override//根据Uri查询selection指定的条件所匹配的全部记录,并且可以指定查询哪些列，以什么方式(order)排序
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        return null;
    }

    @Nullable
    @Override//返回当前Uri的MIME类型，如果该Uri对应的数据可能包括多条记录
    //那么MIME类型字符串就是以vnd.android.dir/开头
    //如果该Uri对应的数据只有一条记录 该MIME类型字符串就是以vnd.android.cursor.item开头
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override//根据Uri插入Values对应的数据
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override//根据Uri删除selection指定的条件所匹配的全部记录
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override//根据Uri修改selection指定的条件所匹配的全部记录
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
