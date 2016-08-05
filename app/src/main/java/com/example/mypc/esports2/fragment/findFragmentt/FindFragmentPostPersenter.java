package com.example.mypc.esports2.fragment.findFragmentt;

import android.app.Presentation;
import android.util.Log;

import com.example.mypc.esports2.bean.CircleBean;
import com.example.mypc.esports2.bean.PostBean;
import com.example.mypc.esports2.config.UrlConfig;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 强 on 2016/8/5.
 */
public class FindFragmentPostPersenter implements FindFragmentContract.Persenter {

    private FindpostFragmentContract.View view;
    private FindpostFragmentContract.Model model;

    public FindFragmentPostPersenter(FindpostFragmentContract.View view, FindpostFragmentContract.Model model) {
        this.view = view;
        this.model = model;
    }


    @Override
    public void initData() {
        HashMap<String, String> params = new HashMap<>();
        params.put(UrlConfig.KEY.PAGE, "1");
        params.put(UrlConfig.KEY.ROW, "4");
        params.put(UrlConfig.KEY.ORDERTYPE, "1");
        model.getPost(UrlConfig.PostPath.POST, params, new Callback<List<PostBean>>() {

            @Override
            public void onResponse(Call<List<PostBean>> call, Response<List<PostBean>> response) {

                view.onSuccesspost(response.body());
//                List<PostBean> body = response.body();
//                for (int i = 0; i <body.size() ; i++) {
//                    Log.i("TAG",body.get(i).getHead_link());
//                }
            }

            @Override
            public void onFailure(Call<List<PostBean>> call, Throwable t) {
                view.onFailpost("加载失败");
            }
        });
    }
}