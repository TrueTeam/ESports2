package com.example.mypc.esports2.main.news.newscomment;

import com.example.mypc.esports2.base.IBaseModel;
import com.example.mypc.esports2.base.IBasePersenter;
import com.example.mypc.esports2.base.IBaseView;
import com.example.mypc.esports2.bean.CommentBean;

import java.util.HashMap;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by peter on 2016/8/5.
 */
public class NewsCommentContract {

    public interface View extends IBaseView {
        void onGethotCommentSuccess(List<CommentBean> commentBean);

        void onGethotCommentFail(String msg);
    }

    public interface Mode extends IBaseModel {
        void getCommentBean(HashMap<String, String> params, Callback<List<CommentBean>> callback);
    }

    public interface Presenter extends IBasePersenter {
        void getCommentBean(String id);
    }
}
