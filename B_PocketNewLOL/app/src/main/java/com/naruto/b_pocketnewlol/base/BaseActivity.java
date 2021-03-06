package com.naruto.b_pocketnewlol.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by dllo on 16/12/19.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initView();
        initData();
    }
    // 设置布局的
    public abstract int setLayout();
    // 初始化组件
    public abstract void initView();
    // 初始化数据的方法
    public abstract void initData();

    public <T extends View> T bindView(int id){
        return (T)findViewById(id);
    }
}

