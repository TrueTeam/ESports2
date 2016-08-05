package com.example.mypc.esports2.httputils;

import com.example.mypc.esports2.config.UrlConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;

/**
 * Created by MyPC on 2016/8/2.
 */
public class FindHttpHelper {

    private static FindHttpHelper helper;
    private Retrofit retrofit;
    private IGamesService service;
    private Gson gson;
    private FindHttpHelper(){
        gson = new GsonBuilder()
                .serializeNulls()
                .create();
        retrofit = new Retrofit.Builder()
                .addConverterFactory(new  FindConverFactory())
                .baseUrl(UrlConfig.Path.BASE_URL)
                .build();

        service = retrofit.create(IGamesService.class);
    }

    public IGamesService getService(){
        return service;
    }
    public static synchronized FindHttpHelper newInstance(){
        if (helper == null){
            helper = new FindHttpHelper();
        }
        return helper;
    }
}
