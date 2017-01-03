package com.naruto.b_pocketnewlol.discovery.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseFragment;
import com.naruto.b_pocketnewlol.discovery.adapter.PictureNewRvAdapter;
import com.naruto.b_pocketnewlol.discovery.bean.PictureNewBean;
import com.naruto.b_pocketnewlol.entity.NetTool;
import com.naruto.b_pocketnewlol.entity.onHttpCallBack;
import com.naruto.b_pocketnewlol.tools.UrlTools;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureNewFragment extends BaseFragment implements OnRefreshListener, OnLoadMoreListener {

    private SwipeToLoadLayout swipeToLoadLayout;
    private RecyclerView rv;
    private PictureNewRvAdapter adapter;
    private List<PictureNewBean.WallpapersBean> data;
    private int i = 1;
    private String newUrl;

    @Override
    public int setLayout() {
        return R.layout.fragment_picture_new;
    }

    @Override
    public void initView(View view) {
        rv = bindView(R.id.swipe_target);
        data = new ArrayList<>();
        adapter = new PictureNewRvAdapter(getContext());
        swipeToLoadLayout = bindView(R.id.swipeToLoadLayout);
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);
    }

    @Override
    public void initData() {

        getPictureData();
    }

    private void getPictureData() {
        String url = UrlTools.DISCOVERY_NEW_PHOTO;
        NetTool.getInstance().startRequest(url, PictureNewBean.class, new onHttpCallBack<PictureNewBean>() {
            @Override
            public void onSuccess(PictureNewBean response) {
                data=response.getWallpapers();
                adapter.setData(data);
                rv.setAdapter(adapter);
                GridLayoutManager manager = new GridLayoutManager(getContext(),2, LinearLayoutManager.VERTICAL,false);
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
                newUrl = UrlTools.NEW_MORE_PHOTO_HEAD + i + UrlTools.NEW_MORE_PHOTO_TAIL;
                getData();
                i++;
                Log.d("aaa", newUrl);
            }
        },2000);
    }

    private void getData() {
        NetTool.getInstance().startRequest(newUrl, PictureNewBean.class, new onHttpCallBack<PictureNewBean>() {
            @Override
            public void onSuccess(PictureNewBean response) {
                adapter.addMore(response.getWallpapers());
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

}
