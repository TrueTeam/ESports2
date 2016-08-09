package com.example.mypc.esports2.main.creatteam;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class CreatTeamActivity extends BaseActivity {


    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.layout_selector_game)
    LinearLayout layoutSelectorGame;
    @BindView(R.id.layout_add_friend)
    LinearLayout layoutAddFriend;
    @BindView(R.id.btn_craeat_team)
    Button btnCraeatTeam;

    @Override
    public int getLayoutID() {
        return R.layout.activity_creat_team;
    }


    @OnClick({R.id.on_back_image, R.id.layout_selector_game, R.id.layout_add_friend, R.id.btn_craeat_team})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.on_back_image:
                onBackPressed();
                break;
            case R.id.layout_selector_game:
                Toast.makeText(CreatTeamActivity.this,"选择游戏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.layout_add_friend:
                Toast.makeText(CreatTeamActivity.this,"添加好友", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_craeat_team:
                Toast.makeText(CreatTeamActivity.this,"创建战队", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
