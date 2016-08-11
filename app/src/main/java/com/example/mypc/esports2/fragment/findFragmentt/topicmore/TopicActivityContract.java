package com.example.mypc.esports2.fragment.findFragmentt.topicmore;

import com.example.mypc.esports2.base.IBaseModel;
import com.example.mypc.esports2.base.IBasePersenter;
import com.example.mypc.esports2.base.IBaseView;
import com.example.mypc.esports2.bean.PostBean;
import com.example.mypc.esports2.bean.TopicMoreBean;

import java.util.HashMap;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by 强 on 2016/8/5.
 */
public class TopicActivityContract {
    public interface View extends IBaseView {
        public void onSuccess(List<TopicMoreBean> list);
        public void onFail(String msg);
    }
    public interface Persenter extends IBasePersenter {
        public  void initData();

    }
    public interface Model extends IBaseModel {
        public void getData(String url, HashMap<String, String> params, Callback<List<TopicMoreBean>> callback);
    }
}
