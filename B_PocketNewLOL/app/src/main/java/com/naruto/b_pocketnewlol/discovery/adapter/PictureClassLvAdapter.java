package com.naruto.b_pocketnewlol.discovery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.discovery.bean.PictureClassBean;

import java.util.List;

/**
 * Created by 大嘴宝 on 17/1/4.
 */

public class PictureClassLvAdapter extends BaseAdapter {

    private List<PictureClassBean.CategoriesBean> data;
    private Context context;

    public PictureClassLvAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<PictureClassBean.CategoriesBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null && data.size() > 0 ? data.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data != null ? data.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyClassViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_picture_class,parent,false);
            holder = new MyClassViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (MyClassViewHolder) convertView.getTag();
        }
        Glide.with(context).load(data.get(position).getThumbUrl()).into(holder.iv);
        holder.tv.setText(data.get(position).getName());



        return convertView;
    }
    class MyClassViewHolder {
        private ImageView iv;
        private TextView tv;
        public MyClassViewHolder(View view) {
            iv = (ImageView) view.findViewById(R.id.iv_picture_class);
            tv = (TextView) view.findViewById(R.id.tv_picture_class);
        }
    }
}
