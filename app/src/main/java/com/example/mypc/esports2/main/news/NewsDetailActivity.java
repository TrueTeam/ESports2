package com.example.mypc.esports2.main.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;
import com.example.mypc.esports2.bean.AdBean;
import com.example.mypc.esports2.bean.ListBean;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.OnClick;

public class NewsDetailActivity extends BaseActivity {


    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.webview_detail)
    WebView webviewDetail;
    @BindView(R.id.iv_news_detail)
    ImageView ivNewsDetail;
    @BindView(R.id.tv_detail_read)
    TextView tvDetailRead;
    @BindView(R.id.tv_detail_praise)
    TextView tvDetailPraise;
    @BindView(R.id.tv_detail_comment)
    TextView tvDetailComment;

    @Override
    public int getLayoutID() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        ListBean listbean = (ListBean) intent.getSerializableExtra("listbean");
        AdBean adbean = (AdBean) intent.getSerializableExtra("adbean");
        WebSettings settings = webviewDetail.getSettings();
        settings.setJavaScriptEnabled(true);
        if (listbean!=null){
            String content = listbean.getContent();
            webviewDetail.loadUrl(content);
            webviewDetail.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    webviewDetail.loadUrl(url);
                    return true;
                }
            });

            String praise = listbean.getPraise();
            String click = listbean.getClick();
            String comments = listbean.getComments();
            tvDetailComment.setText(comments);
            tvDetailPraise.setText(praise);
            tvDetailRead.setText(click);
        }else{
            String link = adbean.getLink();
            webviewDetail.loadUrl(link);
            webviewDetail.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    webviewDetail.loadUrl(url);
                    return true;
                }
            });
        }

    }

    @OnClick({R.id.on_back_image, R.id.iv_news_detail})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.on_back_image:
                finish();
                break;
            case R.id.iv_news_detail:
                // TODO: 2016/8/5 添加评论页面
                break;
        }
    }
}
