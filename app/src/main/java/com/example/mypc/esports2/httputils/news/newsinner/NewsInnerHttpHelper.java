package com.example.mypc.esports2.httputils.news.newsinner;

import com.example.mypc.esports2.config.NewsUrlConfig;

import retrofit2.Retrofit;

/**
 * Created by peter on 2016/8/3.
 */
public class NewsInnerHttpHelper {

    private static NewsInnerHttpHelper helper;
    private Retrofit retrofit;
    INewsInnerService service;

    private NewsInnerHttpHelper() {
        retrofit = new Retrofit.Builder()
                //对提交的参数或者返回值进行预处理
                .baseUrl(NewsUrlConfig.path.BASE_URL)
                .addConverterFactory(new NewsInnerConvertFactory())
                .build();
        service = retrofit.create(INewsInnerService.class);
    }

    public INewsInnerService getService() {
        return service;
    }

    public static synchronized NewsInnerHttpHelper newInstance() {
        if (helper == null) {
            helper = new NewsInnerHttpHelper();
        }
        return helper;
    }
}
