package com.example.mypc.esports2.main.news;

import com.example.mypc.esports2.bean.NewsAD;
import com.example.mypc.esports2.httputils.news.NewsHttpHelper;

import java.util.HashMap;

import retrofit2.Callback;

/**
 * Created by peter on 2016/8/2.
 */
public class NewsMode implements NewsContract.Mode {

    @Override
    public void getData(HashMap<String, String> params, Callback<NewsAD> callback) {
        NewsHttpHelper.newInstance().getService().getMovieList(params).enqueue(callback);
    }
}
