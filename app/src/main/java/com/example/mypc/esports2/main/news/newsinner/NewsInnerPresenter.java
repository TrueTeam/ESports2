package com.example.mypc.esports2.main.news.newsinner;

import com.example.mypc.esports2.bean.NewsAD;
import com.example.mypc.esports2.config.NewsUrlConfig;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by peter on 2016/8/2.
 */
public class NewsInnerPresenter implements NewsInnerContract.Presenter {

    private NewsInnerContract.Mode mode;
    private NewsInnerContract.View view;

    public NewsInnerPresenter(NewsInnerContract.Mode mode, NewsInnerContract.View view) {
        this.mode = mode;
        this.view = view;
    }

    @Override
    public void getData(String id) {
        HashMap<String, String> params = new HashMap<>();
        params.put(NewsUrlConfig.key.P, "1");
        params.put(NewsUrlConfig.key.CID, id);
        params.put(NewsUrlConfig.key.AD, "1");

        mode.getData(params, new Callback<NewsAD>() {

            @Override
            public void onResponse(Call<NewsAD> call, Response<NewsAD> response) {
                NewsAD news = response.body();
                view.onSuccess(news);
            }

            @Override
            public void onFailure(Call<NewsAD> call, Throwable t) {
                view.onFail("请求失败");
            }
        });
    }
}
