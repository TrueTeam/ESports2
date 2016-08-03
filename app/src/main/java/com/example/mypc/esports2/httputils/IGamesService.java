package com.example.mypc.esports2.httputils;

import com.example.mypc.esports2.bean.GamesBean;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by MyPC on 2016/8/2.
 */
public interface IGamesService {
    @GET("api/{ccc}")
    Call<List<GamesBean>> getHtml(@Path("ccc")String path
            , @QueryMap()HashMap<String,String> params);
    @POST("api/{ccc}")
    Call<List<GamesBean>> getGames(@Path("ccc")String path
            , @QueryMap()HashMap<String,String> params);

}
