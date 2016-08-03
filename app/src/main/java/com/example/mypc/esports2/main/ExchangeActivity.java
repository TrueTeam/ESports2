package com.example.mypc.esports2.main;

import android.widget.ImageView;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ExchangeActivity extends BaseActivity {


    @BindView(R.id.on_back_image)
    ImageView onBackImage;




    @OnClick(R.id.on_back_image)
    public void onClick() {
        onBackPressed();
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_exchange;
    }
}
