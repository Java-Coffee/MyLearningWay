package com.example.mybaseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by DHW on 2016/8/3.
 */
/**
 * ViewHolder优化BaseAdater思路
 * 创建Bean对象，用于封装数据
 * 在构造方法中初始化用于映射的数据List
 * 创建ViewHolder类，创建布局映射关系
 * 判断convertView,为空则创建，并设置tag,否则通过tag来取出来给ViewHolder
 * 给ViewHolder中的控件设置数据
 */
public class MyAdapter extends BaseAdapter {

    private List<ItemBean> mList;
    private LayoutInflater mInflater;
    private Context context;

    public MyAdapter(Context context, List<ItemBean> List) {
        mList = List;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //逗比式********************************************************没有缓存机制//
/*        View myview = mInflater.inflate(R.layout.item,null);
        ImageView imageView = (ImageView) myview.findViewById(R.id.image);
        TextView textViewtitle = (TextView) myview.findViewById(R.id.tv_title);
        TextView textViewcontent = (TextView) myview.findViewById(R.id.tv_content);
        imageView.setImageResource(mList.get(i).ItemImageID);
        textViewtitle.setText(mList.get(i).ItemTitle);
        textViewcontent.setText(mList.get(i).ItemContent);
        return myview;*/

        //普通式*********************************************************利用View缓存//
/*        if (view == null) {
            view = mInflater.inflate(R.layout.item, null);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        TextView textViewtitle = (TextView) view.findViewById(R.id.tv_title);
        TextView textViewcontent = (TextView) view.findViewById(R.id.tv_content);
        imageView.setImageResource(mList.get(i).ItemImageID);
        textViewtitle.setText(mList.get(i).ItemTitle);
        textViewcontent.setText(mList.get(i).ItemContent);
        return view;*/

        //文艺式*************************************************ViewHolder保存控件对象//
        ViewHolder viewHolder;
        if(view == null){
            viewHolder = new ViewHolder();
            view = mInflater.inflate(R.layout.item, null);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.image);
            viewHolder.title = (TextView) view.findViewById(R.id.tv_title);
            viewHolder.content = (TextView) view.findViewById(R.id.tv_content);
            view.setTag(viewHolder);   //将查找到的控件id保存在viewHolder中，避免多次findViewById寻找控件
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(R.mipmap.ic_launcher);
        //new ImageLoader().showImageByThread(viewHolder.imageView,mList.get(i).ItemImageID);

        String url = mList.get(i).ItemImageID;
        viewHolder.imageView.setTag(url);
        //使用Thread加载网络图片
        //new ImageLoader().showImageByThread(viewHolder.imageView,url);
        //使用异步加载网络图片
        new ImageLoader().showImageByAsyncTask(viewHolder.imageView,url);
        viewHolder.title.setText(mList.get(i).ItemTitle);
        viewHolder.content.setText(mList.get(i).ItemContent);
        return view;
    }
    class ViewHolder{
        private ImageView imageView;
        private TextView title;
        private TextView content;
    }
}
