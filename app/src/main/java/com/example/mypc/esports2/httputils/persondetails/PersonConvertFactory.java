package com.example.mypc.esports2.httputils.persondetails;

import com.example.mypc.esports2.bean.PersonDetailsBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by MyPC on 2016/8/5.
 */
public class PersonConvertFactory extends Converter.Factory {

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new PersonDetailsConvert();
    }
    static class PersonDetailsConvert implements Converter<ResponseBody, PersonDetailsBean> {

        @Override
        public PersonDetailsBean convert(ResponseBody value) throws IOException {
            String result = value.string();
            Gson gson = new GsonBuilder().serializeNulls().create();
            PersonDetailsBean detailsBean = gson.fromJson(result, PersonDetailsBean.class);
            return detailsBean;
        }
    }
}
