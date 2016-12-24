package com.naruto.b_pocketnewlol.discovery.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.discovery.MyClickListener;
import com.naruto.b_pocketnewlol.discovery.bean.TeamBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 大嘴宝 on 16/12/20.
 */

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.MyTeamViewHolder>{
    private List<TeamBean.ClubsBean> data;
    private Context context;
    private MyClickListener myClickListener;

    public void setMyClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public TeamAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<TeamBean.ClubsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public MyTeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_discovery_title_rv,parent,false);
        MyTeamViewHolder holder = new MyTeamViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyTeamViewHolder holder, int position) {
        Glide.with(context).load(data.get(position).getIconUrl()).into(holder.iv);
        holder.tv.setText(data.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClickListener.MyListener(holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return data!=null&&data.size()>0?data.size():0;
    }

    class MyTeamViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv;
        private TextView tv;
        public MyTeamViewHolder(View itemView) {
            super(itemView);
            iv = (CircleImageView) itemView.findViewById(R.id.discovery_team_iv);
            tv = (TextView) itemView.findViewById(R.id.discovery_team_tv);
        }
    }
}
