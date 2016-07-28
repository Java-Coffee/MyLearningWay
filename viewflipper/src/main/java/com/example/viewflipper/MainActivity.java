package com.example.viewflipper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    private int[] resId = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4};
    private float startX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFlipper = (ViewFlipper) findViewById(R.id.flipper);
        //动态添加的方式导入子view
        for (int i = 0; i < resId.length; i++) {
            viewFlipper.addView(getImageView(resId[i]));
        }
        //为flipper添加动画效果
//        viewFlipper.setInAnimation(this, R.anim.left_in);
//        viewFlipper.setOutAnimation(this, R.anim.left_out);
        //设置3秒间隔
 //       viewFlipper.setFlipInterval(3000);
        //启动flipper
 //       viewFlipper.startFlipping();


    }

    //将图片动态添加到ImageView
    private ImageView getImageView(int resId) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(resId);
        return imageView;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                startX = event.getX();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                //右滑，显示前一页
                if (event.getX() - startX > 100) {
                    viewFlipper.setInAnimation(this, R.anim.left_in);
                    viewFlipper.setOutAnimation(this, R.anim.left_out);
                    viewFlipper.showPrevious();
                }
                //左滑，显示后一页
                if (startX - event.getX() > 100) {
                    viewFlipper.setInAnimation(this, R.anim.right_in);
                    viewFlipper.setOutAnimation(this, R.anim.right_out);
                    viewFlipper.showNext();
                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
        }
        return super.onTouchEvent(event);
    }
}
