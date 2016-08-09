package com.example.mypc.esports2.httputils.news.newscomment;

import com.example.mypc.esports2.bean.CommentBean;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by peter on 2016/8/5.
 */
public interface INewsCommentService {

    @GET("api/item/comment")
    Call<List<CommentBean>> getCommentlist(@QueryMap() HashMap<String, String> params);
}
