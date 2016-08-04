package com.example.mypc.esports2.main.news.newsinner;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mypc.esports2.bean.AdBean;

import java.util.List;

/**
 * Created by peter on 2016/8/4.
 */
public class NewsInnerViewpagerAdapter extends PagerAdapter {

    private List<AdBean> list;

    public NewsInnerViewpagerAdapter(List<AdBean> list) {
        this.list = list;
    }


    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView iv = new ImageView(container.getContext());
        Log.e("TAG", "instantiateItem: " + list.size());
        Glide.with(container.getContext()).load(list.get(position % list.size()).getCoverLink()).into(iv);
        container.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }
}
