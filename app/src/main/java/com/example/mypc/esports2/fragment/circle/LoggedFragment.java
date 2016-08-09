package com.example.mypc.esports2.fragment.circle;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypc.esports2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoggedFragment extends Fragment {


    @BindView(R.id.iv_circle_message)
    ImageView ivCircleMessage;
    @BindView(R.id.iv_circle_addfriend)
    ImageView ivCircleAddfriend;
    @BindView(R.id.tv_fans_cicle)
    TextView tvFansCicle;
    @BindView(R.id.tv_insert_cicle)
    TextView tvInsertCicle;
    @BindView(R.id.tv_team_cicle)
    TextView tvTeamCicle;
    @BindView(R.id.listview_message)
    ListView listviewMessage;

    public LoggedFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_logged_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.iv_circle_message, R.id.iv_circle_addfriend, R.id.tv_fans_cicle, R.id.tv_insert_cicle, R.id.tv_team_cicle})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_circle_message:
                Toast.makeText(getActivity(),"哈哈",Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_circle_addfriend:
                Toast.makeText(getActivity(),"哈哈",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_fans_cicle:
                Toast.makeText(getActivity(),"哈哈",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_insert_cicle:
                Toast.makeText(getActivity(),"哈哈",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_team_cicle:
                Toast.makeText(getActivity(),"哈哈",Toast.LENGTH_SHORT).show();
                break;
        }
    }


}
