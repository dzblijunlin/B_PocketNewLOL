package com.naruto.b_pocketnewlol.discovery.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseActivity;
import com.naruto.b_pocketnewlol.discovery.adapter.TeamPhotoAdapter;
import com.naruto.b_pocketnewlol.discovery.bean.TeamNumPhotoBean;

import java.util.ArrayList;
import java.util.List;

public class TeamSecondActivity extends BaseActivity {

    private List<TeamNumPhotoBean.MembersBean> data;
    private LRecyclerView lRecyclerView;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private TeamPhotoAdapter photoAdapter;
    @Override
    public int setLayout() {
        return R.layout.activity_team_second;
    }

    @Override
    public void initView() {
        photoAdapter = new TeamPhotoAdapter(this);
        lRecyclerView = bindView(R.id.discovery_team_num_rv);
        data = new ArrayList<>();
    }

    @Override
    public void initData() {

    }
}
