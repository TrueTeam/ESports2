package com.example.mypc.esports2.gamelib.matchinnerfragment;

import com.example.mypc.esports2.bean.GamesBean;
import com.example.mypc.esports2.config.UrlConfig;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MyPC on 2016/8/2.
 */
public class MatchInnerFragmentPersenter implements MatchInnerFragmentContract.Persenter{

    private MatchInnerFragmentContract.View mView;
    private MatchInnerFragmentContract.Model mModel;
    public MatchInnerFragmentPersenter(MatchInnerFragmentContract.View view, MatchInnerFragmentContract.Model model){
        this.mView = view;
        this.mModel = model;
    }
    @Override
    public void getData(int position) {
        HashMap<String,String> params = new HashMap<>();
        String[] array = new String[]{"144","110","115","226"};
        params.put(UrlConfig.KEY.GAME_ID,array[position]);
        params.put(UrlConfig.KEY.PAGE,"1");
        mModel.getData(UrlConfig.ThumbnailPath.GAMES,params, new Callback<List<GamesBean>>() {
            @Override
            public void onResponse(Call<List<GamesBean>> call, Response<List<GamesBean>> response) {
                List<GamesBean> gamesBeen = response.body();
                mView.onSuccess(gamesBeen);
            }

            @Override
            public void onFailure(Call<List<GamesBean>> call, Throwable t) {
                mView.onFild("加载失败");
            }
        });

    }
}
