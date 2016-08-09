package com.example.mypc.esports2.main.news.newsinner;

import com.example.mypc.esports2.base.IBaseModel;
import com.example.mypc.esports2.base.IBasePersenter;
import com.example.mypc.esports2.base.IBaseView;
import com.example.mypc.esports2.bean.NewsBean;

import java.util.HashMap;

import retrofit2.Callback;


/**
 * Created by peter on 2016/8/2.
 */
public class NewsInnerContract {
    public interface View extends IBaseView {
        void onSuccess(NewsBean newsBean);

        void onFail(String msg);
    }

    public interface Mode extends IBaseModel {
        void getData(HashMap<String, String> params, Callback<NewsBean> callback);
    }

    public interface Presenter extends IBasePersenter {
        void getData(String id);
    }
}
