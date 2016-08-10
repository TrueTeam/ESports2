package com.example.mypc.esports2.httputils;

import android.util.Log;

import com.example.mypc.esports2.bean.CircleBean;
import com.example.mypc.esports2.bean.PostBean;
import com.example.mypc.esports2.config.UrlConfig;

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
public class FindPostFactory extends Converter.Factory {
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new FindConvert();
    }
    static class FindConvert implements  Converter<ResponseBody, List<PostBean>>{

        @Override
        public List<PostBean> convert(ResponseBody value) throws IOException {
            String result = value.string();

            List<PostBean> mList = new ArrayList<>();
            try {
                JSONArray json = new JSONArray(result);

//                List<String>tags=new ArrayList<>();
//
//                List<String>pic_lists=new ArrayList<>();
                for (int i = 0; i <json.length() ; i++) {
                    JSONObject object = json.getJSONObject(i);
                    String id = object.getString("id");
                    String content = object.getString("content");
                    String icon = object.getString("icon");
                    String pic = object.getString("pic");
                    String uid = object.getString("uid");
                    String nickname = object.getString("nickname");
                    String head = object.getString("head");
                    String praises = object.getString("praises");
                    String reviews = object.getString("reviews");
//                    JSONArray tag = object.getJSONArray("tags");
//                    for (int y = 0; y <tag.length() ; y++) {
//                        String string = tag.getString(i);
//                        tags.add(string);
//                    }
                    String create_time = object.getString("create_time");
                    String circle_title = object.getString("circle_title");
                    String is_praise = object.getString("is_praise");
//                    JSONArray pic_list = object.getJSONArray("pic_lists");
//                    for (int y = 0; y <pic_list.length() ; y++) {
//                        String string = pic_list.getString(i);
//                        pic_lists.add(string);
//                    }
                    String head_link = object.getString("head_link");
                    PostBean postBean=new PostBean(id,content,icon,pic,uid,nickname,head,praises,reviews,create_time,circle_title,is_praise,head_link);
                    mList.add(postBean);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return mList;
        }
    }
}
