package com.naruto.b_pocketnewlol.news;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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
    private List<TwoBean.MsgBean.ResultBean> data2;

    private List<FourBean.MsgBean.ResultBean> data4;
    private RecommendAdapter adapter;

    @Override
    public int setLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void initView(View view) {
        rv = (RecyclerView) view.findViewById(R.id.lr_video);
        data = new ArrayList<>();
        adapter = new RecommendAdapter(getContext());
    }

    @Override
    public void initData() {
        StartUrl("http://lol.qq.com/web201310/js/videodata/LOL_APP_HOTREC_LIST.js");
        StartUrl2("http://apps.game.qq.com/lol/act/website2013/video.php?page=1&p4=0&p2=9999&r1=1&pagesize=10&source=lolapp");

        StartUrl4("http://apps.game.qq.com/lol/act/website2013/video.php?page=1&pagesize=10&r1=1&source=lolapp");
    }

    private void StartUrl(String url) {
        NetTool.getInstance().startRequest(url, OneBean.class, new onHttpCallBack<OneBean>() {
            @Override
            public void onSuccess(OneBean response) {
                data = response.getMsg().getHotRecWpvlist();
                adapter.setData1(data);
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(getContext()));
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    private void StartUrl2(String url) {
        NetTool.getInstance().startRequest(url, TwoBean.class, new onHttpCallBack<TwoBean>() {
            @Override
            public void onSuccess(TwoBean response) {
                data2 = response.getMsg().getResult();
                adapter.setData2(data2);
//                rv.setAdapter(adapter);
//                rv.setLayoutManager(new LinearLayoutManager(getContext()));
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    private void StartUrl4(String url) {
        NetTool.getInstance().startRequest(url, FourBean.class, new onHttpCallBack<FourBean>() {
            @Override
            public void onSuccess(FourBean response) {
                data4 = response.getMsg().getResult();
                adapter.setData4(data4);
//                rv.setAdapter(adapter);
//                rv.setLayoutManager(new LinearLayoutManager(getContext()));
//                rv.setLayoutManager(new StaggeredGridLayoutManager(2,1));
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }


}
