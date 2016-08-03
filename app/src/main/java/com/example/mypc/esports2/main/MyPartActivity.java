package com.example.mypc.esports2.main;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MyPartActivity extends BaseActivity {


    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.add_my_player)
    ImageView addMyPlayer;
    @BindView(R.id.btn_add_my_player)
    Button btnAddMyPlayer;


    @Override
    public int getLayoutID() {
        return R.layout.activity_my_part;
    }

    @OnClick({R.id.on_back_image, R.id.add_my_player, R.id.btn_add_my_player})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.on_back_image:
                onBackPressed();
                break;
            case R.id.add_my_player:
                Toast.makeText(this,"添加角色",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_add_my_player:
                Toast.makeText(this,"添加角色",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
