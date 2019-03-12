package com.wym.lib.common.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Everyday is another day, keep going.
 * Created by Ramo
 * email:   327300401@qq.com
 * date:    2019/03/06 15:54
 * desc:
 */
public class HolderHelper {
    //使用SparseArray缓存通过findViewById获取到的控件，避免多次findViewById
    private SparseArray<View> mArray = new SparseArray<>();
    private View itemView;
    private Context context;

    public HolderHelper(Context context, View view) {
        this.context = context;
        itemView = view;
    }

    public View getItemView() {
        return itemView;
    }

    public <E extends View> E getView(@IdRes int id) {
        View view = mArray.get(id);
        if (view == null) {
            mArray.put(id, itemView.findViewById(id));
            view = mArray.get(id);
        }
        return (E) view;
    }

    public HolderHelper setVisible(@IdRes int id, int visibility) {
        getView(id).setVisibility(visibility);
        return this;
    }

    public HolderHelper setText(@IdRes int id, String value) {
        TextView textView = getView(id);
        textView.setText(value);
        return this;
    }

    public HolderHelper setText(@IdRes int id, @StringRes int resId) {
        TextView textView = getView(id);
        textView.setText(context.getString(resId));
        return this;
    }

    public HolderHelper setText(@IdRes int id, SpannableString value) {
        TextView textView = getView(id);
        textView.setText(value);
        return this;
    }

    public HolderHelper setTextHtml(@IdRes int id, String htmlStr) {
        TextView textView = getView(id);
        if (TextUtils.isEmpty(htmlStr)) {
            htmlStr = "";
        }
        textView.setText(Html.fromHtml(htmlStr));
        return this;
    }

    public HolderHelper setTextColorRes(@IdRes int id, @ColorRes int colorRes) {
        setTextColor(id, context.getResources().getColor(colorRes));
        return this;
    }

    public HolderHelper setTextColor(@IdRes int id, int textColor) {
        TextView textView = getView(id);
        textView.setTextColor(textColor);
        return this;
    }

    public HolderHelper setTextColor(@IdRes int id, ColorStateList colorStateList) {
        TextView textView = getView(id);
        textView.setTextColor(colorStateList);
        return this;
    }

    public HolderHelper setImage(@IdRes int id, int resId) {
        ImageView view = getView(id);
        view.setImageResource(resId);
        return this;
    }

    public HolderHelper setImage(@IdRes int id, Bitmap bitmap) {
        ImageView view = getView(id);
        view.setImageBitmap(bitmap);
        return this;
    }

    public HolderHelper setClickListener(@IdRes int id, View.OnClickListener listener) {
        getView(id).setOnClickListener(listener);
        return this;
    }
}
