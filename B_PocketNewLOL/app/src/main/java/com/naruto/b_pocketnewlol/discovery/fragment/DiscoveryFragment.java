package com.naruto.b_pocketnewlol.discovery.fragment;




import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseFragment;
import com.naruto.b_pocketnewlol.discovery.MyClickListener;
import com.naruto.b_pocketnewlol.discovery.activity.HeroSecondActivity;
import com.naruto.b_pocketnewlol.discovery.activity.NearSecondActivity;
import com.naruto.b_pocketnewlol.discovery.activity.PictureSecondActivity;
import com.naruto.b_pocketnewlol.discovery.activity.PlayerSecondActivity;
import com.naruto.b_pocketnewlol.discovery.activity.TeamSecondActivity;
import com.naruto.b_pocketnewlol.discovery.adapter.GameAdapter;
import com.naruto.b_pocketnewlol.discovery.adapter.TeamAdapter;
import com.naruto.b_pocketnewlol.discovery.bean.LogoBean;
import com.naruto.b_pocketnewlol.discovery.bean.TeamBean;
import com.naruto.b_pocketnewlol.entity.NetTool;
import com.naruto.b_pocketnewlol.entity.onHttpCallBack;
import com.naruto.b_pocketnewlol.tools.UrlTools;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 大嘴宝的任务
 */
public class DiscoveryFragment extends BaseFragment implements View.OnClickListener, MyClickListener {
    private RecyclerView rv;
    private ImageView heroIv,playerIv,nearIv,pkIv,barIv,timeIv,picIv,scanIv;
    private TextView heroTv,playerTv,nearTv,pkTv,barTv,timeTv,picTv;
    private List<LogoBean.ListBean> fatherData;
    private List<List<LogoBean.ListBean>> sonData;
    private ExpandableListView expandableListView;
    private String logoUrl;
    private LinearLayout heroLinearLayout,playerLinearLayout,nearLinearLayout,picLinearLayout;
    private TeamAdapter teamAdapter;
    private List<TeamBean.ClubsBean> data;

    @Override
    public int setLayout() {
        return R.layout.fragment_discovery;
    }

    @Override
    public void initView(View view) {
        rv = bindView(R.id.discovery_rv);
        heroIv = bindView(R.id.discovery_hero_iv);
        heroTv = bindView(R.id.discovery_hero_tv);
        playerIv = bindView(R.id.discovery_player_iv);
        playerTv = bindView(R.id.discovery_player_tv);
        nearIv = bindView(R.id.discovery_near_iv);
        nearTv = bindView(R.id.discovery_near_tv);
        pkIv = bindView(R.id.discovery_pk_iv);
        pkTv = bindView(R.id.discovery_pk_tv);
        barIv = bindView(R.id.discovery_bar_iv);
        barTv = bindView(R.id.discovery_bar_tv);
        expandableListView = bindView(R.id.expand_lv);
        timeIv = bindView(R.id.discovery_time_iv);
        timeTv = bindView(R.id.discovery_time_tv);
        picIv = bindView(R.id.discovery_picture_iv);
        picTv = bindView(R.id.discovery_picture_tv);
        heroLinearLayout = bindView(R.id.discovery_hero_ll);
        playerLinearLayout = bindView(R.id.discovery_player_ll);
        nearLinearLayout = bindView(R.id.discovery_near_ll);
        fatherData = new ArrayList<>();
        sonData = new ArrayList<>();
        teamAdapter = new TeamAdapter(getContext());
        scanIv = bindView(R.id.discovery_barcode_iv);
        picLinearLayout = bindView(R.id.discovery_picture_ll);
    }

    @Override
    public void initData() {
        getTeamData();
        getHeroData();
        getExpandLvData();
        getSecondIntent();
        teamAdapter.setMyClickListener(this);
        getScanData();


    }
// 扫码
    private void getScanData() {
        scanIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CaptureActivity.class);
                startActivityForResult(intent,0);
            }
        });
    }


    private void getSecondIntent() {
        heroLinearLayout.setOnClickListener(this);
        playerLinearLayout.setOnClickListener(this);
        nearLinearLayout.setOnClickListener(this);
        picLinearLayout.setOnClickListener(this);
    }

    private void getExpandLvData() {
        NetTool.getInstance().startRequest(logoUrl, LogoBean.class, new onHttpCallBack<LogoBean>() {
            @Override
            public void onSuccess(LogoBean response) {

                fatherData = response.getList();
                List<LogoBean.ListBean> data = response.getList();
                sonData.add(data);
                GameAdapter adapter = new GameAdapter(getContext());
                adapter.setFatherData(fatherData);
                adapter.setSonData(sonData);
                expandableListView.setAdapter(adapter);
//                expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//                    @Override
//                    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
//                        Toast.makeText(getContext(), "hahaha", Toast.LENGTH_SHORT).show();
//                        return false;
//                    }
//                });
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    private void getHeroData() {
        logoUrl = UrlTools.DISCOVERY_LOGO;
        NetTool.getInstance().startRequest(logoUrl, LogoBean.class, new onHttpCallBack<LogoBean>() {
            @Override
            public void onSuccess(LogoBean response) {
                Glide.with(getContext()).load(response.getList().get(0).getImage_url_big()).into(playerIv);
                Glide.with(getContext()).load(response.getList().get(15).getImage_url_big()).into(heroIv);
                Glide.with(getContext()).load(response.getList().get(17).getImage_url_big()).into(nearIv);
                Glide.with(getContext()).load(response.getList().get(9).getImage_url_big()).into(pkIv);
                Glide.with(getContext()).load(response.getList().get(1).getImage_url_big()).into(barIv);
                Glide.with(getContext()).load(response.getList().get(2).getImage_url_big()).into(picIv);
                Glide.with(getContext()).load(response.getList().get(11).getImage_url_big()).into(timeIv);

                playerTv.setText(response.getList().get(0).getTitle());
                heroTv.setText(response.getList().get(15).getTitle());
                nearTv.setText(response.getList().get(17).getTitle());
                pkTv.setText(response.getList().get(9).getTitle());
                barTv.setText(response.getList().get(1).getTitle());
                picTv.setText(response.getList().get(2).getTitle());
                timeTv.setText(response.getList().get(11).getTitle());
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }

    private void getTeamData() {
        String url = UrlTools.DISCOVERY_TEAM;
        NetTool.getInstance().startRequest(url, TeamBean.class, new onHttpCallBack<TeamBean>() {
            @Override
            public void onSuccess(TeamBean response) {
                data = response.getClubs();
                teamAdapter.setData(data);
                rv.setAdapter(teamAdapter);
                LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
                rv.setLayoutManager(manager);

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.discovery_hero_ll:
                Intent intent = new Intent(getContext(), HeroSecondActivity.class);
                startActivity(intent);
                break;
            case R.id.discovery_player_ll:
                Intent intent1 = new Intent(getContext(), PlayerSecondActivity.class);
                startActivity(intent1);
                break;
            case R.id.discovery_near_ll:
                Intent intent2 = new Intent(getContext(), NearSecondActivity.class);
                startActivity(intent2);
                break;
            case R.id.discovery_picture_ll:
                Intent intent3 = new Intent(getContext(), PictureSecondActivity.class);
                startActivity(intent3);
                break;
        }
    }

    @Override
    public void MyListener(int pos,String id) {
        Intent intent = new Intent(getContext(), TeamSecondActivity.class);
        intent.putExtra("pos",pos);
        intent.putExtra("id",id);
        intent.putExtra("photo",data.get(pos).getIconUrl());
        intent.putExtra("name",data.get(pos).getName());
        startActivity(intent);
    }
}
