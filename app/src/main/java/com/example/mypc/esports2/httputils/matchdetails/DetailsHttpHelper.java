package com.example.mypc.esports2.httputils.matchdetails;

import com.example.mypc.esports2.config.UrlConfig;
import com.example.mypc.esports2.httputils.IGamesService;

import retrofit2.Retrofit;

/**
 * Created by MyPC on 2016/8/4.
 */
public class DetailsHttpHelper {
    private static DetailsHttpHelper helper;
    private final Retrofit retrofit;
    private final IGamesService service;

    private DetailsHttpHelper(){
        retrofit = new Retrofit.Builder()
                .addConverterFactory(new DetailsConvertFactory())
                .baseUrl(UrlConfig.Path.BASE_URL)
                .build();

        service = retrofit.create(IGamesService.class);
    }
    public IGamesService getService(){
        return service;
    }
    public static synchronized DetailsHttpHelper newInstance(){
        if (helper == null){
            helper = new DetailsHttpHelper();
        }
        return helper;
    }
}
