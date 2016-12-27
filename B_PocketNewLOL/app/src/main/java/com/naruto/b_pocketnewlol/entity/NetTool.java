package com.naruto.b_pocketnewlol.entity;

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

Created by Android_刘德强 on 16/12/20.
*/


public class NetTool implements NetInterface {

    private static NetTool ourInstance;
    private NetInterface netInterface;

    public static NetTool getInstance(){
        if(ourInstance==null){
            synchronized (NetTool.class){
                if (ourInstance==null){
                    ourInstance=new NetTool ();
                }
            }
        }
        return ourInstance;
    }

    private NetTool(){
        netInterface=new OkHttpUtil ();
    }

    @Override
    public void startRequest (String url, onHttpCallBack<String> callBack) {
        netInterface.startRequest (url,callBack);
    }

    @Override
    public <T> void startRequest (String url, Class<T> tClass, onHttpCallBack<T> callBack) {
        netInterface.startRequest (url,tClass,callBack);
    }
}
