package com.example.mypc.esports2.httputils.news;

import com.example.mypc.esports2.config.NewsUrlNewsConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;

/**
 * Created by peter on 2016/8/3.
 */
public class NewsHttpHelper {

    private static NewsHttpHelper helper;
    private Retrofit retrofit;
    INewsService service;

    private NewsHttpHelper() {
        retrofit = new Retrofit.Builder()
                //对提交的参数或者返回值进行预处理
                .baseUrl(NewsUrlNewsConfig.path.BASE_URL)
                .addConverterFactory(new NewsConvertFactory())
                .build();
        service = retrofit.create(INewsService.class);
    }

    public INewsService getService() {
        return service;
    }

    public static synchronized NewsHttpHelper newInstance() {
        if (helper == null) {
            helper = new NewsHttpHelper();
        }
        return helper;
    }
}
