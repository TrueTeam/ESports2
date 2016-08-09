package com.example.mypc.esports2.fragment.registe;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RegisterFragment extends Fragment implements RegisterContract.View {


    @BindView(R.id.et_register_accont)
    TextInputEditText etRegisterAccont;
    @BindView(R.id.et_register_verification)
    EditText etRegisterVerification;
    @BindView(R.id.et_register_password)
    EditText etRegisterPassword;
    @BindView(R.id.tv_register_find)
    TextView tvRegisterFind;
    @BindView(R.id.btn_register_login)
    Button btnRegisterLogin;
    @BindView(R.id.cb_agreement)
    CheckBox cbAgreement;
    private RegisterContract.Presenter presenter;
    private RegisterContract.Mode mode;

    public RegisterFragment() {

    }

    public interface onRegisterSuccessListener {
        void onRegisterSuccess();
    }

    private onRegisterSuccessListener listener;

    public void setOnflagChangerListener(onRegisterSuccessListener listener){
        this.listener= listener;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        ButterKnife.bind(this, view);
        mode = new RegisterMode();
        presenter = new RegisterPresenter(mode, this);
        if (cbAgreement.isChecked()) {
            btnRegisterLogin.setClickable(true);
        }
        return view;
    }


    @Override
    public void onRegisterSuccess() {
        MyApp.setFalg(true);
        Toast.makeText(getActivity(), "注册成功", Toast.LENGTH_SHORT).show();
        Log.e("TAG", "RegisterFragment: "  );
        listener.onRegisterSuccess();
    }

    @Override
    public void onRegisterFail() {
        Toast.makeText(getActivity(), "注册失败", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.tv_register_find, R.id.btn_register_login})
    public void onClick(View view) {
        String accont = etRegisterAccont.getText().toString().trim();
        String password = etRegisterPassword.getText().toString().trim();
        switch (view.getId()) {
            case R.id.tv_register_find:
                break;
            case R.id.btn_register_login:
                if (accont.getBytes().length == 11 && btnRegisterLogin.isEnabled()) {
                    presenter.registerUser(getActivity(), accont, password);
                }
                break;
        }
    }
}
