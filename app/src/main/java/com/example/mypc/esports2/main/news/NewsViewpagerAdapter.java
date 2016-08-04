package com.example.mypc.esports2.main.news;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.mypc.esports2.main.news.newsinner.NewsInnerFragment;

import java.util.List;

/**
 * Created by peter on 2016/8/4.
 */
public class NewsViewpagerAdapter extends FragmentStatePagerAdapter {

    private List<NewsInnerFragment> list;
    private List<String> titlelist;

    public NewsViewpagerAdapter(FragmentManager fm, List<NewsInnerFragment> list, List<String> titlelist) {
        super(fm);
        this.list = list;
        this.titlelist = titlelist;
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
        return titlelist.get(position);
    }
}
