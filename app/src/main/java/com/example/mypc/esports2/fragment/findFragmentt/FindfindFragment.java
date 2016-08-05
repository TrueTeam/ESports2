package com.example.mypc.esports2.fragment.findFragmentt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.print.PrintHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.adapter.FindcircleAdapter;
import com.example.mypc.esports2.adapter.FindpostAdapter;
import com.example.mypc.esports2.bean.CircleBean;
import com.example.mypc.esports2.bean.PostBean;
import com.example.mypc.esports2.config.UrlConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 强 on 2016/8/4.
 */
public class FindfindFragment extends Fragment  implements FindFragmentContract.View,FindpostFragmentContract.View{
    @BindView(R.id.find_topic_textView)
    TextView findTopicTextView;
    @BindView(R.id.find_circle_textView)
    TextView findCircleTextView;
    @BindView(R.id.gridView_circle_find)
    GridView gridViewCircleFind;
    @BindView(R.id.find_post_textView)
    TextView findPostTextView;
    @BindView(R.id.gridView_post_find)
    GridView gridViewPostFind;
    private FindcircleAdapter findcircleAdapter;
    private FindpostAdapter findpostAdapter;
    private FindFragmentPersenter presenter;
    private FindFragmentContract.Model model;
    private FindpostFragmentContract.Model postModel;
    private FindFragmentPostPersenter postPersenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_find, container, false);
        ButterKnife.bind(this, view);
        model=new FindFragmentModel();
        presenter=new FindFragmentPersenter(this,model);
        presenter.initData();

        postModel=new FindpostFragmentModel();
        postPersenter=new FindFragmentPostPersenter(this,postModel);
        postPersenter.initData();
        return view;
    }

    @OnClick({R.id.find_topic_textView, R.id.find_circle_textView, R.id.find_post_textView})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.find_topic_textView:
                Toast.makeText(getActivity(), "第一个", Toast.LENGTH_SHORT).show();
                break;
            case R.id.find_circle_textView:
                Toast.makeText(getActivity(), "第二个", Toast.LENGTH_SHORT).show();
                break;
            case R.id.find_post_textView:
                Toast.makeText(getActivity(), "第三个", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onSuccess(List<CircleBean> list) {
        findcircleAdapter=new FindcircleAdapter(list);
        gridViewCircleFind.setAdapter(findcircleAdapter);
    }


    @Override
    public void onFail(String msg) {
        Toast.makeText(getContext(),msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccesspost(List<PostBean> list) {
        int size = list.size();
        findpostAdapter=new FindpostAdapter(list);
        gridViewPostFind.setAdapter(findpostAdapter);
    }

    @Override
    public void onFailpost(String msg) {
        Toast.makeText(getContext(),msg, Toast.LENGTH_SHORT).show();
    }
}
