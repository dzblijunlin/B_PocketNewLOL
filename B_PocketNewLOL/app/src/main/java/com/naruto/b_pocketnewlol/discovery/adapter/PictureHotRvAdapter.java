package com.naruto.b_pocketnewlol.discovery.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.discovery.bean.PictureHotBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 大嘴宝 on 17/1/3.
 */

public class PictureHotRvAdapter extends RecyclerView.Adapter<PictureHotRvAdapter.MyHotViewHolder> {
    private List<PictureHotBean.WallpapersBean> data;
    private Context context;
    private ArrayList<Integer> heights;

    public PictureHotRvAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<PictureHotBean.WallpapersBean> data) {
        this.data = data;
        notifyDataSetChanged();
        heights = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            Random random = new Random();
            int height = random.nextInt(900 - 200 + 1) + 200;
            heights.add(height);

        }
    }

    @Override
    public MyHotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_picture_hot, parent, false);
        MyHotViewHolder holder = new MyHotViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHotViewHolder holder, int position) {
        // 获取缓存类中的TextView的信息
        ViewGroup.LayoutParams params = holder.iv.getLayoutParams();
        // 将集合中的某一个数值赋值给了Params对象
        params.height = heights.get(position);
        // 最后把新的高度给缓存类中的TextView
        holder.iv.setLayoutParams(params);
        Glide.with(context).load(data.get(position).getThumbUrl()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return data != null && data.size() > 0 ? data.size() : 0;
    }

    public void addMore(List<PictureHotBean.WallpapersBean> datas){
        data.addAll(datas);
        notifyDataSetChanged();
    }
    class MyHotViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv;

        public MyHotViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_hot_picture);
        }
    }
}
