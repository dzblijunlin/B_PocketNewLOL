package com.naruto.b_pocketnewlol.news;



import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseFragment;
import com.naruto.b_pocketnewlol.entity.NetTool;
import com.naruto.b_pocketnewlol.entity.onHttpCallBack;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExplainFragment extends BaseFragment {

    private ExplainAdapter adapter;
    private RecyclerView rv;

    private List<ZBBean.MsgBean> data;
    private List<ZDBean.MsgBean.ResultBean> dataMore;

    @Override
    public int setLayout() {
        return R.layout.fragment_explain;
    }

    @Override
    public void initView(View view) {
        rv = (RecyclerView) view.findViewById(R.id.explain_rv);
        adapter = new ExplainAdapter(getContext());
    }

    @Override
    public void initData() {
        StartUrl("http://lol.qq.com/web201310/js/videodata/LOL_APP_AUTHOR_LIST.js");
        StartUrls("http://apps.game.qq.com/lol/act/website2013/video.php?page=1&pagesize=10&p4=9999&r1=1&source=lolapp");
    }

    private void StartUrl(String url) {
        NetTool.getInstance().startRequest(url, ZBBean.class, new onHttpCallBack<ZBBean>() {
            @Override
            public void onSuccess(ZBBean response) {
                data = response.getMsg();
                adapter.setData(data);
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(getContext()));
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    private void StartUrls(String url) {
        NetTool.getInstance().startRequest(url, ZDBean.class, new onHttpCallBack<ZDBean>() {
            @Override
            public void onSuccess(ZDBean response) {
                dataMore = response.getMsg().getResult();
                adapter.setDataMore(dataMore);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

}
