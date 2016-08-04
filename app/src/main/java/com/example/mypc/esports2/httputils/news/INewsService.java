package com.example.mypc.esports2.httputils.news;

import com.example.mypc.esports2.bean.NewsAD;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
//http://139.196.106.200/api/item/article?p=1&cid=223&ad=1

/**
 * Created by peter on 2016/8/3.
 */
public interface INewsService {
    @GET("api/item/article")
    Call<NewsAD> getMovieList(@QueryMap() HashMap<String, String> params);
}
