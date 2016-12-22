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

Created by Android_刘德强 on 16/12/22.
*/


import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseActivity;

//好友动态
public class FriendDynamicActivity extends BaseActivity implements OnClickListener {

    private ImageView friendPublish;
    private ImageView friendBack;

    @Override
    public int setLayout () {
        return R.layout.activity_frienddynamic;
    }

    @Override
    public void initView () {
        friendPublish = (ImageView) findViewById (R.id.iv_friend_publish);
        friendPublish.setOnClickListener (this);
        friendBack = (ImageView) findViewById (R.id.iv_friend_back);
        friendBack.setOnClickListener (this);

    }

    @Override
    public void initData () {

    }

    @Override
    public void onClick (View view) {
        switch (view.getId ()){
            case R.id.iv_friend_publish:

                break;
            case R.id.iv_friend_back:
                finish ();
                break;
        }
    }
}
