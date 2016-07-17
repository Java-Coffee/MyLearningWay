package com.example.learning4;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import java.util.Calendar;
import java.util.Date;

public class Date_Time_Activity extends AppCompatActivity {
    private DatePicker datePicker;
    private TimePicker timePicker;
    private Calendar calendar;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_time);
        //从系统获取时间信息
        calendar = Calendar.getInstance();
        //获取年月日时分秒信息
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
        setTitle(year + "-" + month + "-" + day + "  " + hour + ":" + minute);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        //datePicker初始化
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                setTitle(i + "-" + (i1+1) + "-" + i2 );
            }
        });
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                setTitle(i + ":" + i1);
            }
        });
        new DatePickerDialog(this, new OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                setTitle(i + "-" + i1 + "-" + i2);
            }
        },year,month,day).show();
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                setTitle(i + ":" + i1);
            }
        },hour,minute,true).show();
        }
    }

