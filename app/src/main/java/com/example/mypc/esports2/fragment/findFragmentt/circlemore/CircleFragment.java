package com.example.mypc.esports2.fragment.findFragmentt.circlemore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.adapter.CircleHotAdapter;
import com.example.mypc.esports2.bean.CircleHotBean;
import com.example.mypc.esports2.fragment.findFragmentt.topicmore.TopicActivityContract;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CircleFragment extends Fragment  implements CircleFragmentContract.View{


    @BindView(R.id.gridView_circle)
    GridView gridViewCircle;
    private CircleFragmentContract.Model model;
    private CircleFragmentContract.Persenter persenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_circle, container, false);
        ButterKnife.bind(this, view);
        model=new CircleFragmentModel();
        persenter=new CircleFragmentPersenter(this,model);
        persenter.initData();

        return view;
    }

    @Override
    public void onSuccess(List<CircleHotBean> list) {
        CircleHotAdapter adapter=new CircleHotAdapter(list);
        gridViewCircle.setAdapter(adapter);
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }
}
