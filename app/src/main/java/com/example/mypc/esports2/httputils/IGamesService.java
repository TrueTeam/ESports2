package com.example.mypc.esports2.httputils;

import com.example.mypc.esports2.bean.CircleBean;
import com.example.mypc.esports2.bean.CircleHotBean;
import com.example.mypc.esports2.bean.GamesBean;
import com.example.mypc.esports2.bean.MatchDetailsBean;
import com.example.mypc.esports2.bean.PersonDetailsBean;
import com.example.mypc.esports2.bean.PostBean;
import com.example.mypc.esports2.bean.PostHotBean;
import com.example.mypc.esports2.bean.TopicMoreBean;

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

    @GET("api/match/{aaa}")
    Call<MatchDetailsBean> getMatchDetailsBean(@Path("aaa")String path
            , @QueryMap()HashMap<String,String> params);
    @GET("Api/{ccc}")
    Call<List<CircleBean>> getCircle(@Path("ccc")String path
            , @QueryMap()HashMap<String,String> params);
    @GET("Api/{ccc}")
    Call<List<PostBean>> getPost(@Path("ccc")String path
            , @QueryMap()HashMap<String,String> params);
    @GET("api/{ccc}")
    Call<List<TopicMoreBean>> getTopic(@Path("ccc")String path
            , @QueryMap()HashMap<String,String> params);

    @GET("api/users/{aaa}")
    Call<PersonDetailsBean> getPersonDetailsBean(@Path("aaa")String path
            , @QueryMap()HashMap<String,String> params);
    @GET("Api/{ccc}")
    Call<List<CircleHotBean>> getCircleHot(@Path("ccc")String path
            , @QueryMap()HashMap<String,String> params);
    @GET("Api/{ccc}")
    Call<List<PostHotBean>> getPostHot(@Path("ccc")String path
            , @QueryMap()HashMap<String,String> params);
}
