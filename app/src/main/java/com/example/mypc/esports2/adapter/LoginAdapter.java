package com.example.mypc.esports2.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by peter on 2016/7/30.
 */
public class LoginAdapter extends FragmentPagerAdapter {

    private List<Fragment> mlist;

    public void setmArray(String[] mArray) {
        this.mArray = mArray;
    }
    private String[] mArray;
    public LoginAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.mlist = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mArray[position];
    }
}
