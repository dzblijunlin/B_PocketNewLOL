package com.naruto.b_pocketnewlol.discovery.activity;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseActivity;
import com.naruto.b_pocketnewlol.discovery.adapter.PictureTabAdapter;
import com.naruto.b_pocketnewlol.discovery.fragment.PictureClassifyFragment;
import com.naruto.b_pocketnewlol.discovery.fragment.PictureCollectFragment;
import com.naruto.b_pocketnewlol.discovery.fragment.PictureHotFragment;
import com.naruto.b_pocketnewlol.discovery.fragment.PictureNewFragment;

import java.util.ArrayList;

public class PictureSecondActivity extends BaseActivity {

private ArrayList<Fragment> data;
    private TabLayout tab;
    private ViewPager vp;
    private PictureTabAdapter adapter;
    private ImageView iv;
    @Override
    public int setLayout() {
        return R.layout.activity_picture_second;
    }

    @Override
    public void initView() {
        tab = bindView(R.id.tab_picture);
        vp = bindView(R.id.vp_picture);
        data = new ArrayList<>();
        iv = bindView(R.id.iv_picture_back);

    }

    @Override
    public void initData() {
        getTab();
        getBack();
    }

    private void getBack() {
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getTab() {

        data.add(new PictureNewFragment());
        data.add(new PictureHotFragment());
        data.add(new PictureClassifyFragment());
        data.add(new PictureCollectFragment());
        adapter = new PictureTabAdapter(getSupportFragmentManager(),data);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("最新");
        tab.getTabAt(1).setText("最热");
        tab.getTabAt(2).setText("分类");
        tab.getTabAt(3).setText("收藏");


    }
}
