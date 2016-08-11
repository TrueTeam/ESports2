package com.example.mypc.esports2.fragment.findFragmentt.topicmore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.adapter.TopicMoreAdapter;
import com.example.mypc.esports2.bean.TopicMoreBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TopicMoreActivity extends AppCompatActivity implements TopicActivityContract.View{

    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.listview_topic)
    ListView listviewTopic;
    private TopicActivityContract.Model model;
    private TopicActivityContract.Persenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_more);
        ButterKnife.bind(this);
        model=new TopicActivityModel();
        persenter=new TopicActivityPersenter(this,model);
        persenter.initData();
    }

    @OnClick(R.id.on_back_image)
    public void onClick() {
        finish();
    }

    @Override
    public void onSuccess(List<TopicMoreBean> list) {
        TopicMoreAdapter adapter=new TopicMoreAdapter(list);
        listviewTopic.setAdapter(adapter);
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
