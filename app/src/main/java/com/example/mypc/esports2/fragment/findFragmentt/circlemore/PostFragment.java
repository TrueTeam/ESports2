package com.example.mypc.esports2.fragment.findFragmentt.circlemore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.adapter.PostMoreAdapter;
import com.example.mypc.esports2.bean.PostHotBean;
import com.example.mypc.esports2.fragment.findFragmentt.topicmore.TopicActivityContract;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostFragment extends Fragment implements PostFragmentContract.View{

    @BindView(R.id.pullListView)
    PullToRefreshListView pullListView;
    private PostFragmentContract.Model model;
    private PostFragmentContract.Persenter persenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        ButterKnife.bind(this, view);
        model=new PostFragmentModel();
        persenter=new PostFragmentPersenter(this,model);
        persenter.initData();

        return view;
    }

    @Override
    public void onSuccess(List<PostHotBean> list) {
        PostMoreAdapter adapter=new PostMoreAdapter(list);
        pullListView.setAdapter(adapter);
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(getContext(),msg, Toast.LENGTH_SHORT).show();
    }
}
