package com.example.mypc.esports2.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MyMatchActivity extends BaseActivity {


    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.btn_rb_begin)
    RadioButton btnRbBegin;
    @BindView(R.id.rb_btn_over)
    RadioButton rbBtnOver;
    @BindView(R.id.recyview_match)
    RecyclerView recyviewMatch;



    @OnClick({R.id.on_back_image, R.id.btn_rb_begin, R.id.rb_btn_over})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.on_back_image:
                onBackPressed();
                break;
            case R.id.btn_rb_begin:
                Toast.makeText(this, "进行中", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_btn_over:
                Toast.makeText(this, "已结束", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_my_match;
    }
}
