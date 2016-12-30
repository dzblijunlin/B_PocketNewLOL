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

Created by Android_刘德强 on 16/12/21.
*/


import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseFragment;
import com.naruto.b_pocketnewlol.discovery.MyExpandableListView;

import java.util.ArrayList;

//好友页面
public class FriendsFragment extends BaseFragment implements OnClickListener {

    private LinearLayout linearLayout;
    private RelativeLayout relativeLayout;
    private ExpandableListView expandableListView;
    private GameFriendAdapter adapter;
    private ArrayList<String> son;

    @Override
    public int setLayout () {
        return R.layout.fragment_friends;
    }

    @Override
    public void initView (View view) {
        linearLayout = (LinearLayout) view.findViewById (R.id.ll_search_friend);
        linearLayout.setOnClickListener (this);
        relativeLayout = (RelativeLayout) view.findViewById (R.id.rl_friend_dynamic);
        relativeLayout.setOnClickListener (this);
        expandableListView = (MyExpandableListView) view.findViewById (R.id.el_game_friend);
        adapter=new GameFriendAdapter (getContext ());
        son=new ArrayList<> ();

    }

    @Override
    public void initData () {
        for (int i = 0; i < 15; i++) {
            son.add ("好友  "+ i);
            adapter.setSon (son);
        }

        expandableListView.setAdapter (adapter);

    }

    @Override
    public void onClick (View view) {
        switch (view.getId ()){
            case R.id.ll_search_friend:
                Intent intent=new Intent (getActivity (),SearchFriendActivity.class);
                startActivity (intent);
                break;
            case R.id.rl_friend_dynamic:
                Intent intent1=new Intent (getActivity (),FriendDynamicActivity.class);
                startActivity (intent1);
        }
    }
}
