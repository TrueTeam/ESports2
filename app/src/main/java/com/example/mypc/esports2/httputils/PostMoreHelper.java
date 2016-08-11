package com.example.mypc.esports2.httputils;

import com.example.mypc.esports2.config.UrlConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;

/**
 * Created by MyPC on 2016/8/2.
 */
public class PostMoreHelper {

    private static PostMoreHelper helper;
    private Retrofit retrofit;
    private IGamesService service;
    private Gson gson;
    private PostMoreHelper(){
        gson = new GsonBuilder()
                .serializeNulls()
                .create();
        retrofit = new Retrofit.Builder()
                .addConverterFactory(new PostMoreFactory())
                .baseUrl(UrlConfig.Path.BASE_URL)
                .build();

        service = retrofit.create(IGamesService.class);
    }

    public IGamesService getService(){
        return service;
    }
    public static synchronized PostMoreHelper newInstance(){
        if (helper == null){
            helper = new PostMoreHelper();
        }
        return helper;
    }
}
