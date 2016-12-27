package com.naruto.b_pocketnewlol.news;


import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseFragment;
import com.naruto.b_pocketnewlol.entity.NetTool;
import com.naruto.b_pocketnewlol.entity.onHttpCallBack;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HeroFragment extends BaseFragment {

    private List<HeroBean.MsgBean.ResultBean> data;
    private LRecyclerView recyclerView;
    private HeroAdapter adapter;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private int i = 1;

    @Override
    public int setLayout() {
        return R.layout.fragment_hero;
    }

    @Override
    public void initView(View view) {
        recyclerView = (LRecyclerView) view.findViewById(R.id.hero_lrv);
        adapter = new HeroAdapter(getContext());
        lRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
    }

    @Override
    public void initData() {
        StartUrl(UrlAll(1));
        recyclerView.setAdapter(lRecyclerViewAdapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,1));

        recyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                i = i + 1;
                StartUrl(UrlAll(i));
            }
        });
    }

    private void StartUrl(String url) {
        NetTool.getInstance().startRequest(url, HeroBean.class, new onHttpCallBack<HeroBean>() {
            @Override
            public void onSuccess(HeroBean response) {
                data = response.getMsg().getResult();
                adapter.setData(data);

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public String UrlAll(int i){
        return "http://apps.game.qq.com/lol/act/website2013/video.php?page=" + i + "&pagesize=10&r1=1&source=lolapp";
    }

}
