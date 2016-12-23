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

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder>{

    private List<GameBean.MsgBean.ResultBean> data;
    private Context context;

    public GameAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    public void setData(List<GameBean.MsgBean.ResultBean> data) {
//        this.data = data;
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void Clean(){
        data.clear();
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_game,parent,false);
        GameViewHolder holder = new GameViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(GameViewHolder holder, int position) {
        Glide.with(context).load(data.get(position).getAppthumb()).into(holder.img);
        holder.tvTitle.setText(data.get(position).getTitle());
        holder.tvAuthor.setText(data.get(position).getAuthor());
        holder.tvPlay.setText(data.get(position).getPlay());
    }

    @Override
    public int getItemCount() {
        return data != null && data.size() > 0 ? data.size() : 0;
    }

    class GameViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tvTitle;
        private TextView tvAuthor;
        private TextView tvPlay;
        public GameViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.game_img);
            tvTitle = (TextView) itemView.findViewById(R.id.game_title);
            tvAuthor = (TextView) itemView.findViewById(R.id.game_author);
            tvPlay = (TextView) itemView.findViewById(R.id.game_play);
        }
    }
}
