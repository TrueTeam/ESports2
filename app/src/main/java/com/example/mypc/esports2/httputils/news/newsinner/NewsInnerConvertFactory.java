package com.example.mypc.esports2.httputils.news.newsinner;

import com.example.mypc.esports2.bean.AdBean;
import com.example.mypc.esports2.bean.ListBean;
import com.example.mypc.esports2.bean.NewsAD;

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
 * Created by peter on 2016/8/3.
 */
public class NewsInnerConvertFactory extends Converter.Factory {

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new NewsInnerConvert();
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
    }

    public class NewsInnerConvert implements Converter<ResponseBody, NewsAD> {

        @Override
        public NewsAD convert(ResponseBody value) throws IOException {
            String result = value.string();
            NewsAD newsAD = getNewsAD(result);
            return newsAD;
        }

        /**
         * id: "2742",
         * title: "8月12日上线 新冒险卡拉赞之夜内容汇总",
         * cover: "32705a72cc832b674dd980eb668e7f3b55f27e29",
         * link: "http://139.196.106.200/Home/ItemWap/info/id/2742",
         * cover_link: "http://139.196.106.200/Uploads/Picture/2016-07-30/579bff22ed537.jpg
         */

        private NewsAD getNewsAD(String result) {
            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("ad");
                List<AdBean> adlist = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    String id = object.getString("id");
                    String title = object.getString("title");
                    String cover = object.getString("cover");
                    String link = object.getString("link");
                    String cover_link = object.getString("cover_link");
                    AdBean adBean = new AdBean(id, title, cover, link, cover_link);
                    adlist.add(adBean);
                }

                /*
                * id: "2788",
                click: "1371",
                title: "[资讯]排名对战2016年八月赛季卡背奖励——麦迪文的邀请函",
                create_time: "1470101400",
                is_home: "0",
                cover: "a7e388ab2f0289348283e74a758cdd29dbb1b720",
                content: "http://www.gvgcn.com/Home/ItemWap/info/id/2788",
                keywords: "卡背",
                praise: "1",
                comments: "0",
                collect: "0",
                ispraise: "0",
                iscollect: "0",
                tags: [
                "http://139.196.106.200/Uploads/Picture/2016-05-19/573d684d8a874.png"
                ],
                cover_link: "http://139.196.106.200/Uploads/Picture/2016-08-02/579ffa0041b88.jpg"
                * */

                JSONArray detailArray = jsonObject.getJSONArray("list");
                List<ListBean> detailList = new ArrayList<>();
                for (int j = 0; j < detailArray.length(); j++) {
                    JSONObject detailobject = detailArray.getJSONObject(j);
                    String id = detailobject.getString("id");
                    String click = detailobject.getString("click");
                    String title = detailobject.getString("title");
                    String create_time = detailobject.getString("create_time");
                    String is_home = detailobject.getString("is_home");
                    String cover = detailobject.getString("cover");
                    String content = detailobject.getString("content");
                    String keywords = detailobject.getString("keywords");
                    String praise = detailobject.getString("praise");
                    String comments = detailobject.getString("comments");
                    String collect = detailobject.getString("collect");
                    String ispraise = detailobject.getString("ispraise");
                    String iscollect = detailobject.getString("iscollect");
                    String cover_link = detailobject.getString("cover_link");
                    ListBean detail = new ListBean(id, click, title, create_time, is_home, cover, content, keywords, praise, comments, collect, ispraise, iscollect, cover_link);
                    detailList.add(detail);
                }

                NewsAD newsAD = new NewsAD(adlist, detailList);
                return newsAD;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
