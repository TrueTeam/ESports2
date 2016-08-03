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

public class MyReplyActivity extends BaseActivity {


    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.btn_rb_pinglun)
    RadioButton btnRbPinglun;
    @BindView(R.id.rb_btn_me)
    RadioButton rbBtnMe;
    @BindView(R.id.recyview_reply)
    RecyclerView recyviewReply;



    @OnClick({R.id.on_back_image, R.id.btn_rb_pinglun, R.id.rb_btn_me})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.on_back_image:
                onBackPressed();
                break;
            case R.id.btn_rb_pinglun:
                Toast.makeText(this, "我评论的", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_btn_me:
                Toast.makeText(this, "回复我的", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    @Override
    public int getLayoutID() {
        return R.layout.activity_my_reply;
    }
}
