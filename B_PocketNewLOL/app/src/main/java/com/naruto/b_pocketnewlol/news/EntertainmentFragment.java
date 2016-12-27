package com.naruto.b_pocketnewlol.news;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
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
public class EntertainmentFragment extends BaseFragment {

    private List<TopBean.MsgBean> dataTop;
    private List<FootBean.MsgBean.ResultBean> dataFoot;
    private RecyclerView recyclerView;
    private EntertainAdapter adapter;
//    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private LRecyclerView lRecyclerView;

    private int i = 1;

    @Override
    public int setLayout() {
        return R.layout.fragment_entertainment;
    }

    @Override
    public void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.lrv_entertain);
        adapter = new EntertainAdapter(getContext());
//        lRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
        View view1 = LayoutInflater.from(getContext()).inflate(R.layout.item_enter_foot,null);
        lRecyclerView = (LRecyclerView) view1.findViewById(R.id.rv_foot);
    }

    @Override
    public void initData() {
        StartTop("http://lol.qq.com/web201310/js/videodata/LOL_APP_SPECIAL_LIST.js");
        StartFoot(UrlAll(1));


        lRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                i = i + 1;
                StartFoot(UrlAll(i));
            }
        });
        Log.d("EntertainmentFragment", "sssssss");

    }

    private void StartTop(String url) {
        NetTool.getInstance().startRequest(url, TopBean.class, new onHttpCallBack<TopBean>() {
            @Override
            public void onSuccess(TopBean response) {
                dataTop = response.getMsg();
                adapter.setDataTop(dataTop);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    private void StartFoot(String url) {
        NetTool.getInstance().startRequest(url, FootBean.class, new onHttpCallBack<FootBean>() {
            @Override
            public void onSuccess(FootBean response) {
                dataFoot = response.getMsg().getResult();
                Log.d("EntertainmentFragment", "dataFoot.size():" + dataFoot.size());
                adapter.setDataFoot(dataFoot);

                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }

            @Override
            public void onError(Throwable e) {
                Log.d("EntertainmentFragment", "e:" + e);
            }
        });
    }

    public String UrlAll(int i){
        return "http://apps.game.qq.com/lol/act/website2013/video.php?page=" + i + "&p4=0&p1=2&r1=1&pagesize=10&source=lolapp";
    }

}
