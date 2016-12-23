package com.naruto.b_pocketnewlol.news;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
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
public class GameFragment extends BaseFragment {

    private List<GameBean.MsgBean.ResultBean> data;
    private LRecyclerView recyclerView;
    private GameAdapter adapter;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private int i = 1;

    @Override
    public int setLayout() {
        return R.layout.fragment_game;
    }

    @Override
    public void initView(View view) {
        recyclerView = (LRecyclerView) view.findViewById(R.id.Lrv_game);
        adapter = new GameAdapter(getContext());
        lRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
    }

    @Override
    public void initData() {
        StartUrl(UrlAll(1));
        recyclerView.setAdapter(lRecyclerViewAdapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,1));

        recyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView.refreshComplete();
            }
        });

        recyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                i = i + 1;
                StartUrl(UrlAll(i));
            }
        });
    }

    private void StartUrl(String url) {
        NetTool.getInstance().startRequest(url, GameBean.class, new onHttpCallBack<GameBean>() {
            @Override
            public void onSuccess(GameBean response) {
                data = response.getMsg().getResult();
                adapter.setData(data);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public String UrlAll(int i){
        return "http://apps.game.qq.com/lol/act/website2013/video.php?page=" + i + "&p4=0&p2=9999&r1=1&pagesize=10&source=lolapp";
    }
}
