package com.example.mypc.esports2.httputils.news.newsdetail;

import com.example.mypc.esports2.config.NewsUrlConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by peter on 2016/8/3.
 */
public class NewsDetailHttpHelper {

    private static NewsDetailHttpHelper helper;
    private Retrofit retrofit;
    INewsDetailService service;

    private NewsDetailHttpHelper() {
        retrofit = new Retrofit.Builder()
                //对提交的参数或者返回值进行预处理
                .baseUrl(NewsUrlConfig.path.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(INewsDetailService.class);
    }

    public INewsDetailService getService() {
        return service;
    }

    public static synchronized NewsDetailHttpHelper newInstance() {
        if (helper == null) {
            helper = new NewsDetailHttpHelper();
        }
        return helper;
    }
}
