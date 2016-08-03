package com.example.mypc.esports2.gamelib;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mypc.esports2.gamelib.matchinnerfragment.MatchInnerFragment;

/**
 * Created by MyPC on 2016/8/2.
 */
public class MatchPagerAdapter extends FragmentPagerAdapter {
    private String[] pageTitle;
    public MatchPagerAdapter(FragmentManager fm,String[] pageTitle) {
        super(fm);
        this.pageTitle = pageTitle;
    }

    @Override
    public Fragment getItem(int position) {
        return new MatchInnerFragment(position);
    }

    @Override
    public int getCount() {
        return pageTitle.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitle[position];
    }
}
