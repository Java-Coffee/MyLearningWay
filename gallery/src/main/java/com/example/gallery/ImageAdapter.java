package com.example.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by DHW on 2016/8/2.
 */
public class ImageAdapter extends BaseAdapter{
    private int res[];
    private Context context;
    public ImageAdapter(int []res, Context context){
        this.res = res;
        this.context = context;
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int i) {
        return res[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView image = new ImageView(context);
        image.setBackgroundResource(res[i%res.length]);
        image.setLayoutParams(new Gallery.LayoutParams(200,150));
        image.setScaleType(ImageView.ScaleType.FIT_XY);
        return image;
    }
}
