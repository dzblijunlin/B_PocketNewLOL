package com.naruto.b_pocketnewlol.discovery.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;

import com.mcxtzhang.commonadapter.rv.ViewHolder;
import com.mcxtzhang.layoutmanager.swipecard.CardConfig;
import com.mcxtzhang.layoutmanager.swipecard.OverLayCardLayoutManager;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseActivity;
import com.naruto.b_pocketnewlol.discovery.adapter.TeamPhotoAdapter;
import com.naruto.b_pocketnewlol.discovery.bean.TeamCallback;
import com.naruto.b_pocketnewlol.discovery.bean.TeamCardBean;
import com.naruto.b_pocketnewlol.discovery.bean.TeamNumPhotoBean;
import com.naruto.b_pocketnewlol.entity.NetTool;
import com.naruto.b_pocketnewlol.entity.onHttpCallBack;
import com.naruto.b_pocketnewlol.me.card.CardActivity;
import com.naruto.b_pocketnewlol.me.card.MeCardBean;
import com.naruto.b_pocketnewlol.me.card.TanTanCallback;
import com.naruto.b_pocketnewlol.tools.UrlTools;
import com.mcxtzhang.commonadapter.rv.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

public class TeamSecondActivity extends BaseActivity {

    private List<TeamNumPhotoBean.MembersBean> data;
    private RecyclerView rv;
    private TeamPhotoAdapter adapter;
    private String id;
    private int pos;
    private TextView titleTv, nameTv;
    private ImageView nameIv, backIv;
    // 卡片
    RecyclerView cardRv;
    CommonAdapter<TeamCardBean.DataBean.ListBean> cardAdapter;
    List<TeamCardBean.DataBean.ListBean> cardData;
    private String url = "http://c.open.163.com/mob/classBreak/homeList.do?queryType=1,2,3";

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
        // 卡片
        cardRv = bindView(R.id.discovery_team_rv);
        cardData = new ArrayList<>();
        cardRv.setLayoutManager(new OverLayCardLayoutManager());
    }

    @Override
    public void initData() {
        getTeamPhoto();
        getTeamName();
        getBack();
        getUrlData();
    }

    // 解析卡片
    private void getUrlData() {
        NetTool.getInstance().startRequest(url, TeamCardBean.class, new onHttpCallBack<TeamCardBean>() {
            @Override
            public void onSuccess(TeamCardBean response) {
                cardData = response.getData().getList();
                getData();
            }



            @Override
            public void onError(Throwable e) {

            }
        });
        // 探探上下话是不能删除的,所以只能传入做偶遇即可
        final ItemTouchHelper.Callback callback = new TeamCallback(cardRv, cardAdapter, cardData);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(cardRv);
    }

    private void getData() {

        cardRv.setAdapter(cardAdapter = new CommonAdapter<TeamCardBean.DataBean.ListBean>(this, cardData, R.layout.item_team_card) {
            public static final String TAG = "zxt/Adapter";

            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                Log.d(TAG, "onCreateViewHolder() called with: parent = [" + parent + "], viewType = [" + viewType + "]");
                return super.onCreateViewHolder(parent, viewType);
            }

            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                Log.d(TAG, "onBindViewHolder() called with: holder = [" + holder + "], position = [" + position + "]");
                super.onBindViewHolder(holder, position);
            }

            @Override
            public void convert(ViewHolder viewHolder, TeamCardBean.DataBean.ListBean listBean) {
                viewHolder.setText(R.id.tv_title, listBean.getTitle());
                Log.d(TAG, listBean.getTitle());
                viewHolder.setText(R.id.tv_shareDescription, listBean.getShareDescription());
                viewHolder.setText(R.id.tv_viewCount, listBean.getViewCount() + "");
                Glide.with(TeamSecondActivity.this).load(listBean.getImageUrl()).into((ImageView) viewHolder.getView(R.id.iv_imageUrl));
            }


        });
        CardConfig.initConfig(this);
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







