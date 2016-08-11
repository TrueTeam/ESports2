package com.example.mypc.esports2.httputils;

import com.example.mypc.esports2.bean.PostHotBean;
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
public class PostMoreFactory extends Converter.Factory {
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new FindConvert();
    }
    static class FindConvert implements  Converter<ResponseBody, List<PostHotBean>>{

        @Override
        public List<PostHotBean> convert(ResponseBody value) throws IOException {
            String result = value.string();

            List<PostHotBean> mList = new ArrayList<>();
            try {
                List<String>stringList=new ArrayList<>();
                JSONArray json = new JSONArray(result);
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
                    String create_time = object.getString("create_time");
                    String circle_title = object.getString("circle_title");
                    String is_praise = object.getString("is_praise");
                    String head_link = object.getString("head_link");
                    JSONArray pic_lists = object.getJSONArray("pic_lists");
                    for (int y = 0; y <pic_lists.length() ; y++) {
                        String string = pic_lists.getString(y);
                        stringList.add(string);
                    }
                    PostHotBean bean=new PostHotBean(id,content,icon,pic,uid,nickname,head,praises,reviews,create_time,circle_title,is_praise,head_link,stringList);
                    mList.add(bean);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return mList;
        }
    }
}
