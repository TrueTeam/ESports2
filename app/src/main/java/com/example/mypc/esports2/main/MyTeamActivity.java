package com.example.mypc.esports2.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;
import com.example.mypc.esports2.main.creatteam.CreatTeamActivity;
import com.example.mypc.esports2.main.joininteam.JoinInTeamActivity;

import butterknife.BindView;
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
    @BindView(R.id.tv_empty_view)
    TextView tvEmptyView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lvTeamList.setEmptyView(tvEmptyView);
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
                startActivity(new Intent(MyTeamActivity.this,JoinInTeamActivity.class));
                break;
            case R.id.btn_add_team:
                startActivity(new Intent(MyTeamActivity.this, CreatTeamActivity.class));
                break;
        }
    }
}
