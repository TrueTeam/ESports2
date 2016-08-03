package com.example.mypc.esports2.httputils;

/**
 * Created by MyPC on 2016/8/3.
 */
public class HttpUtils {
    private static HttpUtils instance;

    private HttpUtils() {
    }

    public static synchronized HttpUtils getInstance() {
        if (instance == null) {
            instance = new HttpUtils();
        }
        return instance;
    }

    public interface HttpCallBack<T> {
        public void onSucess(T t);

        public void onFail();
    }


}
