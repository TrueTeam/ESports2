package com.example.mypc.esports2.gamelib.matchinnerfragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.bean.GamesBean;
import com.example.mypc.esports2.main.matchdetails.MatchDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchInnerFragment extends Fragment implements MatchInnerFragmentContract.View {
    private MatchInnerFragmentContract.Model modle;
    private MatchInnerFragmentContract.Persenter persenter;
    private Handler handle = new Handler();
    private List<GamesBean> mList;
    private MatchInnerAdapter mPagerAdapter;
    @BindView(R.id.recy_view_inner)
    RecyclerView recyViewInner;
    public int mPosition;

    public MatchInnerFragment() {

    }

    public MatchInnerFragment(int position) {
        this.mPosition = position;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_games_inner, container, false);
        ButterKnife.bind(this, view);
        mList = new ArrayList<>();
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyViewInner.setLayoutManager(llm);
        mPagerAdapter = new MatchInnerAdapter(R.layout.inner_recyview_layout, mList);
        recyViewInner.setAdapter(mPagerAdapter);
        mPagerAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                    String id = mList.get(i).getId();
                    String matchStatus = mList.get(i).getMatchStatus();
                    Intent intent = new Intent(getActivity(), MatchDetailsActivity.class);
                    intent.putExtra("id",id);
                    intent.putExtra("matchStatus",matchStatus);
                    startActivity(intent);


            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        modle = new MatchInnerFragmentModel();
        persenter = new MatchInnerFragmentPersenter(this, modle);
        persenter.getData(mPosition);

    }


    @Override
    public void onSuccess(final List<GamesBean> list) {
        handle.post(new Runnable() {
            @Override
            public void run() {
                mList.addAll(list);
                mPagerAdapter.notifyDataSetChanged();

            }
        });
    }

    @Override
    public void onFild(String erro) {
        Toast.makeText(getActivity(), "网络连接错误", Toast.LENGTH_SHORT).show();
    }

}
