package com.example.mypc.esports2.fragment.findFragmentt;

import android.util.Log;

import com.example.mypc.esports2.bean.CircleBean;
import com.example.mypc.esports2.bean.GamesBean;
import com.example.mypc.esports2.config.UrlConfig;
import com.example.mypc.esports2.httputils.HttpUtils;
import com.example.mypc.esports2.login.LoginContract;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 强 on 2016/8/5.
 */
public class FindFragmentPersenter implements FindFragmentContract.Persenter {
    private FindFragmentContract.View view;
    private FindFragmentContract.Model model;

    public FindFragmentPersenter(FindFragmentContract.View view, FindFragmentContract.Model model) {
        this.view = view;
        this.model = model;
    }


    @Override
    public void initData() {
        HashMap<String, String> params = new HashMap<>();
        params.put(UrlConfig.KEY.PAGE, "1");
        params.put(UrlConfig.KEY.ROW, "4");
        params.put(UrlConfig.KEY.ISHOT, "1");
        model.getCircle(UrlConfig.MiddlePath.MIDDLE, params, new Callback<List<CircleBean>>() {

            @Override
            public void onResponse(Call<List<CircleBean>> call, Response<List<CircleBean>> response) {

                view.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<CircleBean>> call, Throwable t) {
                view.onFail("加载失败");
            }
        });
    }
}
