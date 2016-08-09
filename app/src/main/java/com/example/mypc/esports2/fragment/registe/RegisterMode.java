package com.example.mypc.esports2.fragment.registe;

import android.content.Context;

import com.example.mypc.esports2.bean.UserBean;
import com.example.mypc.esports2.httputils.register.UserDao;

/**
 * Created by peter on 2016/8/8.
 */
public class RegisterMode implements RegisterContract.Mode {
    @Override
    public int registerUser(Context context, String username, String password) {
        UserBean userBean = new UserBean();
        userBean.setUsername(username);
        userBean.setPassword(password);
        int add = UserDao.add(userBean, context);
        return add;
    }
}
