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

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.TViewHolder>{

    private List<TopBean.MsgBean> daya;
    private Context context;

    public TopAdapter(Context context) {
        this.context = context;
    }

    public void setDaya(List<TopBean.MsgBean> daya) {
        this.daya = daya;
        notifyDataSetChanged();
    }

    @Override
    public TViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_enter_top_item,parent,false);
        TViewHolder holder = new TViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TViewHolder holder, int position) {
        Glide.with(context).load(daya.get(position).getSIMG()).into(holder.img);
        holder.tvSname.setText(daya.get(position).getSName());
        holder.tvVideo.setText(daya.get(position).getIVideo());
        holder.tvTime.setText(daya.get(position).getPubdate());
    }

    @Override
    public int getItemCount() {
        return daya != null && daya.size() > 0 ? daya.size() : 0;
    }

    class TViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tvSname;
        private TextView tvVideo;
        private TextView tvTime;
        public TViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.top_img);
            tvSname = (TextView) itemView.findViewById(R.id.top_sName);
            tvVideo = (TextView) itemView.findViewById(R.id.top_iVideo);
            tvTime = (TextView) itemView.findViewById(R.id.top_time);
        }
    }
}
