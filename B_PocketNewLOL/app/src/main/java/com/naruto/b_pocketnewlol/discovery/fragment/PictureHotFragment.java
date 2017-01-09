package com.naruto.b_pocketnewlol.discovery.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseFragment;
import com.naruto.b_pocketnewlol.discovery.adapter.PictureHotRvAdapter;
import com.naruto.b_pocketnewlol.discovery.bean.PictureHotBean;
import com.naruto.b_pocketnewlol.entity.NetTool;
import com.naruto.b_pocketnewlol.entity.onHttpCallBack;
import com.naruto.b_pocketnewlol.tools.UrlTools;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureHotFragment extends BaseFragment implements OnRefreshListener, OnLoadMoreListener {

    private List<PictureHotBean.WallpapersBean> data;
    private RecyclerView rv;
    private int i = 1;
    private PictureHotRvAdapter adapter;
    // 自定义上下拉动画
    private SwipeToLoadLayout swipeToLoadLayout;
    private String newUrl;

    @Override
    public int setLayout() {
        return R.layout.fragment_picture_hot;
    }

    @Override
    public void initView(View view) {

        rv = bindView(R.id.swipe_target);
        data = new ArrayList<>();
        adapter = new PictureHotRvAdapter(getContext());
        swipeToLoadLayout = bindView(R.id.swipeToLoadLayout);
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);
    }

    @Override
    public void initData() {
        getPictureData();
    }

    private void getPictureData() {
        String url = UrlTools.HOT_MORE_PHOTO_HEAD + 0 + UrlTools.HOT_MORE_PHOTO_TAIL;
        NetTool.getInstance().startRequest(url, PictureHotBean.class, new onHttpCallBack<PictureHotBean>() {
            @Override
            public void onSuccess(PictureHotBean response) {
                data = response.getWallpapers();
                adapter.setData(data);
                rv.setAdapter(adapter);
                StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,1);
                rv.setLayoutManager(manager);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    public void onRefresh() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(false);
                getPictureData();
            }
        },2000);
    }

    @Override
    public void onLoadMore() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setLoadingMore(false);
                newUrl = UrlTools.HOT_MORE_PHOTO_HEAD + i + UrlTools.HOT_MORE_PHOTO_TAIL;
                getData();
                i++;
                Log.d("aaa", newUrl);
            }


        },2000);
    }

    private void getData() {
        NetTool.getInstance().startRequest(newUrl, PictureHotBean.class, new onHttpCallBack<PictureHotBean>() {
            @Override
            public void onSuccess(PictureHotBean response) {
                adapter.addMore(response.getWallpapers());
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
