package com.example.mypc.esports2.httputils.news.newsdetail;

import android.util.Log;

import com.example.mypc.esports2.bean.NewsDetailBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by peter on 2016/8/5.
 */
public class NewsDetailConvertFactory extends Converter.Factory {

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new NewsDetailConvert();
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
    }

    public class NewsDetailConvert implements Converter<ResponseBody, NewsDetailBean> {

        @Override
        public NewsDetailBean convert(ResponseBody value) throws IOException {
            String result = value.string();
            NewsDetailBean newsDetail = getNewsDetailBean(result);
            return newsDetail;
        }

        private NewsDetailBean getNewsDetailBean(String result) {
            Gson gson = new GsonBuilder()
                    .serializeNulls()
                    .create();
            NewsDetailBean newsDetailBean = gson.fromJson(result, NewsDetailBean.class);
            return newsDetailBean;
        }
    }
}
