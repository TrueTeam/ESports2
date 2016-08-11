package com.example.mypc.esports2.httputils;

import com.example.mypc.esports2.adapter.CircleHotAdapter;
import com.example.mypc.esports2.bean.CircleHotBean;
import com.example.mypc.esports2.bean.PostBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by 强 on 2016/8/5.
 */
public class CircleHotFactory extends Converter.Factory {
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new FindConvert();
    }
    static class FindConvert implements  Converter<ResponseBody, List<CircleHotBean>>{

        @Override
        public List<CircleHotBean> convert(ResponseBody value) throws IOException {
            String result = value.string();

            List<CircleHotBean> mList = new ArrayList<>();
            try {
                JSONArray json = new JSONArray(result);
                for (int i = 0; i <json.length() ; i++) {
                    JSONObject object = json.getJSONObject(i);
                    JSONArray jsonArray = object.getJSONArray("circlelists");
                    for (int y = 0; y <jsonArray.length() ; y++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(y);
                        String id = jsonObject.getString("id");
                        String title = jsonObject.getString("title");
                        String logo = jsonObject.getString("logo");
                        String description = jsonObject.getString("description");
                        String users = jsonObject.getString("users");
                        String posts = jsonObject.getString("posts");
                        String is_open = jsonObject.getString("is_open");
                        String create_time = jsonObject.getString("create_time");
                        String cname = jsonObject.getString("cname");
                        CircleHotBean  bean=new CircleHotBean(id,title,logo,description,users,posts,is_open,create_time,cname);
                        mList.add(bean);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return mList;
        }
    }
}
