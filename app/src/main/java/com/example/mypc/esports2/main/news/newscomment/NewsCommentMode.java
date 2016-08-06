package com.example.mypc.esports2.main.news.newscomment;

import com.example.mypc.esports2.bean.CommentBean;
import com.example.mypc.esports2.httputils.news.newscomment.NewsCommentHttpHelper;

import java.util.HashMap;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by peter on 2016/8/5.
 */
public class NewsCommentMode implements NewsCommentContract.Mode {
    @Override
    public void getCommentBean(HashMap<String, String> params, Callback<List<CommentBean>> callback) {
        NewsCommentHttpHelper.newInstance().getService().getCommentlist(params).enqueue(callback);
    }
}
