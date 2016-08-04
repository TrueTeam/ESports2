package com.example.mypc.esports2.main.news.newsinner;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mypc.esports2.bean.AdBean;
import com.example.mypc.esports2.main.news.NewsDetailActivity;

import java.util.List;
import java.util.zip.Inflater;

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
    public Object instantiateItem(final ViewGroup container, final int position) {
        ImageView iv = new ImageView(container.getContext());
        Glide.with(container.getContext()).load(list.get(position % list.size()).getCoverLink()).into(iv);
        container.addView(iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdBean adBean = list.get(position % list.size());
                Intent intent = new Intent(container.getContext(), NewsDetailActivity.class);
                intent.putExtra("adbean",adBean);
                container.getContext().startActivity(intent);
            }
        });
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }
}
