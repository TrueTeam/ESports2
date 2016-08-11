package com.example.mypc.esports2.httputils;

import android.util.Log;

import com.example.mypc.esports2.bean.PostBean;
import com.example.mypc.esports2.bean.TopicMoreBean;

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
public class TopicMoreFactory extends Converter.Factory {
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new FindConvert();
    }
    static class FindConvert implements  Converter<ResponseBody, List<TopicMoreBean>>{

        @Override
        public List<TopicMoreBean> convert(ResponseBody value) throws IOException {
            String result = value.string();

            List<TopicMoreBean> mList = new ArrayList<>();
            try {
                JSONArray json = new JSONArray(result);
                for (int i = 0; i <json.length() ; i++) {
                    JSONObject object = json.getJSONObject(i);
                    String id = object.getString("id");
                    String title = object.getString("title");
                    String pic = object.getString("pic");
                    String red_title = object.getString("red_title");
                    String red_count = object.getString("red_count");
                    String blue_title = object.getString("blue_title");
                    String blue_count = object.getString("blue_count");
                    String is_open = object.getString("is_open");
                    TopicMoreBean bean=new TopicMoreBean(id,title,pic,red_title,red_count,blue_title,blue_count,is_open);
                    mList.add(bean);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return mList;
        }
    }
}
