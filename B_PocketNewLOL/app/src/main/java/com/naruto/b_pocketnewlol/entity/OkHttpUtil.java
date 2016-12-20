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


import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtil implements NetInterface {

    private OkHttpClient client;
    //这样定义的handler对象无论在哪里创建的,都属于主线程
    private Handler handler=
            new Handler(Looper.getMainLooper ());
    private Gson gson;

    public OkHttpUtil () {
        super();
        gson=new Gson ();
        //设置缓存位置.获取系统的SD卡
        File path = Environment.getExternalStorageDirectory ();
        //初始化okHttp
        client=new OkHttpClient.Builder ()
                //设置缓存位置,以及缓存大小
                .cache (new Cache (path,10*1024*1024))
                //超时时间为5秒
                .connectTimeout (5, TimeUnit.SECONDS)
                .build ();
    }

    @Override
    public void startRequest (String url, final onHttpCallBack<String> callBack) {
        Request request=new Request.Builder ().url (url).build ();
        client.newCall (request).enqueue (new Callback () {
            //失败的回调
            @Override
            public void onFailure (Call call, final IOException e) {
                handler.post (new Runnable () {
                    @Override
                    public void run () {
                        callBack.onError (e);
                    }
                });

            }

            //成功的回调
            @Override
            public void onResponse (Call call, final Response response) throws IOException {
                final String result= response.body ().string ();
                //将任务传送到主线程
                handler.post (new Runnable () {
                    @Override
                    public void run () {
                        callBack.onSuccess (result);
                    }
                });
            }
        });
    }



    @Override
    public <T> void startRequest (String url, final Class<T> tClass, final onHttpCallBack<T> callBack) {
        Request request=new Request.Builder ().url (url).build ();
        client.newCall (request).enqueue (new Callback () {
            @Override
            public void onFailure (Call call, final IOException e) {
                handler.post (new Runnable () {
                    @Override
                    public void run () {
                        callBack.onError (e);
                    }
                });
            }

            @Override
            public void onResponse (Call call, Response response) throws IOException {
                String str =response.body ().string ();
                Log.d ("OkHttpUtil", str);
                final T result= gson.fromJson (str,tClass);
                Log.d ("OkHttpUtil", "result:" + result);
                handler.post (new Runnable () {
                    @Override
                    public void run () {
                        callBack.onSuccess (result);
                    }
                });
            }
        });
    }
}

