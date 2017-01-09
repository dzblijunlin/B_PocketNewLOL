package com.naruto.b_pocketnewlol.discovery.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseFragment;
import com.naruto.b_pocketnewlol.discovery.adapter.PictureClassLvAdapter;
import com.naruto.b_pocketnewlol.discovery.bean.PictureClassBean;
import com.naruto.b_pocketnewlol.entity.NetTool;
import com.naruto.b_pocketnewlol.entity.onHttpCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureClassifyFragment extends BaseFragment {
    private GridView gv;
    private List<PictureClassBean.CategoriesBean> data;
    private PictureClassLvAdapter adapter;



    @Override
    public int setLayout() {
        return R.layout.fragment_picture_classify;
    }

    @Override
    public void initView(View view) {
        gv = bindView(R.id.gv_picture_class);
        data = new ArrayList<>();
        adapter = new PictureClassLvAdapter(getContext());
    }

    @Override
    public void initData() {
        String url = "http://qt.qq.com/php_cgi/lol_goods/varcache_kind_index.php?page=0&num=20&plat=android&version=9713";
        NetTool.getInstance().startRequest(url, PictureClassBean.class, new onHttpCallBack<PictureClassBean>() {
            @Override
            public void onSuccess(PictureClassBean response) {
                data = response.getCategories();
                adapter.setData(data);
                gv.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

}
