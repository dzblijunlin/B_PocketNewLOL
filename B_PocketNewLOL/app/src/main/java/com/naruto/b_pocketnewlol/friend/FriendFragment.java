package com.naruto.b_pocketnewlol.friend;

/*
                  _ooOoo_
                 o8888888o
                 88" . "88
                 (| -_- |)
                 O\  =  /O
              ____/`---'\____
            .'  \\|     |//  `.
           /  \\|||  :  |||//  \
          /  _||||| -:- |||||-  \
          |   | \\\  -  /// |   |
          | \_|  ''\---/''  |   |
          \  .-\__  `-`  ___/-. /
        ___`. .'  /--.--\  `. . __
     ."" '<  `.___\_<|>_/___.'  >'"".
    | | :  `- \`.;`\ _ /`;.`/ - ` : | |
    \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                  `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        佛祖保佑       永无BUG

Created by Android_刘德强 on 16/12/19.
*/

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseFragment;

import java.util.ArrayList;

public class FriendFragment extends BaseFragment implements OnClickListener {

    private ViewPager viewPager;
    private ArrayList<Fragment> data;
    private TabLayout tabLayout;
    private FriendAdapter adapter;
    private PopupWindow popupWindow;
    private ImageView imageView;
    int golden = 0xD2BE8C;
    int yellows = 0xE1D8C7;

    @Override
    public int setLayout () {
        return R.layout.fragment_friend;
    }

    @Override
    public void initView (View view) {
        viewPager = (ViewPager) view.findViewById (R.id.vp_friend);
        tabLayout = (TabLayout) view.findViewById (R.id.tl_friend);
        data = new ArrayList<> ();
        imageView = (ImageView) view.findViewById (R.id.iv_add_friend);
        imageView.setOnClickListener (this);
    }

    @Override
    public void initData () {
        settabLayout ();//Tablayout绑定Fragment 适配器等操作
        popupWindow=new PopupWindow (getContext ());
        popupWindow.setHeight (LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth (LayoutParams.WRAP_CONTENT);
        View view= LayoutInflater.from (getContext ()).inflate (R.layout.item_friend_session,null);
        popupWindow.setContentView (view);
        popupWindow.setOutsideTouchable (true);
        popupWindow.setBackgroundDrawable (getResources ().getDrawable (R.mipmap.add_friend_popup_bkg));

    }

    private void settabLayout () {
        data.add (new FriendsFragment ());
        data.add (new MessageFragment ());
        adapter = new FriendAdapter (getChildFragmentManager (), data);
        viewPager.setAdapter (adapter);
        tabLayout.setupWithViewPager (viewPager);
        tabLayout.setTabTextColors (Color.BLACK, Color.WHITE);
        tabLayout.setSelectedTabIndicatorColor (Color.WHITE);
        tabLayout.getTabAt (0).setText ("好友");
        tabLayout.getTabAt (1).setText ("消息");
    }

    @Override
    public void onClick (View view) {
        switch (view.getId ()){
            case R.id.iv_add_friend:
                popupWindow.showAsDropDown (imageView);//点击按钮显示pop
                break;
        }

    }
}
