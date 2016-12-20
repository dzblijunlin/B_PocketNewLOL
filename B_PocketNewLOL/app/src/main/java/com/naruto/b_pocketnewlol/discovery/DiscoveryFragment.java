package com.naruto.b_pocketnewlol.discovery;




import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseFragment;
import com.naruto.b_pocketnewlol.discovery.adapter.TeamAdapter;
import com.naruto.b_pocketnewlol.discovery.bean.TeamBean;
import com.naruto.b_pocketnewlol.entity.NetTool;
import com.naruto.b_pocketnewlol.entity.onHttpCallBack;
import com.naruto.b_pocketnewlol.tools.UrlTools;

import java.util.List;

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
        rv = bindView(R.id.discovery_rv);

    }

    @Override
    public void initData() {
        getTeamData();
    }

    private void getTeamData() {
        String url = UrlTools.DISCOVERY_TEAM;
        NetTool.getInstance().startRequest(url, TeamBean.class, new onHttpCallBack<TeamBean>() {
            @Override
            public void onSuccess(TeamBean response) {
                List<TeamBean.ClubsBean> data = response.getClubs();
                TeamAdapter adapter = new TeamAdapter(getContext());
                adapter.setData(data);
                rv.setAdapter(adapter);
                LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
                rv.setLayoutManager(manager);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
