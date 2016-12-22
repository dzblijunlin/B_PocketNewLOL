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

public class ZdAdapter extends RecyclerView.Adapter<ZdAdapter.ZDViewHolder>{

    private List<ZDBean.MsgBean.ResultBean> data;
    private Context context;

    public ZdAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ZDBean.MsgBean.ResultBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public ZDViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_zd_item,parent,false);
        ZDViewHolder holder = new ZDViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ZDViewHolder holder, int position) {
        Glide.with(context).load(data.get(position).getAppthumb()).into(holder.img);
        holder.tvTitle.setText(data.get(position).getTitle());
        holder.tvAuthor.setText(data.get(position).getAuthor());
        holder.tvTime.setText(data.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return data != null && data.size() > 0 ? data.size() : 0;
    }

    class ZDViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tvTitle;
        private TextView tvAuthor;
        private TextView tvTime;
        public ZDViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.zd_img);
            tvTitle = (TextView) itemView.findViewById(R.id.zd_title);
            tvAuthor = (TextView) itemView.findViewById(R.id.zd_author);
            tvTime = (TextView) itemView.findViewById(R.id.zd_pubdate);
        }
    }
}
