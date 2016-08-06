package com.example.mypc.esports2.main.news.newsinner;

import com.example.mypc.esports2.bean.NewsBean;
import com.example.mypc.esports2.httputils.news.newsinner.NewsInnerHttpHelper;

import java.util.HashMap;

import retrofit2.Callback;

/**
 * Created by peter on 2016/8/2.
 */
public class NewsInnerMode implements NewsInnerContract.Mode {

    @Override
    public void getData(HashMap<String, String> params, Callback<NewsBean> callback) {
        NewsInnerHttpHelper.newInstance().getService().getMovieList(params).enqueue(callback);
    }
}
