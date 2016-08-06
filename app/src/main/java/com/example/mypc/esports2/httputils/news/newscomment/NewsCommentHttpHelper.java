package com.example.mypc.esports2.httputils.news.newscomment;

import com.example.mypc.esports2.config.NewsUrlConfig;
import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by peter on 2016/8/6.
 */
public class NewsCommentHttpHelper {

    private static NewsCommentHttpHelper helper;
    private Retrofit retrofit;
    private Gson gson;
    INewsCommentService service;

    private NewsCommentHttpHelper() {
//        gson = new GsonBuilder().serializeNulls().create();
        retrofit = new Retrofit.Builder()
                //对提交的参数或者返回值进行预处理
                .baseUrl(NewsUrlConfig.path.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(INewsCommentService.class);
    }

    public INewsCommentService getService() {
        return service;
    }

    public static synchronized NewsCommentHttpHelper newInstance() {
        if (helper == null) {
            helper = new NewsCommentHttpHelper();
        }
        return helper;
    }
}
