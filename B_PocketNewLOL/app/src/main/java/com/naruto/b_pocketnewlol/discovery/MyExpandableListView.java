package com.naruto.b_pocketnewlol.discovery;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

/**
 * Created by 大嘴宝 on 16/12/22.
 */

public class MyExpandableListView extends ExpandableListView{


    public MyExpandableListView(Context context) {
        super(context);
    }

    public MyExpandableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyExpandableListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    /**
     * 重写该方法，达到使ListView适应ScrollView的效果
     */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);//重新计算listview高度
        super.onMeasure(widthMeasureSpec, expandSpec);
    }


}
