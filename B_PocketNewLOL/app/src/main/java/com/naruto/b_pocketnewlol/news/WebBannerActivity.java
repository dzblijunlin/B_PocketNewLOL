package com.naruto.b_pocketnewlol.news;


import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseActivity;

public class WebBannerActivity extends BaseActivity {

    private WebView webView;
    private ImageView imgBack;
    private ProgressBar bar;

    @Override
    public int setLayout() {
        return R.layout.activity_web_banner;
    }

    @Override
    public void initView() {
        webView = (WebView) findViewById(R.id.web_banner_acy_web);
        imgBack = (ImageView) findViewById(R.id.web_banner_acy_img_back);
        bar = (ProgressBar) findViewById(R.id.myPb);

    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        webView.getSettings().setBlockNetworkImage(false);
//        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100){
                    bar.setVisibility(View.INVISIBLE);
                }else {
                    if (View.INVISIBLE == bar.getVisibility()){
                        bar.setVisibility(View.VISIBLE);
                    }
                    bar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
