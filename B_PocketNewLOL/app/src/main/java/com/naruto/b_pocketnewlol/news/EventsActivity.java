package com.naruto.b_pocketnewlol.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseActivity;
import com.naruto.b_pocketnewlol.entity.NetTool;
import com.naruto.b_pocketnewlol.entity.onHttpCallBack;
import com.naruto.b_pocketnewlol.news.coustomrefresh.RPActivity;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import java.util.List;

public class EventsActivity extends BaseActivity {

    private List<EventBean.ListBean> data;

    private EventAdapter adapter;
    private LRecyclerView recyclerView;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private int i = 0;
    private ImageView scan;
    private TextView tvFind;

    private ImageView img;
    private ImageView imgOne, imgTwo, imgThree, imgFour;
    private TextView tvOne, tvTwo, tvThree, tvFour;

    @Override
    public int setLayout() {
        return R.layout.activity_events;
    }

    @Override
    public void initView() {
        adapter = new EventAdapter(this);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
        recyclerView = (LRecyclerView) findViewById(R.id.ev_rl);

        scan = (ImageView) findViewById(R.id.scan);
        tvFind = (TextView) findViewById(R.id.event_tv);
    }

    @Override
    public void initData() {
        StartUrl(UrlAll(0));
        recyclerView.setAdapter(lRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        View view = LayoutInflater.from(this).inflate(R.layout.top_events,null);
        img = (ImageView) view.findViewById(R.id.event_top_img);
        imgOne = (ImageView) view.findViewById(R.id.event_top_img1);
        imgTwo = (ImageView) view.findViewById(R.id.event_top_img2);
        imgThree = (ImageView) view.findViewById(R.id.event_top_img3);
        imgFour = (ImageView) view.findViewById(R.id.event_top_img4);
        tvOne = (TextView) view.findViewById(R.id.event_top_tv1);
        tvTwo = (TextView) view.findViewById(R.id.event_top_tv2);
        tvThree = (TextView) view.findViewById(R.id.event_top_tv3);
        tvFour = (TextView) view.findViewById(R.id.event_top_tv4);
        lRecyclerViewAdapter.addHeaderView(view);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventsActivity.this, RPActivity.class);
                startActivity(intent);
            }
        });

        StartTop("http://qt.qq.com/php_cgi/lol_mobile/gamecenter/varcache_gamecenterindex.php?plat=android&version=9713");

        recyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView.refreshComplete();
            }
        });

        recyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                i = i + 1;
                StartUrl(UrlAll(i));
            }
        });



        /////////////////////////扫码
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventsActivity.this,CaptureActivity.class);
                startActivityForResult(intent,0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            tvFind.setText(result);
        }
    }

    private void StartTop(String url) {
        NetTool.getInstance().startRequest(url, EventTopBean.class, new onHttpCallBack<EventTopBean>() {
            @Override
            public void onSuccess(EventTopBean response) {
                Glide.with(EventsActivity.this).load(response.getGallery_features().get(0).getIconUrl()).into(img);
                Glide.with(EventsActivity.this).load(response.getNormal_features().get(0).getIconUrl()).into(imgOne);
                Glide.with(EventsActivity.this).load(response.getNormal_features().get(1).getIconUrl()).into(imgTwo);
                Glide.with(EventsActivity.this).load(response.getNormal_features().get(2).getIconUrl()).into(imgThree);
                Glide.with(EventsActivity.this).load(response.getNormal_features().get(3).getIconUrl()).into(imgFour);
                tvOne.setText(response.getNormal_features().get(0).getName());
                tvTwo.setText(response.getNormal_features().get(1).getName());
                tvThree.setText(response.getNormal_features().get(2).getName());
                tvFour.setText(response.getNormal_features().get(3).getName());
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    private void StartUrl(String url) {
        NetTool.getInstance().startRequest(url, EventBean.class, new onHttpCallBack<EventBean>() {
            @Override
            public void onSuccess(EventBean response) {
                data = response.getList();
                adapter.setData(data);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public String UrlAll(int i){
        return "http://qt.qq.com/php_cgi/news/php/varcache_getnews.php?id=73&page=" + i + "&plat=android&version=9713";
    }

}
