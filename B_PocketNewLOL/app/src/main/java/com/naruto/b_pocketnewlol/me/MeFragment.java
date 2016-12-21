package com.naruto.b_pocketnewlol.me;


import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;


import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseFragment;
import com.naruto.b_pocketnewlol.entity.NetTool;
import com.naruto.b_pocketnewlol.entity.onHttpCallBack;
import com.naruto.b_pocketnewlol.news.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends BaseFragment {
    // 这是DgPeng 的任务

    private TabLayout tabMe;
    private ViewPager vpMe;
    private Banner bannerMe;
    private ArrayList<String> pics;
    private ArrayList<Fragment> datas;
    private MeTabAdapter meTabAdapter;

    @Override
    public int setLayout() {
        return R.layout.fragment_me;
    }

    @Override
    public void initView(View view) {
        tabMe = bindView(R.id.tab_me);
        vpMe = bindView(R.id.vp_me);
        bannerMe = bindView(R.id.banner_me);

    }

    @Override
    public void initData() {
        datas = new ArrayList<>();
        datas.add(new MeLiveFragment());
        datas.add(new MeLiveFragment());
        datas.add(new MeLiveFragment());
        datas.add(new MeLiveFragment());
        datas.add(new MeLiveFragment());
        meTabAdapter = new MeTabAdapter(getChildFragmentManager(),datas,getContext());
        vpMe.setAdapter(meTabAdapter);
        tabMe.setupWithViewPager(vpMe);

        for (int i = 0; i < tabMe.getTabCount(); i++) {
            TabLayout.Tab tab = tabMe.getTabAt(i);
            tab.setCustomView(meTabAdapter.getTabView(i));

        }


//        tabMe.getTabAt(0).setText("精彩推荐");
//        tabMe.getTabAt(1).setText("全部直播");
//        tabMe.getTabAt(2).setText("英雄联盟");
//        tabMe.getTabAt(3).setText("炉石传说");
//        tabMe.getTabAt(4).setText("熊猫星秀");

        //设置文字颜色
//        tabMe.setTabTextColors(Color.BLACK,Color.GREEN);
        tabMe.setTabTextColors(Color.BLACK,Color.argb(255,0,216,151));
        //设置光标颜色
//        tabMe.setSelectedTabIndicatorColor(Color.GREEN);
        tabMe.setSelectedTabIndicatorColor(Color.argb(255,0,216,151));

        pics = new ArrayList<>();
        StartUrl("http://api.m.panda.tv/ajax_rmd_ads_get?__version=1.1.8.1405&__plat=android");
    }

    private void StartUrl(String url) {
        NetTool.getInstance().startRequest(url, MeBannerBean.class, new onHttpCallBack<MeBannerBean>() {
            @Override
            public void onSuccess(MeBannerBean response) {
                Log.d("sss", "response:" + response);
                for (int i = 0; i < response.getData().size(); i++) {
                    pics.add(response.getData().get(i).getNewimg());
                    Log.d("aaa", response.getData().get(i).getNewimg());
                }
                bannerMe.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                bannerMe.setImageLoader(new GlideImageLoader());
                bannerMe.setImages(pics);
                bannerMe.setBannerAnimation(Transformer.DepthPage);
                bannerMe.isAutoPlay(true);
                bannerMe.setDelayTime(2000);
                bannerMe.setIndicatorGravity(BannerConfig.CENTER);
                bannerMe.start();
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
