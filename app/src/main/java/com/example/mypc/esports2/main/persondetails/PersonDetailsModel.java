package com.example.mypc.esports2.main.persondetails;


import com.example.mypc.esports2.bean.PersonDetailsBean;
import com.example.mypc.esports2.httputils.persondetails.PersonHttpHelper;

import java.util.HashMap;

import retrofit2.Callback;


/**
 * Created by MyPC on 2016/8/5.
 */
public class PersonDetailsModel implements PersonDetailsContract.Model {
    @Override
    public void getDate(String path, HashMap<String, String> params, Callback<PersonDetailsBean> callback) {
        PersonHttpHelper.newInstance().getService().getPersonDetailsBean(path,params).enqueue(callback);
    }
}
