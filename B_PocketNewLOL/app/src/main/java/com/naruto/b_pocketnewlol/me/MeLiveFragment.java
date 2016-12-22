package com.naruto.b_pocketnewlol.me;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseFragment;
import com.naruto.b_pocketnewlol.entity.NetTool;
import com.naruto.b_pocketnewlol.entity.onHttpCallBack;
import com.naruto.b_pocketnewlol.tools.UrlTools;

import java.util.ArrayList;
import java.util.List;

/**
 * 看这里,很强势!
 * Created by DgPeng on 16/12/21.
 */

public class MeLiveFragment extends BaseFragment implements MeLiveClick {

    private RecyclerView recyclerView, detailsRecyclerView;
    private MeLiveAdapter meLiveAdapter;
    private MeLIveDetailsAdapter meLIveDetailsAdapter;
    private MeLiveBean list;

    @Override
    public int setLayout() {
        return R.layout.fragment_live_me;
    }

    @Override
    public void initView(View view) {
        recyclerView = bindView(R.id.rv_me);
        meLiveAdapter = new MeLiveAdapter(getContext());

        // 接口回调
        meLiveAdapter.setMeLiveClick(this);
    }

    @Override
    public void initData() {

        // 解析数据
        String url = UrlTools.ME_LIVE;
        NetTool.getInstance().startRequest(url, MeLiveBean.class, new onHttpCallBack<MeLiveBean>() {
            @Override
            public void onSuccess(MeLiveBean response) {
                list = response;
                Log.d("asd", "list:" + list);
                meLiveAdapter.setBean(list);
                recyclerView.setAdapter(meLiveAdapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(linearLayoutManager);

            }

            @Override
            public void onError(Throwable e) {

            }
        });


    }

    @Override
    public void onClick(final int pos) {

    }
}
