package com.example.mypc.esports2.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypc.esports2.MyApp;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.bean.UserBean;
import com.example.mypc.esports2.httputils.register.UserDao;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginFragment extends Fragment {


    @BindView(R.id.et_login_accont)
    TextInputEditText etLoginAccont;
    @BindView(R.id.et_login_password)
    TextInputEditText etLoginPassword;
    @BindView(R.id.tv_login_findpassword)
    TextView tvLoginFindpassword;
    @BindView(R.id.btn_login_login)
    Button btnLoginLogin;
    @BindView(R.id.ll_login_sepreate)
    LinearLayout llLoginSepreate;
    @BindView(R.id.iv_login_qq)
    ImageView ivLoginQq;
    @BindView(R.id.iv_login_wechat)
    ImageView ivLoginWechat;
    private UMShareAPI umShareAPI;
    private SHARE_MEDIA platform;
    private SHARE_MEDIA weixin;
    private SHARE_MEDIA platform1;

    public LoginFragment() {

    }
    public interface onLoginSuccessListener {
        void onRegisterSuccess();
    }

    private onLoginSuccessListener listener;

    public void setOnflagChangerListener(onLoginSuccessListener listener) {
        this.listener = listener;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        umShareAPI = UMShareAPI.get(getActivity());
        return view;
    }

    @OnClick({R.id.tv_login_findpassword, R.id.btn_login_login, R.id.iv_login_qq, R.id.iv_login_wechat})
    public void onClick(View view) {
        String accont = etLoginAccont.getText().toString().trim();
        String password = etLoginPassword.getText().toString().trim();
        switch (view.getId()) {
            case R.id.tv_login_findpassword:
                //找回密码操作
                break;
            case R.id.btn_login_login:
                if (!TextUtils.isEmpty(accont) && !TextUtils.isEmpty(password)) {
                    List<UserBean> beanList = UserDao.QueryOne(getActivity(), "username", accont);
                    if (beanList.size() == 0) {
                        etLoginAccont.setError("用户名不存在");
                    } else {
                        if (password.equals(beanList.get(0).getPassword())) {
                            MyApp.setFalg(true);
                            listener.onRegisterSuccess();
                            Toast.makeText(getActivity(), "登陆成功", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getActivity(), "用户名或密码错误，请重新输入", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else if (!TextUtils.isEmpty(accont) && TextUtils.isEmpty(password)) {
                    etLoginPassword.setError("请输入密码");
                } else if (TextUtils.isEmpty(accont) && !TextUtils.isEmpty(password)) {
                    etLoginAccont.setError("请输入用户名");
                } else {
                    Toast.makeText(getActivity(), "请输入用户名和密码", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.iv_login_qq:
                platform = SHARE_MEDIA.DOUBAN;
                umShareAPI.doOauthVerify(getActivity(), platform, umAuthListener);
                break;
            case R.id.iv_login_wechat:
                platform = SHARE_MEDIA.RENREN;
                umShareAPI.doOauthVerify(getActivity(), platform, umAuthListener);
                break;

        }
    }
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getActivity(), "Authorize succeed", Toast.LENGTH_SHORT).show();
        }


        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getActivity(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( getActivity(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        umShareAPI.deleteOauth(getActivity(), platform, umAuthListener);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        umShareAPI.onActivityResult(requestCode, resultCode, data);
    }
}
