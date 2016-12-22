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


import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseActivity;

public class SearchFriendActivity extends BaseActivity implements OnClickListener {
    private TextView textView;

    @Override
    public int setLayout () {
        return R.layout.activity_searchfriend;
    }

    @Override
    public void initView () {
        textView = (TextView) findViewById (R.id.tv_back);
        textView.setOnClickListener (this);

    }

    @Override
    public void initData () {

    }

    @Override
    public void onClick (View view) {
        switch (view.getId ()){
            case R.id.tv_back:
                finish ();
                break;
        }
    }
}
