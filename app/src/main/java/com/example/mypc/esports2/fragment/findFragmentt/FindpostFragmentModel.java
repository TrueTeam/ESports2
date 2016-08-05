package com.example.mypc.esports2.fragment.findFragmentt;

import com.example.mypc.esports2.bean.CircleBean;
import com.example.mypc.esports2.bean.PostBean;
import com.example.mypc.esports2.httputils.FindHttpHelper;
import com.example.mypc.esports2.httputils.FindPostHelper;

import java.util.HashMap;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by 强 on 2016/8/5.
 */
public class FindpostFragmentModel implements FindpostFragmentContract.Model{



    @Override
    public void getPost(String url, HashMap<String, String> params, Callback<List<PostBean>> callback) {
        FindPostHelper.newInstance().getService().getPost(url,params).enqueue(callback);
    }
}
