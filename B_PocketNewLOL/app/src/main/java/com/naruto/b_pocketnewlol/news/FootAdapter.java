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

import java.util.ArrayList;
import java.util.List;

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
 * Created by kevin on 16/12/22.
 */

public class FootAdapter extends RecyclerView.Adapter<FootAdapter.FViewHolder>{

    private List<FootBean.MsgBean.ResultBean> data;
    private Context context;

    public FootAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    public void setData(List<FootBean.MsgBean.ResultBean> data) {
//        this.data = new ArrayList<>();
//        this.data = data;
//        for (int i = 0; i < data.size(); i++) {
//            this.data.add(data.get(i));
//        }
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public FViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_enter_foot_item,parent,false);
        FViewHolder holder = new FViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(FViewHolder holder, int position) {
        Glide.with(context).load(data.get(position).getAppthumb()).into(holder.img);
        holder.tvTitle.setText(data.get(position).getTitle());
        holder.tvAuthor.setText(data.get(position).getAuthor());
        holder.tvTime.setText(data.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return data != null && data.size() > 0 ? data.size() : 0;
    }

    class FViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tvTitle,tvAuthor,tvTime;
        public FViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.foot_img);
            tvTitle = (TextView) itemView.findViewById(R.id.foot_title);
            tvAuthor = (TextView) itemView.findViewById(R.id.foot_author);
            tvTime = (TextView) itemView.findViewById(R.id.foot_time);
        }
    }
}
