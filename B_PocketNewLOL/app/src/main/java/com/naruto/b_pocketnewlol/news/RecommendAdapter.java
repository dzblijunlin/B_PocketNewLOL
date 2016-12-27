package com.naruto.b_pocketnewlol.news;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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
    private List<TwoBean.MsgBean.ResultBean> data2;
    private List<ThreeBean> data3;
    private List<FourBean.MsgBean.ResultBean> data4;

    private Context context;

    public RecommendAdapter(Context context) {
        this.context = context;
    }

    public void setData1(List<OneBean.MsgBean.HotRecWpvlistBean> data1) {
        this.data1 = data1;
        notifyDataSetChanged();
    }

    public void setData2(List<TwoBean.MsgBean.ResultBean> data2) {
        this.data2 = data2;
        notifyDataSetChanged();
    }

    public void setData4(List<FourBean.MsgBean.ResultBean> data4) {
        this.data4 = data4;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return 1;//1
        }else if (position == 1){
            return 2;//2
        }else if (position == 2){
            return 1;//3
        }else{
            return 4;//4
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
                View view2 = LayoutInflater.from(context).inflate(R.layout.item_two,parent,false);
                holder = new TwoViewHolder(view2);
                break;
            case REMENYINGXIONG:
                View view3 = LayoutInflater.from(context).inflate(R.layout.item_one,parent,false);
                holder = new OneViewHolder(view3);
                break;
            case QUANBUSHIPIN:
                View view4 = LayoutInflater.from(context).inflate(R.layout.item_four,parent,false);
                holder = new FourViewHolder(view4);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type){
            case REMEN:

                OneViewHolder oneViewHolder = (OneViewHolder) holder;
                OneAdapter adapter = new OneAdapter(context);
                adapter.setData(data1);
                oneViewHolder.rv.setAdapter(adapter);
                oneViewHolder.rv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                break;
            case REMENSAISHI:

                TwoViewHolder twoViewHolder = (TwoViewHolder) holder;
                TwoAdapter adapter2 = new TwoAdapter(context);
                adapter2.setData(data2);
                twoViewHolder.rv2.setAdapter(adapter2);
                twoViewHolder.rv2.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                break;
            case REMENYINGXIONG:
                OneViewHolder oneViewHolder3 = (OneViewHolder) holder;
                OneAdapter adapter3 = new OneAdapter(context);
                adapter3.setData(data1);
                oneViewHolder3.rv.setAdapter(adapter3);
                oneViewHolder3.rv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                break;
            case QUANBUSHIPIN:
                FourViewHolder fourViewHolder = (FourViewHolder) holder;
                FourAdapter adapter4 = new FourAdapter(context);
                adapter4.setData(data4);
                fourViewHolder.rv4.setAdapter(adapter4);
                fourViewHolder.rv4.setLayoutManager(new StaggeredGridLayoutManager(2,1));
//                FourViewHolder holder1 = (FourViewHolder) holder;
//                Glide.with(context).load(data4.get(position).getAppthumb()).into(holder1.img);
//                holder1.tvTitle.setText(data4.get(position).getTitle());
//                holder1.tvTime.setText(data4.get(position).getTime());
//                holder1.tvAuthor.setText(data4.get(position).getAuthor());
//                holder1.tvPubdate.setText(data4.get(position).getPubdate());
                break;
        }
    }

    @Override
    public int getItemCount() {
//        return data4 != null && data4.size() > 0 ? data4.size() + 3 : 0;
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
        private RecyclerView rv2;
        public TwoViewHolder(View itemView) {
            super(itemView);
            rv2 = (RecyclerView) itemView.findViewById(R.id.rv_two);
        }
    }

    class ThreeViewHolder extends RecyclerView.ViewHolder{

        public ThreeViewHolder(View itemView) {
            super(itemView);
        }
    }

    class FourViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView rv4;
        public FourViewHolder(View itemView) {
            super(itemView);
            rv4 = (RecyclerView) itemView.findViewById(R.id.rv_four);
        }
    }

    ////////
//    class FourViewHolder extends RecyclerView.ViewHolder{
//        private ImageView img;
//        private TextView tvTitle;
//        private TextView tvTime;
//        private TextView tvAuthor;
//        private TextView tvPubdate;
//        public FourViewHolder(View itemView) {
//            super(itemView);
//            img = (ImageView) itemView.findViewById(R.id.four_img);
//            tvTitle = (TextView) itemView.findViewById(R.id.four_title);
//            tvTime = (TextView) itemView.findViewById(R.id.four_time);
//            tvAuthor = (TextView) itemView.findViewById(R.id.four_author);
//            tvPubdate = (TextView) itemView.findViewById(R.id.four_pubdate);
//        }
//    }

}
