package com.example.mypc.esports2.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyTeamActivity extends BaseActivity {

    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.tv_add_team)
    ImageView tvAddTeam;
    @BindView(R.id.rl_layout_team)
    RelativeLayout rlLayoutTeam;
    @BindView(R.id.lv_team_list)
    ListView lvTeamList;
    @BindView(R.id.btn_add_team)
    Button btnAddTeam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_my_team;
    }

    @OnClick({R.id.on_back_image, R.id.tv_add_team, R.id.btn_add_team})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.on_back_image:
                onBackPressed();
                break;
            case R.id.tv_add_team:
                Toast.makeText(this, "添加战队", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_add_team:
                Toast.makeText(this, "添加队伍", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
