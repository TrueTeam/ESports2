package com.example.mypc.esports2.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class GamesDetailsActivity extends BaseActivity {

    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.web_details)
    WebView webDetails;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String content = intent.getStringExtra("content");
        webDetails.setWebViewClient(new WebViewClient());
        webDetails.loadUrl(content);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_games_details;
    }

    @OnClick(R.id.on_back_image)
    public void onClick() {
        onBackPressed();
    }
}
