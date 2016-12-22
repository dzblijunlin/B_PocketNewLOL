package com.naruto.b_pocketnewlol.discovery;




import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseFragment;
import com.naruto.b_pocketnewlol.discovery.adapter.TeamAdapter;
import com.naruto.b_pocketnewlol.discovery.bean.LogoBean;
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
    private ImageView heroIv,playerIv,nearIv,pkIv,barIv;
    private TextView heroTv,playerTv,nearTv,pkTv,barTv;


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
    }

    @Override
    public void initData() {
        getTeamData();
        getHeroData();
    }

    private void getHeroData() {
        String logoUrl = UrlTools.DISCOVERY_LOGO;
        NetTool.getInstance().startRequest(logoUrl, LogoBean.class, new onHttpCallBack<LogoBean>() {
            @Override
            public void onSuccess(LogoBean response) {
                Glide.with(getContext()).load(response.getList().get(0).getImage_url_big()).into(playerIv);
                Glide.with(getContext()).load(response.getList().get(15).getImage_url_big()).into(heroIv);
                Glide.with(getContext()).load(response.getList().get(17).getImage_url_big()).into(nearIv);
                Glide.with(getContext()).load(response.getList().get(9).getImage_url_big()).into(pkIv);
                Glide.with(getContext()).load(response.getList().get(1).getImage_url_big()).into(barIv);
                playerTv.setText(response.getList().get(0).getTitle());
                heroTv.setText(response.getList().get(15).getTitle());
                nearTv.setText(response.getList().get(17).getTitle());
                pkTv.setText(response.getList().get(9).getTitle());
                barTv.setText(response.getList().get(1).getTitle());
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
