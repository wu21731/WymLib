package com.wym.lib.common.utils;

import android.app.Application;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Ramo on 2017/3/6.
 * Everyday is another day, keep going.
 */

public class ToastUtil {
    private static String oldMsg;
    private static Toast toast;
    private static long oldTime = 0L;
    private static long curTime = 0L;
    private static int preDuration = 0;
    private static int sLayoutId;
    private static Context context;

    /**
     * 在Application里面去调用，如果不调用，默认采用系统的Toast的样式
     *
     * @param cxt      applicationContext
     * @param layoutId 布局文件的id 参考view_transient_notification.xml
     */
    public static void init(Context cxt, @LayoutRes int layoutId) {
        if (!(cxt instanceof Application)) {
            throw new IllegalArgumentException("Context must be an instance of application");
        }
        sLayoutId = layoutId;
        context = cxt;
    }

    public static void show(String msg) {
        show(msg, Toast.LENGTH_SHORT);
    }

    public static void show(String msg, int duration) {
        if (msg == null) {
            return;
        }
        if (toast == null) {
            toast = new Toast(context.getApplicationContext());
            if (sLayoutId == 0) {
                toast.setText(msg);
            } else {
                View view = LayoutInflater.from(context.getApplicationContext()).inflate(sLayoutId, null);
                toast.setView(view);
                ((TextView) view).setText(msg);
            }
            toast.setDuration(duration);

            oldTime = System.currentTimeMillis();
            oldMsg = msg;
            preDuration = duration;
        } else {
            curTime = System.currentTimeMillis();
            if (msg.equals(oldMsg)) {
                if (curTime - oldTime > preDuration) {
                    toast.setDuration(duration);
                    preDuration = duration;
                }
            } else {
                oldMsg = msg;
                if (sLayoutId == 0) {
                    toast.setText(msg);
                } else {
                    ((TextView) toast.getView()).setText(msg);
                }
                toast.setDuration(duration);
                preDuration = duration;
            }
        }
        oldTime = curTime;
        toast.show();
    }

    public static void show(@StringRes int resId) {
        show(context.getApplicationContext().getString(resId));
    }

    public static void show(Context context, @StringRes int resId, int duration) {
        show(context.getApplicationContext().getString(resId), duration);
    }
}
