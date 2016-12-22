package com.naruto.b_pocketnewlol.me;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naruto.b_pocketnewlol.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 看这里,很强势!
 * Created by DgPeng on 16/12/22.
 */

public class MeLoLAdapter extends RecyclerView.Adapter<MeLoLAdapter.AllViewHolder> {

    private List<MeLoLBean.DataBean.ItemsBean>data;
    private Context context;

    public MeLoLAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    // 清除
    public void Clear(){
        data.clear();

    }

    public void setData(List<MeLoLBean.DataBean.ItemsBean> data) {
        //this.data = data;
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public AllViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_all_live_me,parent,false);
        AllViewHolder allViewHolder = new AllViewHolder(view);
        return allViewHolder;
    }

    @Override
    public void onBindViewHolder(AllViewHolder holder, int position) {
        holder.nameTv.setText(data.get(position).getName());
        Log.d("MeLoLAdapter", data.get(position).getName());
        holder.nickNameTv.setText(data.get(position).getUserinfo().getNickName());
        holder.personTv.setText(data.get(position).getPerson_num());
        Glide.with(context).load(data.get(position).getPictures().getImg()).into(holder.showImg);

    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    class AllViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTv,nickNameTv,personTv;
        private ImageView showImg;
        public AllViewHolder(View itemView) {
            super(itemView);
            nameTv = (TextView) itemView.findViewById(R.id.item_all_name);
            nickNameTv = (TextView) itemView.findViewById(R.id.item_all_nickName);
            showImg = (ImageView) itemView.findViewById(R.id.item_all_img);
            personTv = (TextView) itemView.findViewById(R.id.item_live_all_person_num);
        }
    }
}
