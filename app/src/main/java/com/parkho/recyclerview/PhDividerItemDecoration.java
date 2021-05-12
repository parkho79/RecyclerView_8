package com.parkho.recyclerview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class PhDividerItemDecoration extends RecyclerView.ItemDecoration {

    private Paint mPaint = new Paint();

    private float mHeight;

    public PhDividerItemDecoration(float a_height, int a_color) {
        mHeight = a_height;
        mPaint.setColor(a_color);
    }

    @Override
    public void onDrawOver(@NonNull Canvas a_canvas, @NonNull RecyclerView a_parent, @NonNull RecyclerView.State a_state) {
        super.onDrawOver(a_canvas, a_parent, a_state);

        final int left = a_parent.getPaddingLeft();
        final int right = a_parent.getWidth() - a_parent.getPaddingRight();
        final int childCount = a_parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = a_parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            float bottom = top + mHeight;

            a_canvas.drawRect(left, top, right, bottom, mPaint);
        }
    }
}