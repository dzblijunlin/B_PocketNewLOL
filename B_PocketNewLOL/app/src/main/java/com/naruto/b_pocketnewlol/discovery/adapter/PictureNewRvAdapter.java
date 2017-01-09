package com.naruto.b_pocketnewlol.discovery.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.discovery.bean.PictureNewBean;

import java.util.List;

/**
 * Created by 大嘴宝 on 16/12/29.
 */

public class PictureNewRvAdapter extends RecyclerView.Adapter<PictureNewRvAdapter.MyPictureNewViewHolder> {
    private List<PictureNewBean.WallpapersBean> data;
    private Context context;

    public PictureNewRvAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<PictureNewBean.WallpapersBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public MyPictureNewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_picture_new, parent, false);
        MyPictureNewViewHolder holder = new MyPictureNewViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyPictureNewViewHolder holder, int position) {

        Glide.with(context).load(data.get(position).getThumbUrl()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return data != null && data.size() > 0 ? data.size() : 0;
    }

    public void addMore(List<PictureNewBean.WallpapersBean> datas){
        data.addAll(datas);
        notifyDataSetChanged();

    }
    class MyPictureNewViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;

        public MyPictureNewViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_picture_new);
        }
    }
}
