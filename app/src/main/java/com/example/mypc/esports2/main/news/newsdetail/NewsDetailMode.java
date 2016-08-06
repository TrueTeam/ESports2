package com.example.mypc.esports2.main.news.newsdetail;

import com.example.mypc.esports2.bean.NewsDetailBean;
import com.example.mypc.esports2.httputils.news.newsdetail.NewsDetailHttpHelper;

import retrofit2.Callback;

/**
 * Created by peter on 2016/8/5.
 */
public class NewsDetailMode implements NewsDetailContract.Mode {
    @Override
    public void getNewsdetailData(String id,Callback<NewsDetailBean> callback) {
        NewsDetailHttpHelper.newInstance().getService().getNewsdetail(id).enqueue(callback);
    }
}
