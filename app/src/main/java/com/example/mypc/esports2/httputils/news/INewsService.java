package com.example.mypc.esports2.httputils.news;

import com.example.mypc.esports2.bean.Artical;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by peter on 2016/8/4.
 */
public interface INewsService {

    @GET("api/category/article")
    Call<List<Artical>> getArticalList();
}
