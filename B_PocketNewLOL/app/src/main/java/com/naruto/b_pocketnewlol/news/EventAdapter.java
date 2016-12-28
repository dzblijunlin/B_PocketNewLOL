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
 * Created by kevin on 16/12/23.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventsViewHolder>{

    private List<EventBean.ListBean> data;
    private Context context;

    public EventAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    public void setData(List<EventBean.ListBean> data) {
//        this.data = data;
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public EventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_event,parent,false);
        EventsViewHolder holder = new EventsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(EventsViewHolder holder, int position) {
        Glide.with(context).load(data.get(position).getImage_url_big()).into(holder.img);
        holder.tvTitle.setText(data.get(position).getTitle());
        holder.tvSum.setText(data.get(position).getSummary());
        holder.tvDate.setText(data.get(position).getPublication_date());
    }

    @Override
    public int getItemCount() {
        return data != null && data.size() > 0 ? data.size() : 0;
    }

    class EventsViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tvTitle,tvSum,tvDate;
        public EventsViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.item_event_img);
            tvTitle = (TextView) itemView.findViewById(R.id.item_event_tv_title);
            tvSum = (TextView) itemView.findViewById(R.id.item_event_tv_summary);
            tvDate = (TextView) itemView.findViewById(R.id.item_event_tv_date);
        }
    }
}
