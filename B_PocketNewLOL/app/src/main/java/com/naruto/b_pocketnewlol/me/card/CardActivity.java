package com.naruto.b_pocketnewlol.me.card;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mcxtzhang.commonadapter.rv.CommonAdapter;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
import com.mcxtzhang.commonadapter.rv.ViewHolder;
import com.mcxtzhang.layoutmanager.swipecard.CardConfig;
import com.mcxtzhang.layoutmanager.swipecard.OverLayCardLayoutManager;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseActivity;
import com.naruto.b_pocketnewlol.entity.NetTool;
import com.naruto.b_pocketnewlol.entity.onHttpCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * 看这里,很强势!
 * Created by DgPeng on 16/12/28.
 */

public class CardActivity extends BaseActivity {

    RecyclerView rv;
    CommonAdapter<MeCardBean.DataBean.ListBean> adapter;
    List<MeCardBean.DataBean.ListBean> datas;
    private String url = "http://c.open.163.com/mob/classBreak/homeList.do?queryType=1,2,3";
    @Override
    public int setLayout() {
        return R.layout.activity_card;
    }

    @Override
    public void initView() {

        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new OverLayCardLayoutManager());
        datas = new ArrayList<>();
    }

    @Override
    public void initData() {

        getUrlData();
    }

    private void getUrlData() {
        NetTool.getInstance().startRequest(url, MeCardBean.class, new onHttpCallBack<MeCardBean>() {
            @Override
            public void onSuccess(MeCardBean response) {
                datas = response.getData().getList();
                getData();
            }

            @Override
            public void onError(Throwable e) {

            }
        });

        // 探探上下话是不能删除的,所以只能传入做偶遇即可
        final ItemTouchHelper.Callback callback = new TanTanCallback(rv, adapter, datas);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(rv);
    }

    private void getData() {

        rv.setAdapter(adapter = new CommonAdapter<MeCardBean.DataBean.ListBean>(this, datas, R.layout.item_swipe_card) {
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
            public void convert(ViewHolder viewHolder, MeCardBean.DataBean.ListBean listBean) {
                Log.d(TAG, "aaa");

                viewHolder.setText(R.id.tv_title, listBean.getTitle());
                Log.d(TAG, listBean.getTitle());
                viewHolder.setText(R.id.tv_shareDescription, listBean.getShareDescription());
                viewHolder.setText(R.id.tv_viewCount, listBean.getViewCount() + "");
                Glide.with(CardActivity.this).load(listBean.getImageUrl()).into((ImageView) viewHolder.getView(R.id.iv_imageUrl));
            }

        });
        CardConfig.initConfig(this);
    }
}
