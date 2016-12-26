package com.naruto.b_pocketnewlol.discovery.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.discovery.bean.TeamNumPhotoBean;

import java.util.List;

/**
 * Created by 大嘴宝 on 16/12/24.
 */

public class TeamPhotoAdapter extends RecyclerView.Adapter<TeamPhotoAdapter.MyTeamPhotoViewHolder> {

    private List<TeamNumPhotoBean.MembersBean> data;
    private Context context;

    public TeamPhotoAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<TeamNumPhotoBean.MembersBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public MyTeamPhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_team_num_photo, parent, false);
        MyTeamPhotoViewHolder holder = new MyTeamPhotoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyTeamPhotoViewHolder holder, int position) {
        Glide.with(context).load(data.get(position).getIconUrl()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return data != null && data.size() > 0 ? data.size() : 0;
    }

    class MyTeamPhotoViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;

        public MyTeamPhotoViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.team_num_photo_iv);
        }
    }
}
