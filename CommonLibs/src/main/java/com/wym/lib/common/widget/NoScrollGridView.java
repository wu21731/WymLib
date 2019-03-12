package com.wym.lib.common.widget;

import android.view.MotionEvent;
import android.widget.GridView;

/**
 * 完全展示的GirdView
 */

public class NoScrollGridView extends GridView {
    public NoScrollGridView(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
    }


    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
