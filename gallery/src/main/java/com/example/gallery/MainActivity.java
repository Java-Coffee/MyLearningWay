package com.example.gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, ViewSwitcher.ViewFactory, SeekBar.OnSeekBarChangeListener {
    private int[] items = {R.drawable.item1, R.drawable.item2, R.drawable.item3, R.drawable.item4, R.drawable.item5, R.drawable.item6, R.drawable.item7, R.drawable.item8, R.drawable.item9, R.drawable.item10, R.drawable.item11, R.drawable.item12};
    private Gallery gallery;
    private ImageSwitcher imageSwitcher;
    private SeekBar seekBar;
    private TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery = (Gallery) findViewById(R.id.gallery);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageswitch);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        tv1 = (TextView) findViewById(R.id.tx1);
        tv2 = (TextView) findViewById(R.id.tx2);
        ImageAdapter adapter = new ImageAdapter(items, this);
        gallery.setAdapter(adapter);
        gallery.setOnItemSelectedListener(this);
        seekBar.setOnSeekBarChangeListener(this);
        imageSwitcher.setFactory(this);
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //image.setBackgroundResource(res[i%res.length]);
        imageSwitcher.setBackgroundResource(items[i % items.length]);
        Toast.makeText(this, " " + i, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public View makeView() {
        ImageView image = new ImageView(this);
        image.setScaleType(ImageView.ScaleType.CENTER);
        return image;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        tv1.setText("正在拖动");
        tv2.setText("当前数值"+i);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        tv1.setText("开始拖动");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        tv1.setText("停止拖动");
    }
}
