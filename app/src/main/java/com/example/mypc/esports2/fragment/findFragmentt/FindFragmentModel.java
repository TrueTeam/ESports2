package com.example.mypc.esports2.fragment.findFragmentt;

import com.example.mypc.esports2.bean.CircleBean;

import com.example.mypc.esports2.httputils.FindHttpHelper;


import java.util.HashMap;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by 强 on 2016/8/5.
 */
public class FindFragmentModel implements FindFragmentContract.Model{

    @Override
    public void getCircle(String url, HashMap<String, String> params, Callback<List<CircleBean>> callback) {
        FindHttpHelper.newInstance().getService().getCircle(url,params).enqueue(callback);
    }
}
