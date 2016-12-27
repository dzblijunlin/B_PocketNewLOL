package com.naruto.b_pocketnewlol.me;

import android.os.Bundle;
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

import java.util.List;

/**
 * 看这里,很强势!
 * Created by DgPeng on 16/12/22.
 */

public class MeLolFragment extends BaseFragment {

    private LRecyclerView lRecyclerView;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private List<MeLoLBean.DataBean.ItemsBean> data;
    private MeLoLAdapter meLoLAdapter;
    private int i = 1;
    @Override
    public int setLayout() {
        return R.layout.fragment_lol_me;
    }

    @Override
    public void initView(View view) {

        lRecyclerView = bindView(R.id.me_lol_lrv);
        meLoLAdapter = new MeLoLAdapter(getContext());
        lRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(meLoLAdapter);
    }

    @Override
    public void initData() {

        getNewData(urlAll(1));

        lRecyclerView.setAdapter(lRecyclerViewAdapter);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,1);
        lRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        // 刷新
        lRecyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                meLoLAdapter.Clear();
                getNewData(urlAll(1));
                lRecyclerView.refreshComplete();
            }
        });
        // 加载
        lRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                getNewData(urlAll(i));
                i++;
            }
        });
    }

    private void getNewData(String url) {

        NetTool.getInstance().startRequest(url, MeLoLBean.class, new onHttpCallBack<MeLoLBean>() {
            @Override
            public void onSuccess(MeLoLBean response) {
                data = response.getData().getItems();

                meLoLAdapter.setData(data);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public String urlAll(int i){
        String url1 = getArguments().getString("key1");
        String url2 = getArguments().getString("key2");
        String url3 = getArguments().getString("key3");
        String url4 = getArguments().getString("key4");
        return url1 + url2 + url3 + (i + 1) + url4;
    }

    public static MeLolFragment newInstance(String url1,String url2,String url3,String url4) {

        Bundle args = new Bundle();
        args.putString("key1",url1);
        args.putString("key2",url2);
        args.putString("key3",url3);
        args.putString("key4",url4);
        MeLolFragment fragment = new MeLolFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
