package com.example.mypc.esports2.main.news.newsinner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.bean.AdBean;
import com.example.mypc.esports2.bean.Artical;
import com.example.mypc.esports2.bean.ListBean;
import com.example.mypc.esports2.bean.NewsAD;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by peter on 2016/8/4.
 */
public class NewsInnerFragment extends Fragment implements NewsInnerContract.View {


    @BindView(R.id.viewpager_inner_news)
    ViewPager viewpagerInnerNews;
    @BindView(R.id.tv_viewpager_title)
    TextView tvViewpagerTitle;
    @BindView(R.id.ll_viewpager_point)
    LinearLayout llViewpagerPoint;
    @BindView(R.id.recyclerview_inner_news)
    RecyclerView recyclerviewInnerNews;
    private NewsInnerContract.Presenter presenter;
    private NewsInnerContract.Mode mode;
    private NewsInnerRecycleviewAdapter adapter;
    private NewsInnerViewpagerAdapter viewpagerAdapter;
    private LinearLayoutManager manager;
    private Artical artical;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_inner, container, false);
        ButterKnife.bind(this, view);
        mode = new NewsInnerMode();
        presenter = new NewsInnerPresenter(mode, this);
        //为Fragment添加数据
        manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewInnerNews.setLayoutManager(manager);
        presenter.getData(getArtical().getId());
        return view;
    }

    public Artical getArtical() {
        return artical;
    }

    public NewsInnerFragment setArtical(Artical artical) {
        this.artical = artical;
        return this;
    }

    @Override
    public void onSuccess(final NewsAD newsAD) {
        final List<AdBean> ad = newsAD.getAd();
        viewpagerAdapter = new NewsInnerViewpagerAdapter(ad);
        viewpagerInnerNews.setAdapter(viewpagerAdapter);

        tvViewpagerTitle.setText(ad.get(0).getTitle());

        List<ListBean> list = newsAD.getList();
        adapter = new NewsInnerRecycleviewAdapter(R.layout.news_inner_listitem, list);
        recyclerviewInnerNews.setAdapter(adapter);

        onviewpagerItemclick(ad);
    }

    private void onviewpagerItemclick(final List<AdBean> ad) {
        viewpagerInnerNews.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tvViewpagerTitle.setText(ad.get(position % ad.size()).getTitle());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
