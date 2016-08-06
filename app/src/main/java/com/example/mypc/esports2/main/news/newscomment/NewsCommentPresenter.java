package com.example.mypc.esports2.main.news.newscomment;

import com.example.mypc.esports2.bean.CommentBean;
import com.example.mypc.esports2.config.NewsUrlConfig;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by peter on 2016/8/5.
 */
public class NewsCommentPresenter implements NewsCommentContract.Presenter {

    private NewsCommentContract.Mode mode;
    private NewsCommentContract.View view;
    private HashMap<String, String> params;

    public NewsCommentPresenter(NewsCommentContract.Mode mode, NewsCommentContract.View view) {
        this.mode = mode;
        this.view = view;
    }

    @Override
    public void getCommentBean(String id) {
        params = new HashMap<>();
        params.put(NewsUrlConfig.key.P, "1");
        params.put(NewsUrlConfig.key.PID, id);

        mode.getCommentBean(params, new Callback<List<CommentBean>>() {

            @Override
            public void onResponse(Call<List<CommentBean>> call, Response<List<CommentBean>> response) {
                view.onGethotCommentSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<CommentBean>> call, Throwable t) {
                view.onGethotCommentFail("请求失败");
            }
        });
    }
}
