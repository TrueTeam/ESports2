package com.example.mypc.esports2.fragment.registe;

import android.content.Context;

import com.example.mypc.esports2.base.IBaseModel;
import com.example.mypc.esports2.base.IBasePersenter;
import com.example.mypc.esports2.base.IBaseView;

import retrofit2.Callback;

/**
 * Created by peter on 2016/8/8.
 */
public class RegisterContract {

    public interface View extends IBaseView {
        void onRegisterSuccess();
        void onRegisterFail();
    }

    public interface Mode extends IBaseModel {
        int registerUser(Context context, String username, String password);
    }

    public interface Presenter extends IBasePersenter {
        void registerUser(Context context, String username, String password);
    }
}
