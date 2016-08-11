package com.example.mypc.esports2.fragment.findFragmentt.circlemore;

import com.example.mypc.esports2.bean.CircleHotBean;
import com.example.mypc.esports2.bean.TopicMoreBean;
import com.example.mypc.esports2.fragment.findFragmentt.topicmore.TopicActivityContract;
import com.example.mypc.esports2.httputils.CircleHotHelper;
import com.example.mypc.esports2.httputils.TopicMoreHelper;

import java.util.HashMap;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by 强 on 2016/8/5.
 */
public class CircleFragmentModel implements CircleFragmentContract.Model{

    @Override
    public void getData(String url, HashMap<String, String> params, Callback<List<CircleHotBean>> callback) {
        CircleHotHelper.newInstance().getService().getCircleHot(url,params).enqueue(callback);
    }
}
