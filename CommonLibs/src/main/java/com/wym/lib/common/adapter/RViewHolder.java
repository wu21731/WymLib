package com.wym.lib.common.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Ramo
 * Everyday is another day, keep going.
 */
public class RViewHolder extends RecyclerView.ViewHolder {

    private HolderHelper helper;

    public RViewHolder(Context context, View itemView) {
        super(itemView);
        helper = new HolderHelper(context, itemView);
    }

    public HolderHelper getHelper() {
        return helper;
    }
}
