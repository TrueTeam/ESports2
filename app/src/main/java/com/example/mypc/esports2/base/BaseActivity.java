package com.example.mypc.esports2.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by MyPC on 2016/8/1.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbind;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        unbind = ButterKnife.bind(this);
    }
    public abstract int getLayoutID();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbind.unbind();
    }
}
