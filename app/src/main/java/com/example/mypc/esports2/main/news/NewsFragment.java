package com.example.mypc.esports2.main.news;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.bean.ListBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NewsFragment extends Fragment implements NewsContract.View {


    @BindView(R.id.tablayout_news)
    TabLayout tablayoutNews;
    @BindView(R.id.viewpager_news)
    ViewPager viewpagerNews;
    @BindView(R.id.recyclerview_news)
    RecyclerView recyclerviewNews;
    private NewsContract.Presenter presenter;
    private NewsContract.Mode mode;
    private NewsAdapter adapter;
    private List<ListBean> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);
        mode = new NewsMode();
        presenter = new NewsPresenter(mode, this);
        list = new ArrayList<>();
        adapter = new NewsAdapter(list);
        recyclerviewNews.setAdapter(adapter);

        presenter.getData();
        return view;
    }


    @Override
    public void onSuccess(List<ListBean> content) {
        list.addAll(content);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {
        Log.e("TAG", "onFail: " + msg);
    }
}
