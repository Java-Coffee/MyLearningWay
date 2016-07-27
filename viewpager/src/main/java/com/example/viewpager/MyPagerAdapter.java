package com.example.viewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by DHW on 2016/7/27.
 */
public class MyPagerAdapter extends PagerAdapter {

    private List<View>viewList;
    private List<String>taplist;
    public MyPagerAdapter(List<View> viewList, List<String> taplist){
        this.viewList = viewList;
        this.taplist = taplist;
    }

    @Override
    //返回当前页卡的数量
    public int getCount() {
        return viewList.size();
    }

    @Override
    //判断view是否来自于对象
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    //实例化一个页卡
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    //销毁一个页卡
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }

    @Override
    //获取当前tap标签
    public CharSequence getPageTitle(int position) {
        return taplist.get(position);
    }
}
