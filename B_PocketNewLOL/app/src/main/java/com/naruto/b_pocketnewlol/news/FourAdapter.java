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

public class FourAdapter extends RecyclerView.Adapter<FourAdapter.FoursViewHolder>{

    private List<FourBean.MsgBean.ResultBean> data;
    private Context context;

    public FourAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<FourBean.MsgBean.ResultBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public FoursViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_four_item,parent,false);
        FoursViewHolder holder = new FoursViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(FoursViewHolder holder, int position) {
        Glide.with(context).load(data.get(position).getAppthumb()).into(holder.img);
        holder.tvTitle.setText(data.get(position).getTitle());
        holder.tvTime.setText(data.get(position).getTime());
        holder.tvAuthor.setText(data.get(position).getAuthor());
        holder.tvPubdate.setText(data.get(position).getPubdate());
    }

    @Override
    public int getItemCount() {
        return data != null && data.size() > 0 ? data.size() : 0;
    }

    class FoursViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tvTitle;
        private TextView tvTime;
        private TextView tvAuthor;
        private TextView tvPubdate;
        public FoursViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.four_img);
            tvTitle = (TextView) itemView.findViewById(R.id.four_title);
            tvTime = (TextView) itemView.findViewById(R.id.four_time);
            tvAuthor = (TextView) itemView.findViewById(R.id.four_author);
            tvPubdate = (TextView) itemView.findViewById(R.id.four_pubdate);
        }
    }
}
