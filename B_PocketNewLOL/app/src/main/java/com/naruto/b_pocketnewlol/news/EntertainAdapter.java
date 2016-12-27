package com.naruto.b_pocketnewlol.news;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
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

public class EntertainAdapter extends RecyclerView.Adapter {

    private List<TopBean.MsgBean> dataTop;
    private List<FootBean.MsgBean.ResultBean> dataFoot;
    private Context context;
    public static final int A = 1;
    public static final int B = 2;

    public EntertainAdapter(Context context) {
        this.context = context;
    }

    public void setDataTop(List<TopBean.MsgBean> dataTop) {
        this.dataTop = dataTop;
        notifyDataSetChanged();
    }

    public void setDataFoot(List<FootBean.MsgBean.ResultBean> dataFoot) {
        this.dataFoot = dataFoot;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case A:
                View view = LayoutInflater.from(context).inflate(R.layout.item_enter_top, parent, false);
                holder = new TopViewHolder(view);
                break;
            case B:
                View view1 = LayoutInflater.from(context).inflate(R.layout.item_enter_foot, parent, false);
                holder = new FootViewHolder(view1);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type) {
            case A:
                TopViewHolder topViewHolder = (TopViewHolder) holder;
                TopAdapter topAdapter = new TopAdapter(context);
                topAdapter.setDaya(dataTop);
                topViewHolder.rv1.setAdapter(topAdapter);
                topViewHolder.rv1.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                break;
            case B:
                FootViewHolder footViewHolder = (FootViewHolder) holder;
                FootAdapter footAdapter = new FootAdapter(context);
                ///
                LRecyclerViewAdapter lRecyclerViewAdapter = new LRecyclerViewAdapter(footAdapter);
                footAdapter.setData(dataFoot);
                footViewHolder.rv2.setAdapter(lRecyclerViewAdapter);
                footViewHolder.rv2.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class TopViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView rv1;

        public TopViewHolder(View itemView) {
            super(itemView);
            rv1 = (RecyclerView) itemView.findViewById(R.id.rv_top);
        }
    }

    class FootViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView rv2;

        public FootViewHolder(View itemView) {
            super(itemView);
            rv2 = (RecyclerView) itemView.findViewById(R.id.rv_foot);
        }
    }
}
