package com.example.mypc.esports2.main.news;

import com.example.mypc.esports2.bean.ArticalBean;
import com.example.mypc.esports2.httputils.news.NewsHttpHelper;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by peter on 2016/8/4.
 */
public class NewsMode implements NewsContract.Mode {
    @Override
    public void getData(Callback<List<ArticalBean>> callback) {
        NewsHttpHelper.newInstance().getService().getArticalList().enqueue(callback);
    }
}
