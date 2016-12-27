package com.naruto.b_pocketnewlol.discovery.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseActivity;
import com.naruto.b_pocketnewlol.discovery.adapter.HeroTabAdapter;
import com.naruto.b_pocketnewlol.discovery.fragment.AllHeroFragment;
import com.naruto.b_pocketnewlol.discovery.fragment.FreeHeroFragment;
import com.naruto.b_pocketnewlol.discovery.fragment.MyHeroFragment;

import java.util.ArrayList;

public class HeroSecondActivity extends BaseActivity {


    private TabLayout tab;
    private ViewPager vp;
    private ArrayList<Fragment> data;
    private ImageView backIv;

    @Override
    public int setLayout() {
        return R.layout.activity_hero_second;
    }

    @Override
    public void initView() {

        tab = bindView(R.id.discovery_hero_sec_tab);
        vp = bindView(R.id.discovery_hero_sec_vp);
        backIv = bindView(R.id.discovery_hero_sec_back_iv);
        data = new ArrayList<>();
    }

    @Override
    public void initData() {
        getTabData();
        getBack();
    }

    private void getBack() {
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void getTabData() {
        data.add(new FreeHeroFragment());
        data.add(new MyHeroFragment());
        data.add(new AllHeroFragment());
        HeroTabAdapter adapter = new HeroTabAdapter(getSupportFragmentManager(),data);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("周免英雄");
        tab.getTabAt(1).setText("我的英雄");
        tab.getTabAt(2).setText("全部英雄");

    }
}
