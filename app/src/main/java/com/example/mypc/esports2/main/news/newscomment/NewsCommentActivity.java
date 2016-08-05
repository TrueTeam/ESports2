package com.example.mypc.esports2.main.news.newscomment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;
import com.example.mypc.esports2.bean.CommentBean;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class NewsCommentActivity extends BaseActivity implements NewsCommentContract.View {

    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.listview_hotcomment)
    ListView listviewHotcomment;
    @BindView(R.id.listview_newcomment)
    ListView listviewNewcomment;
    private NewsCommentContract.Presenter presenter;
    private NewsCommentContract.Mode mode;
    private NewsCommentAdapter adapter;

    @Override
    public int getLayoutID() {
        return R.layout.activity_news_comment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mode = new NewsCommentMode();
        presenter = new NewsCommentPresenter(mode, this);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        presenter.getCommentBean(id);
    }

    @OnClick(R.id.on_back_image)
    public void onClick() {
        finish();
    }

    @Override
    public void onGethotCommentSuccess(List<CommentBean> commentBean) {
        adapter = new NewsCommentAdapter(commentBean);
        listviewHotcomment.setAdapter(adapter);
    }

    @Override
    public void onGethotCommentFail(String msg) {

    }
}
