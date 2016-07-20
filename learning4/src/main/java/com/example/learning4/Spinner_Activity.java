package com.example.learning4;

/**
 * Created by DHW on 2016/7/19.
 */

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Spinner_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener{
    private Spinner spinner;
    private TextView textView;
    private List<String> list;
    private ArrayAdapter<String> adapter;
    private ProgressDialog progressDialog;
private ProgressBar progressBar;
    private Button add;
    private Button reduce;
    private Button reset;
    private TextView text;
    private Button show;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.spinner);
        setProgressBarVisibility(true);
        setProgressBarIndeterminateVisibility(false);
        setProgress(9999);
        progressBarInit();
        spinner = (Spinner) findViewById(R.id.spinner);
        textView = (TextView) findViewById(R.id.textview);
        list = new ArrayList<String>();
        list.add("北京");
        list.add("上海");
        list.add("广州");
        list.add("深圳");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        //给数组适配器设置加载样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        textView.setText("你的选择是北京");
        spinner.setOnItemSelectedListener(this);

    }

    private void progressBarInit() {
        progressBar = (ProgressBar) findViewById(R.id.horizbar);
        add = (Button) findViewById(R.id.add);
        reduce = (Button) findViewById(R.id.reduce);
        reset = (Button) findViewById(R.id.reset);
        text = (TextView) findViewById(R.id.text);
        show = (Button) findViewById(R.id.show);
        int first = progressBar.getProgress();
        int second = progressBar.getSecondaryProgress();
        int max = progressBar.getMax();
        text.setText("第一进度百分比："+ (int)(first/(float)max*100)+"% 第二进度百分比："+ (int)(second/(float)max*100) + "%");
        add.setOnClickListener(this);
        reduce.setOnClickListener(this);
        reset.setOnClickListener(this);
        show.setOnClickListener(this);
    }


    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String cityName = adapter.getItem(i);
        textView.setText("你的选择是" + cityName);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add:
                //progressBar.incrementProgressBy(10);    增加10个进度
                progressBar.setProgress(progressBar.getProgress() + 1);
                break;
            case R.id.reduce:
                //progressBar.incrementSecondaryProgressBy(10);   增加10个进度
                progressBar.setProgress(progressBar.getProgress() - 1);
                break;
            case R.id.reset:
                progressBar.setProgress(50);
                progressBar.setSecondaryProgress(80);
                break;
            case R.id.show:
                //初始化progressDialog界面
                progressDialog = new ProgressDialog(Spinner_Activity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("Github");
                progressDialog.setMessage("正在下载Github...");
                progressDialog.setIcon(R.drawable.ringtone);
                //设置progressBar的属性
                progressDialog.setMax(100);
                //设置初始化已经增长到的进度
                progressDialog.incrementProgressBy(50);
                //进度条明确显示进度
                progressDialog.setIndeterminate(false);
                //设置一个确定按钮
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Spinner_Activity.this,"欢迎使用Github",Toast.LENGTH_SHORT).show();
                    }
                });
                //是否可以通过返回按钮退出对话框
                progressDialog.setCancelable(true);
                //显示progressDialog
                progressDialog.show();
        }
        text.setText("第一进度百分比："+ (int)(progressBar.getProgress()/(float)progressBar.getMax()*100)+"% 第二进度百分比："+ (int)(progressBar.getSecondaryProgress()/(float)progressBar.getMax()*100) + "%");
    }
}