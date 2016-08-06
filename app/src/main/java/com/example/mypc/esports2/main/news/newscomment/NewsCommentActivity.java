package com.example.mypc.esports2.main.news.newscomment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
    @BindView(R.id.et_comment_content)
    EditText etCommentContent;
    @BindView(R.id.btn_commit_comment)
    Button btnCommitComment;
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


    @Override
    public void onGethotCommentSuccess(List<CommentBean> commentBean) {
        adapter = new NewsCommentAdapter(commentBean);
        listviewHotcomment.setAdapter(adapter);
        listviewNewcomment.setAdapter(adapter);
        setListViewHeightBasedOnChildren(listviewHotcomment);
        setListViewHeightBasedOnChildren(listviewNewcomment);
    }

    @Override
    public void onGethotCommentFail(String msg) {

    }

    //动态设置listview的高度方法
    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() + 1));
        listView.setLayoutParams(params);
    }

    @OnClick({R.id.on_back_image, R.id.btn_commit_comment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.on_back_image:
                finish();
                break;
            case R.id.btn_commit_comment:
                etCommentContent.setText("");
                Toast.makeText(NewsCommentActivity.this, "已发送", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
