package com.example.mypc.esports2.main.persondetails;

import com.example.mypc.esports2.bean.PersonDetailsBean;
import com.example.mypc.esports2.config.UrlConfig;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MyPC on 2016/8/5.
 */
public class PersonDetailsPersenter implements PersonDetailsContract.Persenter {
    private PersonDetailsContract.View view;
    private PersonDetailsContract.Model model;
    public PersonDetailsPersenter(PersonDetailsContract.View view, PersonDetailsContract.Model model){
        this.view = view;
        this.model = model;
    }
    @Override
    public void getDate(String s) {
        HashMap<String,String> params = new HashMap<>();
        params.put(UrlConfig.KEY.UID,s);
        model.getDate(UrlConfig.ThumbnailPath.INFO, params, new Callback<PersonDetailsBean>() {
            @Override
            public void onResponse(Call<PersonDetailsBean> call, Response<PersonDetailsBean> response) {
                view.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<PersonDetailsBean> call, Throwable t) {
                view.onFail("网络连接有问题,请稍后再试");
            }
        });
    }
}
