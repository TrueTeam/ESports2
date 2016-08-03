package com.example.mypc.esports2.main;

import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class AboutUsActivity extends BaseActivity {


    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.wb_about_us)
    WebView wbAboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                wbAboutUs.clearCache(true);
                wbAboutUs.loadUrl("http://139.196.106.200/Home/ItemWap/about");
            }
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_about_us;
    }


    @OnClick(R.id.on_back_image)
    public void onClick() {
        onBackPressed();
    }
}
