package com.wym.lib.common.widget;

import android.view.MotionEvent;
import android.widget.ListView;

/**
 * 完全展示的ListView
 */

public class NoScrollListView extends ListView {
    public NoScrollListView(android.content.Context context, android.util.AttributeSet attrs) {
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
