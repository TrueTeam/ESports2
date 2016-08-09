package com.example.mypc.esports2.main.matchdetails;

import android.util.Log;

import com.example.mypc.esports2.bean.MatchDetailsBean;
import com.example.mypc.esports2.config.UrlConfig;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MyPC on 2016/8/4.
 */
public class MatchDetailsPersenter implements MatchDetailsContract.Persenter {

    private MatchDetailsContract.View mView;
    private MatchDetailsContract.Model mModel;
    public MatchDetailsPersenter(MatchDetailsContract.View view, MatchDetailsContract.Model model){
        this.mView = view;
        this.mModel = model;
    }
    @Override
    public void getDate(String s) {
        HashMap<String,String> params = new HashMap<>();
        params.put(UrlConfig.KEY.MATCH_ID,s);
        mModel.getData(UrlConfig.ThumbnailPath.INFO, params, new Callback<MatchDetailsBean>() {
            @Override
            public void onResponse(Call<MatchDetailsBean> call, Response<MatchDetailsBean> response) {
                MatchDetailsBean body = response.body();
                mView.onSuccess(body);
            }

            @Override
            public void onFailure(Call<MatchDetailsBean> call, Throwable t) {
                mView.onFild("加载失败");
            }
        });
    }
}
