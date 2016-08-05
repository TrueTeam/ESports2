package com.example.mypc.esports2.main.news.newsdetail;

import com.example.mypc.esports2.base.IBaseModel;
import com.example.mypc.esports2.base.IBasePersenter;
import com.example.mypc.esports2.base.IBaseView;
import com.example.mypc.esports2.bean.NewsDetailBean;

import retrofit2.Callback;

/**
 * Created by peter on 2016/8/5.
 */
public class NewsDetailContract {

    public interface View extends IBaseView {
        void onGetNewsdetailSuccess(NewsDetailBean newsDetail);

        void onGetNewsdetailFail(String msg);
    }

    public interface Mode extends IBaseModel {
        void getNewsdetailData(String id, Callback<NewsDetailBean> callback);
    }

    public interface Presenter extends IBasePersenter {
        void getNewsdetailData(String id);
    }
}
