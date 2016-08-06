package com.example.mypc.esports2.httputils.news;

import com.example.mypc.esports2.bean.ArticalBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by peter on 2016/8/4.
 */
public class NewsConvertFactory extends Converter.Factory {

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new NewsConvert();
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
    }

    public class NewsConvert implements Converter<ResponseBody, List<ArticalBean>> {

        @Override
        public List<ArticalBean> convert(ResponseBody value) throws IOException {
            String result = value.string();
            List<ArticalBean> articalBean = getArtical(result);
            return articalBean;
        }

        private List<ArticalBean> getArtical(String result) {
            List<ArticalBean> list = new ArrayList<>();
            try {
                JSONArray jsonArray = new JSONArray(result);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    String id = object.getString("id");
                    String title = object.getString("title");
                    String model_alias = object.getString("model_alias");
                    String model_title = object.getString("model_title");
                    String has_service = object.getString("has_service");
                    ArticalBean articalBean = new ArticalBean(id, title, model_alias, model_title, has_service);
                    list.add(articalBean);
                }
                return list;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
