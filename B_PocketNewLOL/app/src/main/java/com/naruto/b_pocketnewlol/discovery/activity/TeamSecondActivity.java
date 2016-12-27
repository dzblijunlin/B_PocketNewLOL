package com.naruto.b_pocketnewlol.discovery.activity;

import android.content.Intent;
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
    private String id;
    private int pos;

    @Override
    public int setLayout() {
        return R.layout.activity_team_second;
    }

    @Override
    public void initView() {
        rv = bindView(R.id.discovery_team_num_rv);
        data = new ArrayList<>();
        rv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);

    }

    @Override
    public void initData() {
        getTeamPhoto();

    }

    private void getTeamPhoto() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        Log.d("iii", id);
        pos = intent.getIntExtra("pos",0);
        String url = UrlTools.DISCOVERY_TEAM_NUM_PHOTO_HEAD + id + UrlTools.DISCOVERY_TEAM_NUM_PHOTO_TAIL;
        Log.d("qqq", url);
        NetTool.getInstance().startRequest(url, TeamNumPhotoBean.class, new onHttpCallBack<TeamNumPhotoBean>() {
            @Override
            public void onSuccess(TeamNumPhotoBean response) {
                // data = response.getMembers();
                Log.d("aaaa", "data:" + data);
                adapter.setData(response.getMembers());

                adapter = new TeamPhotoAdapter(TeamSecondActivity.this);
                lRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
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







