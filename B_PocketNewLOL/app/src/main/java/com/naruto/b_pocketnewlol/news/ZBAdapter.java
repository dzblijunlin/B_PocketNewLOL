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

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

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

public class ZBAdapter extends RecyclerView.Adapter<ZBAdapter.ZViewHolder>{

    private List<ZBBean.MsgBean> data;
    private Context context;

    public void setData(List<ZBBean.MsgBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public ZBAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ZViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_zhu_bo_item,parent,false);
        ZViewHolder holder = new ZViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ZViewHolder holder, int position) {
        holder.tv.setText(data.get(position).getSName());
        Glide.with(context).load(data.get(position).getSIMG()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data != null && data.size() > 0 ? data.size() : 0;
    }

    class ZViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tv;
        public ZViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.xz_img);
            tv = (TextView) itemView.findViewById(R.id.xz_tv);
        }
    }
}
