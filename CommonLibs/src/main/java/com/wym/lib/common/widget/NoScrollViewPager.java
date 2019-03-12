package com.wym.lib.common.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Everyday is another day, keep going.
 * author:  Ramo
 * email:   327300401@qq.com
 * date:    2017/6/13 11:24
 * desc:    屏蔽左右滑动的ViewPager
 */

public class NoScrollViewPager extends ViewPager {

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        return false;

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        return false;

    }
}
