package com.example.mypc.esports2.main.news.newsinner;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.bean.AdBean;
import com.example.mypc.esports2.bean.Artical;
import com.example.mypc.esports2.bean.ListBean;
import com.example.mypc.esports2.bean.NewsAD;
import com.example.mypc.esports2.main.news.newsdetail.NewsDetailActivity;

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

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                int index = msg.arg1;
                viewpagerInnerNews.setCurrentItem(index);
            }
        }
    };

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

        //开始线程任务
        final AutoRunTask autoTask = new AutoRunTask();
        autoTask.startRun();

        //处理ViewPager的触摸事件
        viewpagerInnerNews.setOnTouchListener(new View.OnTouchListener()

                                              {
                                                  //当触摸屏幕的时候调用
                                                  //MotionEvent:手指触摸到屏幕的时候,所触发的一系列的事件.
                                                  //down,up,move,cancle.
                                                  @Override
                                                  public boolean onTouch(View v, MotionEvent event) {
                                                      //当手指触摸到ViewPager的时候,ViewPager的自动跳转会停止;
                                                      //如果手指没有触摸ViewPager,ViewPager的自动跳转又会开始.
                                                      switch (event.getAction()) {
                                                          case MotionEvent.ACTION_DOWN://第一个被执行的事件
                                                              autoTask.stopRun();
                                                              break;
                                                          case MotionEvent.ACTION_CANCEL:
                                                          case MotionEvent.ACTION_UP:
                                                              autoTask.startRun();
                                                              break;
                                                      }

                                                      //此处只能返回false
                                                      return false;
                                                  }
                                              }

        );

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
        viewpagerInnerNews.setCurrentItem(100 * ad.size());

        final List<ListBean> list = newsAD.getList();
        adapter = new NewsInnerRecycleviewAdapter(R.layout.news_inner_listitem, list);
        recyclerviewInnerNews.setAdapter(adapter);

        onPagechangelistener(ad);
        adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                ListBean listBean = list.get(i);
                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                intent.putExtra("listbean", listBean);
                startActivity(intent);
            }
        });
    }

    private void onPagechangelistener(final List<AdBean> ad) {
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


    //自定跳转的线程任务
    class AutoRunTask implements Runnable {

        private int delayTime = 2000;
        private boolean isStart = false;

        //开始线程任务
        public void startRun() {
            if (!isStart) {
                //关闭之前所有正在执行的任务
                handler.removeCallbacks(this);
                isStart = true;
                handler.postDelayed(this, delayTime);
            }
        }

        //停止线程的方法
        public void stopRun() {
            if (isStart) {
                isStart = false;
                handler.removeCallbacks(this);
            }
        }

        @Override
        public void run() {

            int currentItem = viewpagerInnerNews.getCurrentItem();

            //发送消息
            Message msg = Message.obtain();
            msg.what = 1;
            msg.arg1 = ++currentItem;
            handler.sendMessage(msg);

            //递归调用自身,形成循环.
            handler.postDelayed(this, delayTime);
        }
    }


}
