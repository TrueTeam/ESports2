package com.example.mypc.esports2.main.news;

import com.example.mypc.esports2.bean.ListBean;
import com.example.mypc.esports2.bean.NewsAD;
import com.example.mypc.esports2.config.NewsUrlNewsConfig;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by peter on 2016/8/2.
 */
public class NewsPresenter implements NewsContract.Presenter {

    private NewsContract.Mode mode;
    private NewsContract.View view;

    public NewsPresenter(NewsContract.Mode mode, NewsContract.View view) {
        this.mode = mode;
        this.view = view;
    }
//p=1&cid=223&ad=1

    @Override
    public void getData() {
        HashMap<String, String> params = new HashMap<>();
        params.put(NewsUrlNewsConfig.key.P, "1");
        params.put(NewsUrlNewsConfig.key.CID, "223");
        params.put(NewsUrlNewsConfig.key.AD, "1");

        mode.getData(params, new Callback<NewsAD>() {

            @Override
            public void onResponse(Call<NewsAD> call, Response<NewsAD> response) {
                NewsAD news = response.body();
                List<ListBean> list = news.getList();
                view.onSuccess(list);
            }

            @Override
            public void onFailure(Call<NewsAD> call, Throwable t) {
                view.onFail("请求失败");
            }
        });
    }
}
