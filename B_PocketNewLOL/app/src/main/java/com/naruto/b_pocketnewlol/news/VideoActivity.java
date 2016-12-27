package com.naruto.b_pocketnewlol.news;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseActivity;

import java.util.ArrayList;

public class VideoActivity extends BaseActivity{

    private TabVideoAdapter adapter;
    private ArrayList<Fragment> data;
    private TabLayout tab;
    private ViewPager vp;
    private ImageView imgBack;

    @Override
    public int setLayout() {
        return R.layout.activity_video;
    }

    @Override
    public void initView() {
        tab = (TabLayout) findViewById(R.id.tab_video);
        vp = (ViewPager) findViewById(R.id.vp_video);
        data = new ArrayList<>();
        imgBack = (ImageView) findViewById(R.id.video_acy_img_back);
    }

    @Override
    public void initData() {
        data.add(new RecommendFragment());
        data.add(new ExplainFragment());
        data.add(new GameFragment());
        data.add(new EntertainmentFragment());
        data.add(new HeroFragment());
        adapter = new TabVideoAdapter(getSupportFragmentManager(),data);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);

        tab.getTabAt(0).setText("推荐");
        tab.getTabAt(1).setText("解说");
        tab.getTabAt(2).setText("赛事");
        tab.getTabAt(3).setText("娱乐");
        tab.getTabAt(4).setText("英雄");

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
