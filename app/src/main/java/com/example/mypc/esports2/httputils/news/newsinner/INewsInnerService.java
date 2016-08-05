package com.example.mypc.esports2.httputils.news.newsinner;

import com.example.mypc.esports2.bean.NewsBean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
//http://139.196.106.200/api/item/article?p=1&cid=223&ad=1

/**
 * Created by peter on 2016/8/3.
 */
public interface INewsInnerService {
    @GET("api/item/article")
    Call<NewsBean> getMovieList(@QueryMap() HashMap<String, String> params);
}
