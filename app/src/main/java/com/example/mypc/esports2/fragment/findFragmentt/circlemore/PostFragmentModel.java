package com.example.mypc.esports2.fragment.findFragmentt.circlemore;

import com.example.mypc.esports2.bean.CircleHotBean;
import com.example.mypc.esports2.bean.PostHotBean;
import com.example.mypc.esports2.httputils.CircleHotHelper;
import com.example.mypc.esports2.httputils.PostMoreHelper;

import java.util.HashMap;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by 强 on 2016/8/5.
 */
public class PostFragmentModel implements PostFragmentContract.Model{

    @Override
    public void getData(String url, HashMap<String, String> params, Callback<List<PostHotBean>> callback) {

        PostMoreHelper.newInstance().getService().getPostHot(url,params).enqueue(callback);
    }
}
