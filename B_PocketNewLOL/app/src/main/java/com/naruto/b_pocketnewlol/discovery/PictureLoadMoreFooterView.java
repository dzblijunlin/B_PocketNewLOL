package com.naruto.b_pocketnewlol.discovery;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.aspsine.swipetoloadlayout.SwipeLoadMoreTrigger;
import com.aspsine.swipetoloadlayout.SwipeTrigger;
import com.naruto.b_pocketnewlol.R;

/**
 * Created by dllo on 16/11/30.
 */

public class PictureLoadMoreFooterView extends ImageView implements SwipeTrigger, SwipeLoadMoreTrigger {


    public PictureLoadMoreFooterView(Context context) {
        super(context);
    }

    public PictureLoadMoreFooterView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onLoadMore() {
        this.setImageResource(R.drawable.frame_anim);
        AnimationDrawable animationDrawable = (AnimationDrawable) this.getDrawable();
        animationDrawable.start();
    }

    @Override
    public void onPrepare() {

    }

    @Override
    public void onMove(int yScrolled, boolean isComplete, boolean automatic) {
        if (!isComplete) {
            if (yScrolled <= -getHeight()) {
                setImageResource(R.mipmap.teemo_1);
            } else {
                setImageResource(R.mipmap.teemo_8);
            }
        } else {

        }
    }

    @Override
    public void onRelease() {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onReset() {

    }
}
