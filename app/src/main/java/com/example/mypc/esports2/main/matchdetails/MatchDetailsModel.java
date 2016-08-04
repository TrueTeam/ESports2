package com.example.mypc.esports2.main.matchdetails;

import com.example.mypc.esports2.bean.MatchDetailsBean;
import com.example.mypc.esports2.httputils.matchdetails.DetailsHttpHelper;

import java.util.HashMap;

import retrofit2.Callback;

/**
 * Created by MyPC on 2016/8/4.
 */
public class MatchDetailsModel implements MatchDetailsContract.Model{



    @Override
    public void getData(String path, HashMap<String, String> params, Callback<MatchDetailsBean> callback) {
        DetailsHttpHelper.newInstance().getService().getMatchDetailsBean(path,params).enqueue(callback);
    }
}
