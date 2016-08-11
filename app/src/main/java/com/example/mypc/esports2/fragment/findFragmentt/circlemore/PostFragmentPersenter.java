package com.example.mypc.esports2.fragment.findFragmentt.circlemore;

import com.example.mypc.esports2.bean.CircleHotBean;
import com.example.mypc.esports2.bean.PostHotBean;
import com.example.mypc.esports2.config.UrlConfig;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 强 on 2016/8/5.
 */
public class PostFragmentPersenter implements PostFragmentContract.Persenter {
    private PostFragmentContract.View view;
    private PostFragmentContract.Model model;

    public PostFragmentPersenter(PostFragmentContract.View view, PostFragmentContract.Model model) {
        this.view = view;
        this.model = model;
    }


    @Override
    public void initData() {
        HashMap<String, String> params = new HashMap<>();
            params.put(UrlConfig.KEY.PAGE,"1");
            params.put(UrlConfig.KEY.ORDERTYPE,"1");
        model.getData(UrlConfig.PostHotPath.POSTHOT, params, new Callback<List<PostHotBean>>() {

            @Override
            public void onResponse(Call<List<PostHotBean>> call, Response<List<PostHotBean>> response) {

                view.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<PostHotBean>> call, Throwable t) {
                view.onFail("加载失败");
            }
        });
    }
}
