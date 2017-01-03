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
 * Created by kevin on 16/12/20.
 */

public class CycleAdapter extends RecyclerView.Adapter<CycleAdapter.CycleViewHolder>{

    private List<CycleBean.ListBean> data;
    private Context context;
    private MyClick myClick;

    public void setMyClick(MyClick myClick) {
        this.myClick = myClick;
        notifyDataSetChanged();
    }

    public CycleAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
        notifyDataSetChanged();
    }

    public void setData(List<CycleBean.ListBean> data) {
//        this.data = data;
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void clean(){
        data.clear();
    }

    @Override
    public CycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news_cycle,parent,false);
        CycleViewHolder holder = new CycleViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CycleViewHolder holder, final int position) {
        Glide.with(context).load(data.get(position).getImage_url_small()).into(holder.img);
        holder.tvTitle.setText(data.get(position).getTitle());
        holder.tvS.setText(data.get(position).getSummary());
        holder.tvDate.setText(data.get(position).getPublication_date());
        holder.tvPv.setText(data.get(position).getPv());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClick.MyListener(data.get(position).getArticle_url());
            }
        });
    }

    @Override
    public int getItemCount() {
        return data != null && data.size() > 0 ? data.size() : 0;
    }

    class CycleViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tvTitle,tvS,tvDate,tvPv;
        public CycleViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_item_news_cycle);
            tvTitle = (TextView) itemView.findViewById(R.id.title_item_news_cycle);
            tvS = (TextView) itemView.findViewById(R.id.summary_item_news_cycle);
            tvDate = (TextView) itemView.findViewById(R.id.date_item_news_cycle);
            tvPv = (TextView) itemView.findViewById(R.id.pv_item_news_cycle);
        }
    }
}
