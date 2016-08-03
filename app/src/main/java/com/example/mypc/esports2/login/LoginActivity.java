package com.example.mypc.esports2.login;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.adapter.LoginAdapter;
import com.example.mypc.esports2.base.BaseActivity;
import com.example.mypc.esports2.fragment.LoginFragment;
import com.example.mypc.esports2.fragment.RegisterFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.tablayout_login)
    TabLayout tablayoutLogin;
    @BindView(R.id.viewpager_login)
    ViewPager viewpagerLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] stringArray = getResources().getStringArray(R.array.logins);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new LoginFragment());
        fragments.add(new RegisterFragment());

        LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(), fragments);
        adapter.setmArray(stringArray);
        viewpagerLogin.setAdapter(adapter);
        tablayoutLogin.setupWithViewPager(viewpagerLogin);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_login;
    }



}

