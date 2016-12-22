package com.naruto.b_pocketnewlol.me;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naruto.b_pocketnewlol.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * 看这里,很强势!
 * Created by DgPeng on 16/12/21.
 */

public class MeLiveAdapter extends RecyclerView.Adapter<MeLiveAdapter.LiveViewHolder> {
    private MeLiveBean bean;
   // private List<MeLiveBean.DataBean.ItemsBean> list;
    private Context context;
    private MeLiveClick meLiveClick;
    private  MeLIveDetailsAdapter meLIveDetailsAdapter;
    private List<MeLiveBean.DataBean.ItemsBean> list;


    public MeLiveAdapter() {
        super();
        list = new ArrayList<>();
    }
    public void Clear(){
        list.clear();
    }

    public void setMeLiveClick(MeLiveClick meLiveClick) {
        this.meLiveClick = meLiveClick;
    }

    public MeLiveAdapter(Context context) {
        this.context = context;
    }

    public void setBean(MeLiveBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    //    public void setData(List<MeLiveBean.DataBean.TypeBean> data) {
//        this.data = data;
//        notifyDataSetChanged();
//    }
//
//    public void setList(List<MeLiveBean.DataBean.ItemsBean> list) {
//        this.list = list;
//        notifyDataSetChanged();
//    }

    @Override
    public LiveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_live_me, parent, false);
        LiveViewHolder liveViewHolder = new LiveViewHolder(view);
        return liveViewHolder;
    }

    @Override
    public void onBindViewHolder(final LiveViewHolder holder, final int position) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);

        list = bean.getData().get(position).getItems();

        holder.typeCnameTv.setText(bean.getData().get(position).getType().getCname());
        Log.d("qqq", bean.getData().get(position).getType().getCname());
        Glide.with(context).load(bean.getData().get(position).getType().getIcon()).into(holder.iconIv);
        meLIveDetailsAdapter = new MeLIveDetailsAdapter(context);
        meLIveDetailsAdapter.setData(list);
        holder.liveRv.setAdapter(meLIveDetailsAdapter);
        holder.liveRv.setLayoutManager(gridLayoutManager);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                meLiveClick.onClick(pos);


            }
        });

    }

    @Override
    public int getItemCount() {
        return bean.getData().size();
    }

    class LiveViewHolder extends RecyclerView.ViewHolder {
        private TextView typeCnameTv;
        private ImageView iconIv;
        private RecyclerView liveRv;
        public LiveViewHolder(View itemView) {
            super(itemView);
            typeCnameTv = (TextView) itemView.findViewById(R.id.item_live_me_type_cname);
            iconIv = (ImageView) itemView.findViewById(R.id.item_live_me_icon);
            liveRv = (RecyclerView) itemView.findViewById(R.id.rv_item_live);

        }
    }
}
