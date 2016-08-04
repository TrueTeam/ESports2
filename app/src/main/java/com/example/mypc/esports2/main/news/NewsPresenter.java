package com.example.mypc.esports2.main.news;

import com.example.mypc.esports2.bean.Artical;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by peter on 2016/8/4.
 */
public class NewsPresenter implements NewsContract.Presenter {

    private NewsContract.Mode mode;
    private NewsContract.View view;

    public NewsPresenter(NewsContract.Mode mode, NewsContract.View view){
        this.mode = mode;
        this.view = view;
    }
    @Override
    public void getData() {
        mode.getData(new Callback<List<Artical>>() {
            @Override
            public void onResponse(Call<List<Artical>> call, Response<List<Artical>> response) {
                List<Artical> body = response.body();
                view.onSuccess(body);
            }

            @Override
            public void onFailure(Call<List<Artical>> call, Throwable t) {
                view.onFail("请求失败");
            }
        });
    }
}
