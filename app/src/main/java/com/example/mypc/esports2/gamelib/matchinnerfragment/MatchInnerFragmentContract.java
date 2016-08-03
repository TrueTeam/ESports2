package com.example.mypc.esports2.gamelib.matchinnerfragment;


import com.example.mypc.esports2.base.IBaseModel;
import com.example.mypc.esports2.base.IBasePersenter;
import com.example.mypc.esports2.base.IBaseView;
import com.example.mypc.esports2.bean.GamesBean;

import java.util.HashMap;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by MyPC on 2016/8/2.
 */
public class MatchInnerFragmentContract {

    public interface View extends IBaseView {
        void onSuccess(List<GamesBean> list);

        void onFild(String erro);
    }
    public interface Persenter extends IBasePersenter {
       void getData(int position);
    }
    public interface Model extends IBaseModel {
        void getData(String path,HashMap<String, String> params, Callback<List<GamesBean>> callback);
    }
}
