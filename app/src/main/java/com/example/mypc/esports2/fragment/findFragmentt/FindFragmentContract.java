package com.example.mypc.esports2.fragment.findFragmentt;

import com.example.mypc.esports2.base.IBaseModel;
import com.example.mypc.esports2.base.IBasePersenter;
import com.example.mypc.esports2.base.IBaseView;
import com.example.mypc.esports2.bean.CircleBean;
import com.example.mypc.esports2.bean.GamesBean;
import com.example.mypc.esports2.bean.PostBean;
import com.example.mypc.esports2.httputils.HttpUtils;

import java.util.HashMap;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by 强 on 2016/8/5.
 */
public class FindFragmentContract {
    public interface View extends IBaseView {
        public void onSuccess(List<CircleBean> list);
        public void onFail(String msg);
    }
    public interface Persenter extends IBasePersenter {
        public  void initData();

    }
    public interface Model extends IBaseModel {
        public void getCircle(String url, HashMap<String, String> params, Callback<List<CircleBean>> callback);
    }
}
