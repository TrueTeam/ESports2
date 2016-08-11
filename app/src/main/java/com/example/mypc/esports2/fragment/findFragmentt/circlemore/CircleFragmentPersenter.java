package com.example.mypc.esports2.fragment.findFragmentt.circlemore;

import com.example.mypc.esports2.bean.CircleHotBean;
import com.example.mypc.esports2.bean.TopicMoreBean;
import com.example.mypc.esports2.config.UrlConfig;
import com.example.mypc.esports2.fragment.findFragmentt.topicmore.TopicActivityContract;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 强 on 2016/8/5.
 */
public class CircleFragmentPersenter implements CircleFragmentContract.Persenter {
    private CircleFragmentContract.View view;
    private CircleFragmentContract.Model model;

    public CircleFragmentPersenter(CircleFragmentContract.View view, CircleFragmentContract.Model model) {
        this.view = view;
        this.model = model;
    }


    @Override
    public void initData() {
        HashMap<String, String> params = new HashMap<>();

        model.getData(UrlConfig.CircleHotPath.CIRCLEHOT, params, new Callback<List<CircleHotBean>>() {

            @Override
            public void onResponse(Call<List<CircleHotBean>> call, Response<List<CircleHotBean>> response) {

                view.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<CircleHotBean>> call, Throwable t) {
                view.onFail("加载失败");
            }
        });
    }
}
