package com.example.mypc.esports2.fragment.registe;

import android.content.Context;

/**
 * Created by peter on 2016/8/8.
 */
public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.Mode mode;
    private RegisterContract.View view;

//    public interface onGetaddResultListener {
//        void onGetaddResult(int result);
//    }
//
//    private onGetaddResultListener listener;

    public RegisterPresenter(RegisterContract.Mode mode, RegisterContract.View view) {
        this.mode = mode;
        this.view = view;
    }

    @Override
    public void registerUser(Context context, String username, String password) {
        int i = mode.registerUser(context, username, password);
        if (i > 0) {
            view.onRegisterSuccess();
        } else {
            view.onRegisterFail();
        }
    }
}
