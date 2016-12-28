package com.naruto.b_pocketnewlol.discovery.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
    //    private LRecyclerView rv;
//    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private RecyclerView rv;
    private TeamPhotoAdapter adapter;
    private String id;
    private int pos;
    private TextView titleTv, nameTv;
    private ImageView nameIv,backIv;

    @Override
    public int setLayout() {
        return R.layout.activity_team_second;
    }

    @Override
    public void initView() {
        rv = bindView(R.id.discovery_team_num_rv);
        data = new ArrayList<>();
//        rv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        adapter = new TeamPhotoAdapter(TeamSecondActivity.this);
        titleTv = bindView(R.id.discovery_team_title_tv);
        nameTv = bindView(R.id.discovery_team_name_tv);
        nameIv = bindView(R.id.discovery_team_photo_iv);
        backIv = bindView(R.id.discovery_team_back_iv);
    }

    @Override
    public void initData() {
        getTeamPhoto();
        getTeamName();
        getBack();
    }

    private void getBack() {
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getTeamName() {
        Intent intent = getIntent();
        String photo = intent.getStringExtra("photo");
        String name = intent.getStringExtra("name");
        Glide.with(this).load(photo).into(nameIv);
        titleTv.setText(name);
        nameTv.setText(name);
    }

    private void getTeamPhoto() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        pos = intent.getIntExtra("pos", 0);
        String url = UrlTools.DISCOVERY_TEAM_NUM_PHOTO_HEAD + id + UrlTools.DISCOVERY_TEAM_NUM_PHOTO_TAIL;

        NetTool.getInstance().startRequest(url, TeamNumPhotoBean.class, new onHttpCallBack<TeamNumPhotoBean>() {
            @Override
            public void onSuccess(TeamNumPhotoBean response) {
                data = response.getMembers();
                adapter.setData(data);
                rv.setAdapter(adapter);
                LinearLayoutManager manager = new LinearLayoutManager(TeamSecondActivity.this, LinearLayoutManager.HORIZONTAL, false);
                rv.setLayoutManager(manager);


            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}







