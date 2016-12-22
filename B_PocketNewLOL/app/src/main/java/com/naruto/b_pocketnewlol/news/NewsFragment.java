package com.naruto.b_pocketnewlol.news;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;


import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseFragment;
import com.naruto.b_pocketnewlol.entity.NetTool;
import com.naruto.b_pocketnewlol.entity.onHttpCallBack;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * kevin
 */
public class NewsFragment extends BaseFragment {

    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> data;
    private NewTabAdapter adapter;
    private ArrayList<String> pics;
    private Banner banner;
    private ArrayList<String> urls;

    @Override
    public int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    public void initView(View view) {
        vp = (ViewPager) view.findViewById(R.id.vp_news);
        tab = (TabLayout) view.findViewById(R.id.tab_news);
        data = new ArrayList<>();
        banner = (Banner) view.findViewById(R.id.banner);
    }

    @Override
    public void initData() {
        data.add(CycleFragment.newInstance("http://qt.qq.com/php_cgi/news/php/varcache_getnews.php?id="
        ,"12","&page=","&plat=android&version=9713"));

        data.add(CycleFragment.newInstance("http://qt.qq.com/php_cgi/news/php/varcache_getnews.php?id="
        ,"18","&page=","&plat=android&version=9713"));

        data.add(CycleFragment.newInstance("http://qt.qq.com/php_cgi/news/php/varcache_getnews.php?id="
        ,"3","&page=","&plat=android&version=9713"));

        data.add(CycleFragment.newInstance("http://qt.qq.com/php_cgi/news/php/varcache_getnews.php?id="
        ,"23","&page=","&plat=android&version=9713"));

        data.add(CycleFragment.newInstance("http://qt.qq.com/php_cgi/news/php/varcache_getnews.php?id="
        ,"10","&page=","&plat=android&version=9713"));


        adapter = new NewTabAdapter(getChildFragmentManager(),data);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);

        tab.getTabAt(0).setText("最新");
        tab.getTabAt(1).setText("娱乐");
        tab.getTabAt(2).setText("官方");
        tab.getTabAt(3).setText("活动");
        tab.getTabAt(4).setText("攻略");
        /////////////////////

        pics = new ArrayList<>();
        urls = new ArrayList<>();
        StartUrl("http://qt.qq.com/static/pages/news/phone/c13_list_1.shtml?plat=android&version=9713");
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent = new Intent(getActivity(),WebBannerActivity.class);
                intent.putExtra("url",urls.get(position - 1));
                startActivity(intent);
            }
        });

    }

    private void StartUrl(String url) {
        NetTool.getInstance().startRequest(url, BannerBean.class, new onHttpCallBack<BannerBean>() {
            @Override
            public void onSuccess(BannerBean response) {
                // 轮播显示的网址集合
                for (int i = 0; i < response.getList().size(); i++) {
                    pics.add(response.getList().get(i).getImage_url_big());
                    urls.add(response.getList().get(i).getArticle_url());
                }

                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                banner.setImageLoader(new GlideImageLoader());
                banner.setImages(pics);
                banner.setBannerAnimation(Transformer.DepthPage);
                banner.isAutoPlay(true);
                banner.setDelayTime(2000);
                banner.setIndicatorGravity(BannerConfig.CENTER);
                banner.start();
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

}
