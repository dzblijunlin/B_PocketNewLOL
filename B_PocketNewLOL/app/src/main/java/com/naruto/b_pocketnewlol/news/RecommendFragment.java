package com.naruto.b_pocketnewlol.news;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseFragment;
import com.naruto.b_pocketnewlol.entity.NetTool;
import com.naruto.b_pocketnewlol.entity.onHttpCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends BaseFragment{

    private RecyclerView rv;
    private List<OneBean.MsgBean.HotRecWpvlistBean> data;
    private OneAdapter oneAdapter;
    private RecommendAdapter adapter;

    @Override
    public int setLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void initView(View view) {
        rv = (RecyclerView) view.findViewById(R.id.lr_video);
        data = new ArrayList<>();
        oneAdapter = new OneAdapter(getContext());
        adapter = new RecommendAdapter(getContext());
    }

    @Override
    public void initData() {
        Toast.makeText(getContext(), "bbbbb", Toast.LENGTH_SHORT).show();
        StartUrl("http://lol.qq.com/web201310/js/videodata/LOL_APP_HOTREC_LIST.js");
    }

    private void StartUrl(String url) {
        NetTool.getInstance().startRequest(url, OneBean.class, new onHttpCallBack<OneBean>() {
            @Override
            public void onSuccess(OneBean response) {
                data = response.getMsg().getHotRecWpvlist();
//                oneAdapter.setData(data);
//                rv.setAdapter(adapter);
                adapter.setData1(data);
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(getContext()));
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

}
