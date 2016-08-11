package com.example.mypc.esports2.fragment.registe;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypc.esports2.MyApp;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.bean.UserBean;
import com.example.mypc.esports2.httputils.register.UserDao;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RegisterFragment extends Fragment {


    @BindView(R.id.et_register_accont)
    TextInputEditText etRegisterAccont;
    @BindView(R.id.et_register_verification)
    EditText etRegisterVerification;
    @BindView(R.id.et_register_password)
    TextInputEditText etRegisterPassword;
    @BindView(R.id.tv_register_obtain)
    TextView tvRegisterFind;
    @BindView(R.id.btn_register_login)
    Button btnRegisterLogin;
    @BindView(R.id.cb_agreement)
    CheckBox cbAgreement;

    public RegisterFragment() {

    }

    public interface onRegisterSuccessListener {
        void onRegisterSuccess(UserBean userBean);
    }

    private onRegisterSuccessListener listener;

    public void setOnflagChangerListener(onRegisterSuccessListener listener) {
        this.listener = listener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        ButterKnife.bind(this, view);
        if (cbAgreement.isChecked()) {
            btnRegisterLogin.setClickable(true);
        } else {
            btnRegisterLogin.setClickable(false);
        }
        return view;
    }

    @OnClick({R.id.tv_register_obtain, R.id.btn_register_login})
    public void onClick(View view) {
        String accont = etRegisterAccont.getText().toString().trim();
        String password = etRegisterPassword.getText().toString().trim();
        switch (view.getId()) {
            case R.id.tv_register_obtain:
                break;
            case R.id.btn_register_login:
                if (accont.getBytes().length == 11 && password.length() >= 6 && btnRegisterLogin.isEnabled()) {
                    List<UserBean> beanList = UserDao.QueryOne(getActivity(), "username", accont);
                    String uid = randomUid();
                    MyApp.setUid(uid);
                    if (beanList.size() == 0) {
                        UserBean userBean = new UserBean();
                        userBean.setUsername(accont);
                        userBean.setPassword(password);
                        userBean.setUid(uid);
                        int add = UserDao.add(userBean, getActivity());
                        if (add > 0) {
                            MyApp.setFalg(true);
                            Toast.makeText(getActivity(), "注册成功", Toast.LENGTH_SHORT).show();
                            listener.onRegisterSuccess(userBean);
                        } else {
                            Toast.makeText(getActivity(), "注册失败", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        etRegisterAccont.setError("账号已存在，请更换手机号再试！");
                    }

                } else if (accont.getBytes().length != 11) {
                    etRegisterAccont.setError("请输入11位有效电话号码");
                } else if (accont.getBytes().length == 11 && password.length() < 6) {
                    etRegisterPassword.setError("请输入6位及以上密码");
                }
                break;
        }
    }

    private String randomUid() {
        long floor = (long) Math.floor(new Random().nextDouble() * 100000);
        String random = 1 + String.valueOf(floor);
        List<UserBean> beanList = UserDao.QueryOne(getActivity(), "uid", random);
        if (beanList.size() == 0) {
            return random;
        } else {
            randomUid();
        }
        return null;
    }
}
