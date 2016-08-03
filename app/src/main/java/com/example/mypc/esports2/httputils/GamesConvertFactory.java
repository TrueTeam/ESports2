package com.example.mypc.esports2.httputils;

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
 * Created by zhonghang on 16/8/1.
 */

public class GamesConvertFactory extends Converter.Factory {

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new GamesConvert();
    }


    static class GamesConvert implements Converter<ResponseBody, List<GamesBean>> {

        @Override
        public List<GamesBean> convert(ResponseBody value) throws IOException {
            String result = value.string();
            List<GamesBean> mList = new ArrayList<>();
            try {
                JSONArray json = new JSONArray(result);
                for (int i = 0; i < json.length(); i++) {
                    JSONObject object = json.getJSONObject(i);
                    String id = object.getString("id");
                    String title = object.getString("title");
                    String apply_start_time = object.getString("apply_start_time");
                    String apply_end_time = object.getString("apply_end_time");
                    String start_time = object.getString("start_time");
                    String end_time = object.getString("end_time");
                    String match_nature = object.getString("match_nature");
                    String match_status = object.getString("match_status");
                    String cover_link = object.getString("cover_link");
                    GamesBean gb = new GamesBean(id,title,apply_start_time,apply_end_time,start_time
                    ,end_time,match_nature,match_status,cover_link);
                    mList.add(gb);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return mList;
        }
    }
}
