package com.naruto.b_pocketnewlol.discovery.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseActivity;
import com.naruto.b_pocketnewlol.discovery.adapter.TeamPhotoAdapter;
import com.naruto.b_pocketnewlol.discovery.bean.TeamNumPhotoBean;
import com.naruto.b_pocketnewlol.entity.NetTool;
import com.naruto.b_pocketnewlol.entity.onHttpCallBack;
import com.naruto.b_pocketnewlol.tools.UrlTools;

import java.util.ArrayList;
import java.util.List;

public class TeamSecondActivity extends BaseActivity {

    private List<TeamNumPhotoBean.MembersBean> data;
    private LRecyclerView rv;
    private LRecyclerViewAdapter lRecyclerViewAdapter;

    private TeamPhotoAdapter adapter;

    @Override
    public int setLayout() {
        return R.layout.activity_team_second;
    }

    @Override
    public void initView() {
        rv = bindView(R.id.discovery_team_num_rv);
        data = new ArrayList<>();
        rv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        adapter = new TeamPhotoAdapter(this);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
    }

    @Override
    public void initData() {
        getTeamPhoto();
    }

    private void getTeamPhoto() {
        String url = UrlTools.DISCOVERY_TEAM_NUM_PHOTO;
        NetTool.getInstance().startRequest(url, TeamNumPhotoBean.class, new onHttpCallBack<TeamNumPhotoBean>() {
            @Override
            public void onSuccess(TeamNumPhotoBean response) {
                data = response.getMembers();
                Log.d("ssss", "data:" + data);
                adapter.setData(data);
                rv.setAdapter(lRecyclerViewAdapter);
                LinearLayoutManager manager = new LinearLayoutManager(TeamSecondActivity.this,LinearLayoutManager.HORIZONTAL,false);
                rv.setLayoutManager(manager);

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}







