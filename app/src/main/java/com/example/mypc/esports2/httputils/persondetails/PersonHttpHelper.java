package com.example.mypc.esports2.httputils.persondetails;

import com.example.mypc.esports2.config.UrlConfig;
import com.example.mypc.esports2.httputils.IGamesService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MyPC on 2016/8/5.
 */
public class PersonHttpHelper {


    private final Retrofit retrofit;
    private final IGamesService service;
    private static PersonHttpHelper helper;

    private PersonHttpHelper(){
        Gson gson = new GsonBuilder().serializeNulls().create();
        retrofit = new Retrofit.Builder()
                 .addConverterFactory(GsonConverterFactory.create(gson))
                 .baseUrl(UrlConfig.Path.BASE_URL)
                 .build();

        service = retrofit.create(IGamesService.class);
    }

    public IGamesService getService(){
        return  service;
    }

    public static synchronized PersonHttpHelper newInstance(){
        if (helper == null){
            helper = new PersonHttpHelper();
        }
        return helper;
    }
}
