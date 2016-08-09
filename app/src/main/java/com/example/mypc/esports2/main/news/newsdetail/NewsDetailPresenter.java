package com.example.mypc.esports2.main.news.newsdetail;

import android.util.Log;

import com.example.mypc.esports2.bean.NewsDetailBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by peter on 2016/8/5.
 */
public class NewsDetailPresenter implements NewsDetailContract.Presenter {

    private NewsDetailContract.Mode mode;
    private NewsDetailContract.View view;

    public NewsDetailPresenter(NewsDetailContract.Mode mode, NewsDetailContract.View view) {
        this.mode = mode;
        this.view = view;
    }

    @Override
    public void getNewsdetailData(String id) {
        mode.getNewsdetailData(id, new Callback<NewsDetailBean>() {
            @Override
            public void onResponse(Call<NewsDetailBean> call, Response<NewsDetailBean> response) {
                NewsDetailBean newsDetailBean = response.body();
                view.onGetNewsdetailSuccess(newsDetailBean);
            }

            @Override
            public void onFailure(Call<NewsDetailBean> call, Throwable t) {
                view.onGetNewsdetailFail("请求失败");
            }
        });
    }
}
