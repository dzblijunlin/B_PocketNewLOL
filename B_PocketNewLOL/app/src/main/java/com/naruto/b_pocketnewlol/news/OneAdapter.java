package com.naruto.b_pocketnewlol.news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naruto.b_pocketnewlol.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　　　┃　　　┃    神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * <p>
 * ━━━━━━感觉萌萌哒━━━━━━
 * <p>
 * Created by kevin on 16/12/21.
 */

public class OneAdapter extends RecyclerView.Adapter<OneAdapter.MyViewHolder>{

    private List<OneBean.MsgBean.HotRecWpvlistBean> data;
    private Context context;

    public OneAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<OneBean.MsgBean.HotRecWpvlistBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_one_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(context).load(data.get(position).getAppthumb()).into(holder.imgBack);
        Glide.with(context).load(data.get(position).getAuthorImg()).into(holder.imgA);
        holder.tvTime.setText(data.get(position).getTime());
        holder.tv_title_one.setText(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return data != null && data.size() > 0 ? data.size() : 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgBack;
        private TextView tvTime;
        private ImageView imgA;
        private TextView tv_title_one;
        public MyViewHolder(View itemView) {
            super(itemView);
            imgBack = (ImageView) itemView.findViewById(R.id.img_one);
            tvTime = (TextView) itemView.findViewById(R.id.tv_one);
            imgA = (CircleImageView) itemView.findViewById(R.id.img_tou_one);
            tv_title_one = (TextView) itemView.findViewById(R.id.tv_title_one);
        }
    }
}
