package com.wym.lib.common.adapter;

import android.content.Context;
import android.view.View;

/**
 * Everyday is another day, keep going.
 * Created by Ramo
 * email:   327300401@qq.com
 * date:    2017/10/09 11:30
 * desc:
 */

public class BViewHolder {

    private HolderHelper helper;

    public BViewHolder(Context context, View view) {
        helper = new HolderHelper(context, view);
    }

    public HolderHelper getHelper() {
        return helper;
    }
}
