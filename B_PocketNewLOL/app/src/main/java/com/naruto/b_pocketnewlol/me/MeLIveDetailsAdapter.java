package com.naruto.b_pocketnewlol.me;

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
 * 看这里,很强势!
 * Created by DgPeng on 16/12/21.
 */

public class MeLIveDetailsAdapter extends RecyclerView.Adapter<MeLIveDetailsAdapter.DetailsViewHolder> {

    private List<MeLiveBean.DataBean.ItemsBean> data;
//    private MeLiveBean data;
    private Context context;
    //private int pos;

    public void setData(List<MeLiveBean.DataBean.ItemsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }


//    public MeLIveDetailsAdapter(Context context, int pos) {
//        this.context = context;
//        this.pos = pos;
//    }


    public MeLIveDetailsAdapter(Context context) {
        this.context = context;
    }

//    public void setData(MeLiveBean data) {
//        this.data = data;
//        notifyDataSetChanged();
//    }

    @Override
    public DetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_live_details, parent, false);
        DetailsViewHolder detailsViewHolder = new DetailsViewHolder(view);
        return detailsViewHolder;
    }

    @Override
    public void onBindViewHolder(DetailsViewHolder holder, int position) {

        holder.nameTv.setText(data.get(position).getName());
        holder.nickNameTv.setText(data.get(position).getUserinfo().getNickName());
        holder.personTv.setText(data.get(position).getPerson_num());
        Glide.with(context).load(data.get(position).getPictures().getImg()).into(holder.imgIv);
//        holder.nameTv.setText(data.getData().get(position).getItems().get(position).getName());
//        holder.nickNameTv.setText(data.getData().get(position).getItems().get(position).getUserinfo().getNickName());
//        Glide.with(context).load(data.getData().get(position).getItems().get(position).getPictures().getImg()).into(holder.imgIv);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class DetailsViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTv, nickNameTv,personTv;
        private ImageView imgIv;

        public DetailsViewHolder(View itemView) {
            super(itemView);
            nameTv = (TextView) itemView.findViewById(R.id.item_details_name);
            nickNameTv = (TextView) itemView.findViewById(R.id.item_details_nickName);
            imgIv = (ImageView) itemView.findViewById(R.id.item_details_img);
            personTv = (TextView) itemView.findViewById(R.id.item_live_details_person_num);
        }
    }

}
