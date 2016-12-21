package com.naruto.b_pocketnewlol.me;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.naruto.b_pocketnewlol.R;

import java.util.ArrayList;

/**
 * 看这里,很强势!
 * Created by DgPeng on 16/12/21.
 */

public class MeTabAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;
    private String [] tabTitles = new String[]{"精彩推荐","全部直播","英雄联盟","炉石传说","熊猫星秀"};
    private int [] imageResId = {R.drawable.selector_recommend_tab
            ,R.drawable.selector_all_live_tab
            ,R.drawable.selector_lol_tab
            ,R.drawable.selector_lushi_tab
            ,R.drawable.selector_panda_tab};
    private Context context;

//    public MeTabAdapter(FragmentManager fm, Context context) {
//        super(fm);
//        this.context = context;
//    }

    public MeTabAdapter(FragmentManager fm, ArrayList<Fragment> fragments,Context context) {
        super(fm);
        this.fragments = fragments;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }



    public View getTabView(int postion){
        View view = LayoutInflater.from(context).inflate(R.layout.item_tab,null);
        TextView tv = (TextView) view.findViewById(R.id.item_tab_tv);
        tv.setText(tabTitles[postion]);
        ImageView img = (ImageView) view.findViewById(R.id.item_tab_iv);
        img.setImageResource(imageResId[postion]);
        return view;
    }


}
