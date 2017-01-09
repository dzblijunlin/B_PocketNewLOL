package com.naruto.b_pocketnewlol.discovery.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;

import com.naruto.b_pocketnewlol.R;
import com.naruto.b_pocketnewlol.base.BaseActivity;
import com.naruto.b_pocketnewlol.main.MainActivity;

/**
 * Created by 大嘴宝 on 17/1/6.
 */

public class WelcomeActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv;
    private CountDownTimer countDownTimer;

    @Override
    public int setLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView() {
    iv = bindView(R.id.iv_welcome);
        iv.setOnClickListener(this);
    }

    @Override
    public void initData() {
        setCountDownTimer();
        countDownTimer.start();
    }

    private void setCountDownTimer() {
        countDownTimer = new CountDownTimer(5000,1000) {
            int a = 5;
            @Override
            public void onTick(long millisUntilFinished) {
                --a;
                if (a == 1){
                    onFinish();
                }
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                countDownTimer.cancel();
                startActivity(intent);
                finish();
            }
        };

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        countDownTimer.cancel();
        finish();
    }
}
