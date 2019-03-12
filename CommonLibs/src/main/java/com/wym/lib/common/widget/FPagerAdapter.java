package com.wym.lib.common.widget;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Everyday is another day, keep going.
 * author:  Ramo
 * email:   327300401@qq.com
 * date:    2017/6/13 10:46
 * desc:
 */

public class FPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private String[] titles;

    public FPagerAdapter(FragmentManager fm, List<Fragment> list) {
        this(fm, list, null);
    }

    public FPagerAdapter(FragmentManager fm, List<Fragment> list, String[] titles) {
        super(fm);
        if (titles != null && list.size() != titles.length) {
            throw new ExceptionInInitializerError("list.size() != titles.length");
        }
        this.list = list;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (titles == null) {
            return null;
        } else {
            return titles[position];
        }
    }
}
