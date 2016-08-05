package com.example.mypc.esports2.httputils.news.newsdetail;

import com.example.mypc.esports2.bean.NewsDetailBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by peter on 2016/8/5.
 */
public interface INewsDetailService {

    @GET("api/item/article")
    Call<NewsDetailBean> getNewsdetail(@Query("id") String id);
}
