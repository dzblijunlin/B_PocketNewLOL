package com.naruto.b_pocketnewlol.news;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class ExplainAdapter extends RecyclerView.Adapter{

    private List<ZBBean.MsgBean> data;
    private List<ZDBean.MsgBean.ResultBean> dataMore;
    private Context context;

    public static final int AA = 1;
    public static final int BB = 2;

    public ExplainAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ZBBean.MsgBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setDataMore(List<ZDBean.MsgBean.ResultBean> dataMore) {
        this.dataMore = dataMore;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return 1;
        }else {
            return 2;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType){
            case AA:
                View view = LayoutInflater.from(context).inflate(R.layout.item_zhu_bo,parent,false);
                holder = new EAViewHolder(view);
                break;
            case BB:
                View view1 = LayoutInflater.from(context).inflate(R.layout.item_zd,parent,false);
                holder = new EBViewHolder(view1);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type){
            case AA:
                EAViewHolder holder1 = (EAViewHolder) holder;
                ZBAdapter adapter = new ZBAdapter(context);
                adapter.setData(data);
                holder1.rl.setAdapter(adapter);
                holder1.rl.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                break;
            case BB:
                EBViewHolder holder2 = (EBViewHolder) holder;
                ZdAdapter zdAdapter = new ZdAdapter(context);
                zdAdapter.setData(dataMore);
                holder2.rll.setAdapter(zdAdapter);
                holder2.rll.setLayoutManager(new GridLayoutManager(context,2));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class EAViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView rl;
        public EAViewHolder(View itemView) {
            super(itemView);
            rl = (RecyclerView) itemView.findViewById(R.id.zhu_bo_rv);
        }
    }

    class EBViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView rll;
        public EBViewHolder(View itemView) {
            super(itemView);
            rll = (RecyclerView) itemView.findViewById(R.id.zd_rv);
        }
    }

}
