package com.example.mypc.esports2.gamelib.matchinnerfragment;

import com.example.mypc.esports2.bean.GamesBean;
import com.example.mypc.esports2.httputils.games.GamesHttpHelper;

import java.util.HashMap;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by MyPC on 2016/8/2.
 */
public class MatchInnerFragmentModel implements MatchInnerFragmentContract.Model{


    @Override
    public void getData(String path,HashMap<String, String> params, Callback<List<GamesBean>> callback) {
        GamesHttpHelper.newInstance().getService().getHtml(path,params).enqueue(callback);
    }
}
