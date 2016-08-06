package com.example.mypc.esports2.main.news.newsdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;
import com.example.mypc.esports2.bean.AdBean;
import com.example.mypc.esports2.bean.ListBean;
import com.example.mypc.esports2.bean.NewsDetailBean;
import com.example.mypc.esports2.main.news.newscomment.NewsCommentActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class NewsDetailActivity extends BaseActivity implements NewsDetailContract.View {


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
    @BindView(R.id.iv_detail_comment)
    ImageView ivDetailComment;

    private String contentId;
    private NewsDetailContract.Presenter presenter;
    private NewsDetailContract.Mode mode;

    @Override
    public int getLayoutID() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mode = new NewsDetailMode();
        presenter = new NewsDetailPresenter(mode, this);
        Intent intent = getIntent();
        ListBean listbean = (ListBean) intent.getSerializableExtra("listbean");
        AdBean adbean = (AdBean) intent.getSerializableExtra("adbean");
        WebSettings settings = webviewDetail.getSettings();
        settings.setJavaScriptEnabled(true);

        if (listbean != null) {
            String content = listbean.getContent();
            contentId = listbean.getId();
            webviewDetail.loadUrl(content);

            String praise = listbean.getPraise();
            String click = listbean.getClick();
            String comments = listbean.getComments();
            tvDetailComment.setText(comments);
            tvDetailPraise.setText(praise);
            tvDetailRead.setText(click);
        } else {
            contentId = adbean.getId();
            //获取viewpager页面详情的内容
            presenter.getNewsdetailData(contentId);
        }

    }


    @Override
    public void onGetNewsdetailSuccess(NewsDetailBean newsDetail) {
        String content = newsDetail.getContent();
        webviewDetail.loadUrl(content);
        String click = newsDetail.getClick();
        String comments = newsDetail.getComments();
        String praise = newsDetail.getPraise();
        tvDetailComment.setText(comments);
        tvDetailPraise.setText(praise);
        tvDetailRead.setText(click);
    }

    @Override
    public void onGetNewsdetailFail(String msg) {
        Toast.makeText(NewsDetailActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.on_back_image, R.id.iv_news_detail, R.id.iv_detail_comment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.on_back_image:
                finish();
                break;
            case R.id.iv_news_detail:
            case R.id.iv_detail_comment:
                Intent intent = new Intent(NewsDetailActivity.this, NewsCommentActivity.class);
                intent.putExtra("id",contentId);
                startActivity(intent);
                break;
        }
    }
}
