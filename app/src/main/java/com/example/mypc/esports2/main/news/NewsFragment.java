package com.example.mypc.esports2.main.news;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.bean.ArticalBean;
import com.example.mypc.esports2.main.news.newsinner.NewsInnerFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NewsFragment extends Fragment implements NewsContract.View {


    @BindView(R.id.tablayout_news)
    TabLayout tablayoutNews;
    @BindView(R.id.viewpager_news)
    ViewPager viewpagerNews;
    private NewsContract.Presenter presenter;
    private NewsContract.Mode mode;
    private NewsViewpagerAdapter adapter;
    private List<NewsInnerFragment> fragments = new ArrayList<>();
    private List<String> titlelist = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);
        mode = new NewsMode();
        presenter = new NewsPresenter(mode, this);
        presenter.getData();

        adapter = new NewsViewpagerAdapter(getFragmentManager(), fragments, titlelist);
        viewpagerNews.setAdapter(adapter);
        tablayoutNews.setupWithViewPager(viewpagerNews);

        return view;
    }

    @Override
    public void onSuccess(List<ArticalBean> list) {
        for (ArticalBean articalBean : list) {
            String title = articalBean.getTitle();
            titlelist.add(title);
            NewsInnerFragment newsInnerFragment = new NewsInnerFragment();
            newsInnerFragment.setArticalBean(articalBean);
            fragments.add(newsInnerFragment);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFail(String msg) {

    }
}
