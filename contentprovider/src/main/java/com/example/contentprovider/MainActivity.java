package com.example.contentprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取系统的ContentProvider
        ContentResolver cr = getContentResolver();
        Cursor cursor = cr.query(Contacts.CONTENT_URI, new String[]{Contacts._ID, Contacts.DISPLAY_NAME}, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndex("_id"));
                Log.i("info", "_id:" + id);
                Log.i("info", "name:" + cursor.getColumnIndex("display_name"));
                Cursor cursor1 = cr.query(Phone.CONTENT_URI, new String[]{Phone.NUMBER, Phone.TYPE}, Phone.CONTACT_ID + "=" + id, null, null);
                //根据联系人id查询联系人电话号码
                if (cursor1 != null) {
                    while (cursor1.moveToNext()) {
                        int type = cursor1.getInt(cursor1.getColumnIndex(Phone.TYPE));
                        if (type == Phone.TYPE_HOME) {
                            Log.i("info", "家庭电话：" + cursor1.getString(cursor1.getColumnIndex(Phone.NUMBER)));
                        } else if (type == Phone.TYPE_MOBILE) {
                            Log.i("info", "手机：" + cursor1.getString(cursor1.getColumnIndex(Phone.NUMBER)));
                        }
                        cursor1.close();
                    }
                    //根据联系人的ID查询联系人的邮箱地址
                    Cursor cursor2 = cr.query(Email.CONTENT_URI, new String[]{Email.ADDRESS, Email.TYPE}, Email.CONTACT_ID + "=" + id, null, null);
                    if (cursor2 != null) {
                        while (cursor2.moveToNext()) {
                            int type = cursor2.getInt(cursor2.getColumnIndex(Email.TYPE));
                            if (type == Email.TYPE_WORK) {
                                Log.i("info", "工作邮箱：" + cursor2.getString(cursor2.getColumnIndex(Email.DATA)));
                            }
                        }
                        cursor2.close();
                    }
                }
                cursor.close();
            }
        }
    }
}
