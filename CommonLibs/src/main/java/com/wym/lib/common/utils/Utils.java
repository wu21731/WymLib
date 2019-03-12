package com.wym.lib.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Everyday is another day, keep going.
 * Created by Ramo
 * email:   327300401@qq.com
 * date:    2019/02/20 10:40
 * desc:
 */
public class Utils {
    /**
     * 获取显示的相关参数
     *
     * @param cxt Context
     * @return The resource's current display metrics.
     */
    public static DisplayMetrics getDisplayMetrics(Context cxt) {
        return cxt.getApplicationContext().getResources().getDisplayMetrics();
    }

    /**
     * 获取状态栏的高度
     *
     * @param cxt Context
     * @return 状态栏的高度，默认为24dp
     */
    public static int getStatusBarHeight(Context cxt) {
        int height = dp2px(cxt, 24.0f);
        Resources resources = cxt.getApplicationContext().getResources();
        int resId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0) {
            height = resources.getDimensionPixelSize(resId);
        }
        return height;
    }


    /**
     * 获取sharedPreferences对象
     *
     * @param cxt        Context
     * @param sharedName sharedPreferences名称
     * @return sharedPreferences对象
     */
    public static SharedPreferences getSharedPreferences(Context cxt, String sharedName) {
        return cxt.getApplicationContext().getSharedPreferences(sharedName, Context.MODE_PRIVATE);
    }

    /**
     * dp转px
     *
     * @param cxt Context
     * @param dp  dp
     * @return px
     */
    public static int dp2px(Context cxt, float dp) {
        return (int) (dp * getDisplayMetrics(cxt).density + 0.5f);
    }

    /**
     * px转dp
     *
     * @param cxt Context
     * @param px  px
     * @return dp
     */
    public static int px2dp(Context cxt, int px) {
        return (int) (px * 1.0f / getDisplayMetrics(cxt).scaledDensity + 0.5f);
    }

    /**
     * sp转px
     *
     * @param cxt Context
     * @param sp  sp
     * @return px
     */
    public static int sp2px(Context cxt, float sp) {
        return (int) (sp * getDisplayMetrics(cxt).scaledDensity + 0.5f);
    }

    /**
     * px转sp
     *
     * @param cxt Context
     * @param px  px
     * @return sp
     */
    public static int px2sp(Context cxt, int px) {
        return (int) (px * 1.0f / getDisplayMetrics(cxt).scaledDensity + 0.5f);
    }
}
