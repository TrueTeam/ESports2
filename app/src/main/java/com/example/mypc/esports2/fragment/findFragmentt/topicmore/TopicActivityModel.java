package com.example.mypc.esports2.fragment.findFragmentt.topicmore;

import com.example.mypc.esports2.bean.CircleBean;
import com.example.mypc.esports2.bean.TopicMoreBean;
import com.example.mypc.esports2.fragment.findFragmentt.FindFragmentContract;
import com.example.mypc.esports2.httputils.FindHttpHelper;
import com.example.mypc.esports2.httputils.TopicMoreHelper;

import java.util.HashMap;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by 强 on 2016/8/5.
 */
public class TopicActivityModel implements TopicActivityContract.Model{

    @Override
    public void getData(String url, HashMap<String, String> params, Callback<List<TopicMoreBean>> callback) {
        TopicMoreHelper.newInstance().getService().getTopic(url,params).enqueue(callback);
    }
}
