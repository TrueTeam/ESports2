package com.example.mypc.esports2.main.persondetails;

import com.example.mypc.esports2.base.IBaseView;
import com.example.mypc.esports2.bean.PersonDetailsBean;

import java.util.HashMap;

import retrofit2.Callback;


/**
 * Created by MyPC on 2016/8/5.
 */
public class PersonDetailsContract {

    public interface  View extends IBaseView{
        void onSuccess(PersonDetailsBean result);
        void onFail(String erro);
    }

    public interface Model{
        void getDate(String path, HashMap<String,String> params, Callback<PersonDetailsBean> callback);
    }

    public interface Persenter{
        void getDate(String s);
    }
}
