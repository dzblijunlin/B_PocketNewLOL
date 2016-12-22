package com.naruto.b_pocketnewlol.me;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseFragment;
import com.naruto.b_pocketnewlol.entity.NetTool;
import com.naruto.b_pocketnewlol.entity.onHttpCallBack;
import com.naruto.b_pocketnewlol.tools.UrlTools;

import java.util.List;

/**
 * 看这里,很强势!
 * Created by DgPeng on 16/12/22.
 */

public class MeAllLiveFragment extends BaseFragment {

    private LRecyclerView lRecyclerView;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private MeAllAdapter meAllAdapter;
    private List<MeAllLiveBean.DataBean.ItemsBean> data;
    private int i = 1;

    @Override
    public int setLayout() {
        return R.layout.fragment_all_live_me;
    }

    @Override
    public void initView(View view) {
        lRecyclerView = bindView(R.id.me_all_lrv);
        meAllAdapter = new MeAllAdapter(getContext());
        lRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(meAllAdapter);
    }

    @Override
    public void initData() {
        getNewData(url(1));
        lRecyclerView.setAdapter(lRecyclerViewAdapter);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,1);
        lRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        // 刷新
        lRecyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                meAllAdapter.Clear();
                getNewData(url(1));
                lRecyclerView.refreshComplete();
            }
        });
        // 加载
        lRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {

                getNewData(url(i));
                i++;
            }
        });

    }

    private void getNewData(String url) {

        NetTool.getInstance().startRequest(url, MeAllLiveBean.class, new onHttpCallBack<MeAllLiveBean>() {
            @Override
            public void onSuccess(MeAllLiveBean response) {
                data = response.getData().getItems();
                meAllAdapter.setData(data);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public String url(int i) {

        String allUrl = UrlTools.ME_ALL_HEAD + (i+1) + UrlTools.ME_ALL_FOOTER;
        return allUrl;
    }


}
