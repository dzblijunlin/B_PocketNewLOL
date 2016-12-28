package com.naruto.b_pocketnewlol.discovery.bean;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mcxtzhang.layoutmanager.swipecard.RenRenCallback;

import java.util.List;

import static com.mcxtzhang.layoutmanager.swipecard.CardConfig.MAX_SHOW_COUNT;
import static com.mcxtzhang.layoutmanager.swipecard.CardConfig.SCALE_GAP;
import static com.mcxtzhang.layoutmanager.swipecard.CardConfig.TRANS_Y_GAP;

/**
 * 看这里,很强势!
 * Created by DgPeng on 16/12/20.
 */

public class TeamCallback extends RenRenCallback {
    private static final int MAX_ROTATION = 15;
    public TeamCallback(RecyclerView rv, RecyclerView.Adapter adapter, List datas) {
        super(rv, adapter, datas);
    }

    public TeamCallback(int dragDirs, int swipeDirs, RecyclerView rv, RecyclerView.Adapter adapter, List datas) {
        super(dragDirs, swipeDirs, rv, adapter, datas);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
       // super.onSwiped(viewHolder, direction);
        // 如果不需要循环删除
//        Object remove = mDatas.remove(viewHolder.getAdapterPosition());
//        mAdapter.notifyDataSetChanged();

        // 探探只是第一层加了 rotate & alpha的操作
        // 对rotate  进行复位
        viewHolder.itemView.setRotation(0);
        // 自己感受一下吧 Alpha
//        if (viewHolder instanceof ViewHolder){
//            ViewHolder holder = (ViewHolder) viewHolder;
//            holder.setAlpha(R.id.iv_love,0);
//            holder.setAlpha(R.id.iv_del,0);
//
//        }
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        double swipValue = Math.sqrt(dX * dY + dY * dY);
        double fraction = swipValue / getThreshold(viewHolder);
        // 边界修正 最大为1
        if (fraction > 1){
            fraction = 1;
        }
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = recyclerView.getChildAt(i);
            // 第几层,举例子,count = 7,最后一个TopView (6) 是第0层,
            int level = childCount - i -1;
            if (level > 0){
                child.setScaleX((float) (1 - SCALE_GAP * level + fraction * SCALE_GAP));
                if (level < MAX_SHOW_COUNT - 1){
                    child.setScaleY((float) (1-SCALE_GAP * level + fraction * SCALE_GAP));
                    child.setTranslationY((float) (TRANS_Y_GAP * level - fraction * TRANS_Y_GAP));
                }else {

                }
            }else {
                // 探探只是第一层加了 rotate & alpha 的操作
                // 不过他区分左右
                float xFraction = dX / getThreshold(viewHolder);
                // 边界修正 最大为1
                if (xFraction > 1){
                    xFraction = 1;
                }else if (xFraction < -1){
                    xFraction = -1;
                }
                // rotate
                child.setRotation(xFraction * MAX_ROTATION);
                // 自己感受一下吧 Alpha
//                if (viewHolder instanceof ViewHolder){
//                    ViewHolder holder = (ViewHolder) viewHolder;
//                    if (dX > 0){
//                        // 露出左边,比心
//                        holder.setAlpha(R.id.iv_love,xFraction);
//                    }else {
//                        // 露出右边,滚犊子
//                        holder.setAlpha(R.id.iv_del,-xFraction);
//                    }
//                }
            }

        }

    }
}
