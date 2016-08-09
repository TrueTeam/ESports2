package com.example.mypc.esports2.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class UnLoginFragment extends Fragment {


    @BindView(R.id.btn_un_login)
    Button btnUnLogin;
    private boolean flag;

    public UnLoginFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_un_login, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.btn_un_login)
    public void onClick() {
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }
}
