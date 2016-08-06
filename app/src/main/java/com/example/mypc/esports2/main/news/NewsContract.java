package com.example.mypc.esports2.main.news;

import com.example.mypc.esports2.base.IBaseModel;
import com.example.mypc.esports2.base.IBasePersenter;
import com.example.mypc.esports2.base.IBaseView;
import com.example.mypc.esports2.bean.ArticalBean;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by peter on 2016/8/4.
 */
public class NewsContract {

    public interface View extends IBaseView{
        void onSuccess(List<ArticalBean> list);
        void onFail(String msg);
    }

    public interface Mode extends IBaseModel{
        void getData(Callback<List<ArticalBean>> callback);
    }

    public interface Presenter extends IBasePersenter{
        void getData();
    }
}
