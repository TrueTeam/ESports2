package com.example.mypc.esports2.fragment.findFragmentt.topicmore;

import com.example.mypc.esports2.bean.CircleBean;
import com.example.mypc.esports2.bean.TopicMoreBean;
import com.example.mypc.esports2.config.UrlConfig;
import com.example.mypc.esports2.fragment.findFragmentt.FindFragmentContract;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 强 on 2016/8/5.
 */
public class TopicActivityPersenter implements TopicActivityContract.Persenter {
    private TopicActivityContract.View view;
    private TopicActivityContract.Model model;

    public TopicActivityPersenter(TopicActivityContract.View view, TopicActivityContract.Model model) {
        this.view = view;
        this.model = model;
    }


    @Override
    public void initData() {
        HashMap<String, String> params = new HashMap<>();
        params.put(UrlConfig.KEY.PAGE, "1");
        model.getData(UrlConfig.TopicPath.TOPIC, params, new Callback<List<TopicMoreBean>>() {

            @Override
            public void onResponse(Call<List<TopicMoreBean>> call, Response<List<TopicMoreBean>> response) {

                view.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<TopicMoreBean>> call, Throwable t) {
                view.onFail("加载失败");
            }
        });
    }
}
