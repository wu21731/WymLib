package com.wym.lib.common.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Everyday is another day, keep going.
 * Created by Ramo
 * email:   327300401@qq.com
 * date:    2017/10/09 10:18
 * desc:    通用的ListView和GridView的适配器。只适用单布局，多布局请使用RecyclerView实现。
 */

public abstract class BAdapter<T> extends BaseAdapter {
    private Context context;
    private List<T> list;
    private int layoutId;

    protected BAdapter(Context context, int layoutId, List<T> list) {
        this.context = context;
        this.list = list;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
            viewHolder = new BViewHolder(context, convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (BViewHolder) convertView.getTag();
        }
        init(position, viewHolder, list.get(position));
        return convertView;
    }

    protected abstract void init(int position, BViewHolder holder, T data);

}
