package com.naruto.b_pocketnewlol.news;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;


import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * kevin
 */
public class NewsFragment extends BaseFragment {

    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> data;
    private NewTabAdapter adapter;

    @Override
    public int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    public void initView(View view) {
        vp = (ViewPager) view.findViewById(R.id.vp_news);
        tab = (TabLayout) view.findViewById(R.id.tab_news);
        data = new ArrayList<>();
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
        tab.getTabAt(0).setText("最新");
        tab.getTabAt(0).setText("最新");
        tab.getTabAt(0).setText("最新");
        tab.getTabAt(0).setText("最新");
    }

}
