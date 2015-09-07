package com.waver.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.List;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] title = new String[]{"1", "2", "3"};
    List<Fragment> fragments;

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> mfragments) {
        super(fm);
        this.fragments = mfragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
