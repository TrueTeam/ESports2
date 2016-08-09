package com.example.mypc.esports2.main.joininteam;

import android.widget.ImageView;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class JoinInTeamActivity extends BaseActivity {


    @BindView(R.id.on_back_image)
    ImageView onBackImage;

    @Override
    public int getLayoutID() {
        return R.layout.activity_join_in_team;
    }


    @OnClick(R.id.on_back_image)
    public void onClick() {
        onBackPressed();
    }
}
