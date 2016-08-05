package com.example.mypc.esports2.httputils;

import android.text.Editable;
import android.util.Log;

import com.example.mypc.esports2.bean.CircleBean;
import com.example.mypc.esports2.bean.GamesBean;

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
public class FindConverFactory extends Converter.Factory {
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new FindConvert();
    }
    static class FindConvert implements  Converter<ResponseBody, List<CircleBean>>{

        @Override
        public List<CircleBean> convert(ResponseBody value) throws IOException {
            String result = value.string();
            List<CircleBean> mList = new ArrayList<>();
            try {
                JSONArray json = new JSONArray(result);
                for (int i = 0; i <json.length() ; i++) {
                    JSONObject object = json.getJSONObject(i);
                    String id = object.getString("id");
                    String title = object.getString("title");
                    String logo = object.getString("logo");
                    String description = object.getString("description");
                    String praises = object.getString("praises");
                    String users = object.getString("users");
                    String posts = object.getString("posts");
                    String follows = object.getString("follows");
                    String is_open = object.getString("is_open");
                    String create_time = object.getString("create_time");
                    String cname = object.getString("cname");
                    CircleBean circleBean= new CircleBean(id,title,logo,description,praises,users,posts,follows,is_open,create_time,cname);
                    mList.add(circleBean);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return mList;
        }
    }
}
