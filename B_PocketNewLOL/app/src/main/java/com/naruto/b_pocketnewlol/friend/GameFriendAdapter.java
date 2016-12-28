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

Created by Android_刘德强 on 16/12/23.
*/


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.naruto.b_pocketnewlol.R;

import java.util.ArrayList;

public class GameFriendAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<String> son;

    public GameFriendAdapter (Context context) {
        this.context = context;
    }

    public void setSon (ArrayList<String> son) {
        this.son = son;
        notifyDataSetChanged ();
    }

    @Override
    public int getGroupCount () {
        return 1;
    }

    @Override
    public int getChildrenCount (int i) {
        return son.size ();
    }

    @Override
    public Object getGroup (int i) {
        return 1;
    }

    @Override
    public Object getChild (int i, int i1) {
        return son.get (i1);
    }

    @Override
    public long getGroupId (int i) {
        return i;
    }

    @Override
    public long getChildId (int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds () {
        return false;
    }

    @Override
    public View getGroupView (int i, boolean b, View view, ViewGroup viewGroup) {
        ViewHolderFather holderFather=null;
        if (view==null){
            view=LayoutInflater.from (context).inflate (R.layout.item_game_friends,viewGroup,false);
            holderFather=new ViewHolderFather (view);
            view.setTag (holderFather);
        }else {
            holderFather= (ViewHolderFather) view.getTag();
        }
        holderFather.textView.setText ("游戏好友");
        holderFather.textViews.setText ("艾欧尼亚");
        return view;
    }

    @Override
    public View getChildView (int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if (view==null){
            view= LayoutInflater.from (context).inflate (R.layout.item_game_friend, viewGroup,false);
            holder=new ViewHolder (view);
            view.setTag (holder);
        }else {
            holder= (ViewHolder) view.getTag ();
        }
        holder.textView.setText (son.get (i1));
        return view;
    }

    @Override
    public boolean isChildSelectable (int i, int i1) {
        return true;
    }

    class ViewHolderFather{
        private TextView textView,textViews;
        public ViewHolderFather(View view){
            textView = (TextView) view.findViewById (R.id.tv_game);
            textViews = (TextView) view.findViewById (R.id.tv_regional);
        }
    }

    class ViewHolder{
        private TextView textView;
        public ViewHolder(View view){
            super();
            textView = (TextView) view.findViewById (R.id.tv_game_friend_name);
        }
    }
}
