package com.naruto.b_pocketnewlol.discovery.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.discovery.bean.LogoBean;

import java.util.List;

/**
 * Created by 大嘴宝 on 16/12/22.
 */

public class GameAdapter extends BaseExpandableListAdapter {
    private List<LogoBean.ListBean> fatherData;
    private List<LogoBean.ListBean> sonData;
    private Context context;
    public static final int TYPE_ONE = 0;
    public static final int TYPE_TWO = 1;
    public static final int TYPE_COUNT = 2;


    public GameAdapter(Context context) {
        this.context = context;
    }

    public void setFatherData(List<LogoBean.ListBean> fatherData) {
        this.fatherData = fatherData;
        notifyDataSetChanged();
    }

    public void setSonData(List<List<LogoBean.ListBean>> sonData) {
        this.sonData = sonData.get(0);

        notifyDataSetChanged();
    }


    @Override
    public int getGroupType(int groupPosition) {
        if (groupPosition % 2 == 0) {
            return TYPE_ONE;
        } else {
            return TYPE_TWO;
        }

    }

    @Override
    public int getGroupTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getChildType(int groupPosition, int childPosition) {
        if (groupPosition % 2 == 0) {
            return TYPE_ONE;
        } else {
            return TYPE_TWO;
        }
    }

    @Override
    public int getChildTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getGroupCount() {
        return 2;
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return fatherData.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return sonData.get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        ViewHolderFather holderFather = null;
        ViewHolderBelowFather holderBelowFather = null;
        if (view == null) {
            switch (getGroupType(i)) {
                case TYPE_ONE:
                    view = LayoutInflater.from(context).inflate(R.layout.item_game_father, viewGroup, false);
                    holderFather = new ViewHolderFather(view);
                    view.setTag(holderFather);
                    break;
                case TYPE_TWO:
                    view = LayoutInflater.from(context).inflate(R.layout.item_community_father, viewGroup, false);
                    holderBelowFather = new ViewHolderBelowFather(view);
                    view.setTag(holderBelowFather);
                    break;
            }

        } else {
            switch (getGroupType(i)) {
                case TYPE_ONE:
                    holderFather = (ViewHolderFather) view.getTag();
                    break;
                case TYPE_TWO:
                    holderBelowFather = (ViewHolderBelowFather) view.getTag();
                    break;
            }

        }
        switch (getGroupType(i)) {
            case TYPE_ONE:
                Glide.with(context).load(fatherData.get(5).getImage_url_big()).into(holderFather.fatherIv);
                holderFather.fatherTv.setText(fatherData.get(5).getTitle());
                break;
            case TYPE_TWO:
                Glide.with(context).load(fatherData.get(4).getImage_url_big()).into(holderBelowFather.comFatherIv);
                holderBelowFather.comFatherTv.setText(fatherData.get(4).getTitle());
                break;
        }
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ViewHolderSon holderSon = null;
        ViewHolderSon1 holderSon1 = null;

        if (view == null) {
            switch (getChildType(i, i1)) {
                case TYPE_ONE:
                    view = LayoutInflater.from(context).inflate(R.layout.item_game_son, viewGroup, false);
                    holderSon = new ViewHolderSon(view);
                    view.setTag(holderSon);
                    break;
                case TYPE_TWO:
                    view = LayoutInflater.from(context).inflate(R.layout.item_game_son, viewGroup, false);
                    holderSon1 = new ViewHolderSon1(view);
                    view.setTag(holderSon1);
                    break;
            }


        } else {
            switch (getChildType(i, i1)) {
                case TYPE_ONE:
                    holderSon = (ViewHolderSon) view.getTag();
                    break;
                case TYPE_TWO:
                    holderSon1 = (ViewHolderSon1) view.getTag();
                    break;
            }
        }
        switch (getChildType(i, i1)) {
            case TYPE_ONE:
                Log.d("GameAdapter", "sonData.size():" + sonData.size());
                Glide.with(context).load(sonData.get(10).getImage_url_big()).into(holderSon.sonIv);
                Glide.with(context).load(sonData.get(7).getImage_url_big()).into(holderSon.talentIv);
                Glide.with(context).load(sonData.get(6).getImage_url_big()).into(holderSon.runeIv);
                holderSon.sonTv.setText(sonData.get(10).getTitle());
                holderSon.talentTv.setText(sonData.get(7).getTitle());
                holderSon.runeTv.setText(sonData.get(6).getTitle());
                break;
            case TYPE_TWO:
               // Log.d("GameAdapter", "sonData.size():" + sonData.get(0).size());
                Glide.with(context).load(sonData.get(16).getImage_url_big()).into(holderSon1.sonIv);
                Glide.with(context).load(sonData.get(14).getImage_url_big()).into(holderSon1.talentIv);
                Glide.with(context).load(sonData.get(13).getImage_url_big()).into(holderSon1.runeIv);
                holderSon1.sonTv.setText(sonData.get(16).getTitle());
                holderSon1.talentTv.setText(sonData.get(14).getTitle());
                holderSon1.runeTv.setText(sonData.get(13).getTitle());
                break;
        }

        return view;
    }

    // 设置子列表是否可以被选择
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    class ViewHolderFather {
        private TextView fatherTv, downloadTv;
        private ImageView fatherIv;

        public ViewHolderFather(View view) {
            fatherTv = (TextView) view.findViewById(R.id.discovery_game_father_tv);
            downloadTv = (TextView) view.findViewById(R.id.discovery_game_father_download_tv);
            fatherIv = (ImageView) view.findViewById(R.id.discovery_game_father_iv);

        }
    }

    class ViewHolderBelowFather {
        private TextView comFatherTv;
        private ImageView comFatherIv;

        public ViewHolderBelowFather(View view) {
            comFatherIv = (ImageView) view.findViewById(R.id.discovery_community_father_iv);
            comFatherTv = (TextView) view.findViewById(R.id.discovery_community_father_tv);
        }
    }

    class ViewHolderSon {
        private TextView sonTv, talentTv, runeTv;
        private ImageView sonIv, talentIv, runeIv;

        public ViewHolderSon(View view) {
            sonTv = (TextView) view.findViewById(R.id.discovery_game_son_one_tv);
            sonIv = (ImageView) view.findViewById(R.id.discovery_game_son_one_iv);
            talentIv = (ImageView) view.findViewById(R.id.discovery_game_son_two_iv);
            talentTv = (TextView) view.findViewById(R.id.discovery_game_son_two_tv);
            runeTv = (TextView) view.findViewById(R.id.discovery_game_son_three_tv);
            runeIv = (ImageView) view.findViewById(R.id.discovery_game_son_three_iv);
        }
    }

    class ViewHolderSon1 {
        private TextView sonTv, talentTv, runeTv;
        private ImageView sonIv, talentIv, runeIv;

        public ViewHolderSon1(View view) {
            sonTv = (TextView) view.findViewById(R.id.discovery_game_son_one_tv);
            sonIv = (ImageView) view.findViewById(R.id.discovery_game_son_one_iv);
            talentIv = (ImageView) view.findViewById(R.id.discovery_game_son_two_iv);
            talentTv = (TextView) view.findViewById(R.id.discovery_game_son_two_tv);
            runeTv = (TextView) view.findViewById(R.id.discovery_game_son_three_tv);
            runeIv = (ImageView) view.findViewById(R.id.discovery_game_son_three_iv);
        }
    }
}
