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

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroViewHolder>{

    private List<HeroBean.MsgBean.ResultBean> data;
    private Context context;

    public HeroAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    public void setData(List<HeroBean.MsgBean.ResultBean> data) {
//        this.data = data;
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hero,parent,false);
        HeroViewHolder holder = new HeroViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HeroViewHolder holder, int position) {
        holder.tvTitle.setText(data.get(position).getTitle());
        holder.tvAuthor.setText(data.get(position).getAuthor());
        holder.tvPlay.setText(data.get(position).getPlay());
        Glide.with(context).load(data.get(position).getAppthumb()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data != null && data.size() > 0 ? data.size() : 0;
    }

    class HeroViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tvTitle,tvAuthor,tvPlay;
        public HeroViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.hero_img);
            tvTitle = (TextView) itemView.findViewById(R.id.hero_title);
            tvAuthor = (TextView) itemView.findViewById(R.id.hero_author);
            tvPlay = (TextView) itemView.findViewById(R.id.hero_play);
        }
    }
}
