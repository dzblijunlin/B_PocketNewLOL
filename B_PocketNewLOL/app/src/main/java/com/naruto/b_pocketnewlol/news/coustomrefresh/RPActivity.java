package com.naruto.b_pocketnewlol.news.coustomrefresh;


import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.google.gson.Gson;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseActivity;
import com.naruto.b_pocketnewlol.tools.UrlTools;

public class RPActivity extends BaseActivity implements OnRefreshListener, OnLoadMoreListener {

    private SwipeToLoadLayout swipeToLoadLayout;
    private ListView lv;
    private KnowledgeAdapter adapter;
    private int i = 2;
    private String newUrl;
    private KnowledgeBean detail;

    @Override
    public int setLayout() {
        return R.layout.activity_rp;
    }

    @Override
    public void initView() {

        swipeToLoadLayout = (SwipeToLoadLayout) findViewById(R.id.swipeToLoadLayout);
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);

        lv = (ListView) findViewById(R.id.swipe_target);
        adapter = new KnowledgeAdapter();
        lv.setAdapter(adapter);
        getNetData();

    }

    @Override
    public void initData() {
    }

    private void getNetData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(UrlTools.KNOWLEDGE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                detail = gson.fromJson(response,KnowledgeBean.class);
                adapter.setBean(detail);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

    @Override
    public void onRefresh() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(false);
                getNetData();
            }

        }, 2000);
    }

    @Override
    public void onLoadMore() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setLoadingMore(false);
                newUrl = UrlTools.KNOWLEDGE_HEAD_URL + i + UrlTools.KNOWLEDGE_FOOT_URL;
                getData();
                i++;
            }
        }, 2000);
    }

    private void getData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(newUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                detail = gson.fromJson(response,KnowledgeBean.class);
                adapter.addMore(detail);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

}
