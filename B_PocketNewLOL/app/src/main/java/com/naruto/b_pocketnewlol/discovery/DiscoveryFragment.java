package com.naruto.b_pocketnewlol.discovery;



import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseFragment;

/**
 * 大嘴宝的任务
 */
public class DiscoveryFragment extends BaseFragment {
    private RecyclerView rv;


    @Override
    public int setLayout() {
        return R.layout.fragment_discovery;
    }

    @Override
    public void initView(View view) {
        rv = bindView(R.layout.item_discovery_title_rv);
    }

    @Override
    public void initData() {

    }
}
