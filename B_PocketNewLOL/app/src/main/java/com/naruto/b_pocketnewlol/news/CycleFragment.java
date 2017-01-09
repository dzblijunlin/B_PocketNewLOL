package com.naruto.b_pocketnewlol.news;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseFragment;
import com.naruto.b_pocketnewlol.entity.NetTool;
import com.naruto.b_pocketnewlol.entity.onHttpCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CycleFragment extends BaseFragment implements MyClick {

    private List<CycleBean.ListBean> data;
    private CycleAdapter adapter;
    private LRecyclerView recyclerView;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private int i = 0;

    @Override
    public int setLayout() {
        return R.layout.fragment_cycle;
    }

    @Override
    public void initView(View view) {
        data = new ArrayList<>();
        adapter = new CycleAdapter(getContext());
        recyclerView = (LRecyclerView) view.findViewById(R.id.rv_news);
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
    }

    @Override
    public void initData() {
        StartUrl(urlAll(0));
        recyclerView.setAdapter(lRecyclerViewAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_top, null);
        RelativeLayout rlLeft = (RelativeLayout) view.findViewById(R.id.rl_one);
        RelativeLayout rlRight = (RelativeLayout) view.findViewById(R.id.rl_two);

        adapter.setMyClick(this);

        rlLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EventsActivity.class);
                startActivity(intent);
            }
        });

        rlRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VideoActivity.class);
                startActivity(intent);
            }
        });

//        lRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int i) {
//                Log.d("CycleFragment", data.get(i).getArticle_url());
//                Intent intent = new Intent(getActivity(),WebBannerActivity.class);
//                intent.putExtra("url",data.get(i).getArticle_url());
//                startActivity(intent);
//            }
//        });

        lRecyclerViewAdapter.addHeaderView(view);

        recyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.clean();
                StartUrl(urlAll(0));
                recyclerView.refreshComplete();
            }
        });
        recyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                i = i + 1;
                StartUrl(urlAll(i));
            }
        });




    }

    private void StartUrl(String url) {
        NetTool.getInstance().startRequest(url, CycleBean.class, new onHttpCallBack<CycleBean>() {
            @Override
            public void onSuccess(CycleBean response) {
                data = response.getList();
                adapter.setData(data);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public String urlAll(int i) {
        String url1 = getArguments().getString("url1");
        String url2 = getArguments().getString("url2");
        String url3 = getArguments().getString("url3");
        String url4 = getArguments().getString("url4");
        return url1 + url2 + url3 + i + url4;
    }

    public static CycleFragment newInstance(String url1, String url2, String url3, String url4) {

        Bundle args = new Bundle();
        args.putString("url1", url1);
        args.putString("url2", url2);
        args.putString("url3", url3);
        args.putString("url4", url4);
        CycleFragment fragment = new CycleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void MyListener(String pos) {
        Intent intent = new Intent(getActivity(), WebBannerActivity.class);
        intent.putExtra("url", pos);
        startActivity(intent);
    }

}
