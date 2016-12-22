package com.naruto.b_pocketnewlol.news;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
 * Created by kevin on 16/12/21.
 */

public class RecommendAdapter extends RecyclerView.Adapter{

    public static final int REMEN = 1;
    public static final int REMENSAISHI = 2;
    public static final int REMENYINGXIONG = 3;
    public static final int QUANBUSHIPIN = 4;

   private List<OneBean.MsgBean.HotRecWpvlistBean> data1;
    private List<TwoBean> data2;
    private List<ThreeBean> data3;
    private List<FourBean> data4;

    private Context context;

    public RecommendAdapter(Context context) {
        this.context = context;
    }

    public void setData1(List<OneBean.MsgBean.HotRecWpvlistBean> data1) {
        this.data1 = data1;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return 1;//1
        }else if (position == 1){
            return 1;//2
        }else if (position == 2){
            return 1;//3
        }else{
            return 1;//4
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType){
            case REMEN:
                View view1 = LayoutInflater.from(context).inflate(R.layout.item_one,parent,false);
                holder = new OneViewHolder(view1);
                break;
            case REMENSAISHI:
                View view2 = LayoutInflater.from(context).inflate(R.layout.item_one,parent,false);
                holder = new OneViewHolder(view2);
                break;
            case REMENYINGXIONG:
                View view3 = LayoutInflater.from(context).inflate(R.layout.item_one,parent,false);
                holder = new OneViewHolder(view3);
                break;
            case QUANBUSHIPIN:
                View view4 = LayoutInflater.from(context).inflate(R.layout.item_one,parent,false);
                holder = new OneViewHolder(view4);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type){
            case REMEN:
                Toast.makeText(context, "ssss", Toast.LENGTH_SHORT).show();
                OneViewHolder oneViewHolder = (OneViewHolder) holder;
                OneAdapter adapter = new OneAdapter(context);
                adapter.setData(data1);
                oneViewHolder.rv.setAdapter(adapter);
                oneViewHolder.rv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                break;
            case REMENSAISHI:
                Toast.makeText(context, "ssss", Toast.LENGTH_SHORT).show();
                OneViewHolder oneViewHolder2 = (OneViewHolder) holder;
                OneAdapter adapter2 = new OneAdapter(context);
                oneViewHolder2.rv.setAdapter(adapter2);
                oneViewHolder2.rv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                break;
            case REMENYINGXIONG:
                Toast.makeText(context, "ssss", Toast.LENGTH_SHORT).show();
                OneViewHolder oneViewHolder3 = (OneViewHolder) holder;
                OneAdapter adapter3 = new OneAdapter(context);
                //adapter3.setData();
                oneViewHolder3.rv.setAdapter(adapter3);
                oneViewHolder3.rv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                break;
            case QUANBUSHIPIN:
                Toast.makeText(context, "ssss", Toast.LENGTH_SHORT).show();
                OneViewHolder oneViewHolder4 = (OneViewHolder) holder;
                OneAdapter adapter4 = new OneAdapter(context);
                oneViewHolder4.rv.setAdapter(adapter4);
                oneViewHolder4.rv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class OneViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView rv;
        public OneViewHolder(View itemView) {
            super(itemView);
            rv = (RecyclerView) itemView.findViewById(R.id.rv_one);
        }
    }

    class TwoViewHolder extends RecyclerView.ViewHolder{

        public TwoViewHolder(View itemView) {
            super(itemView);
        }
    }

    class ThreeViewHolder extends RecyclerView.ViewHolder{

        public ThreeViewHolder(View itemView) {
            super(itemView);
        }
    }

    class FourViewHolder extends RecyclerView.ViewHolder{

        public FourViewHolder(View itemView) {
            super(itemView);
        }
    }

}
