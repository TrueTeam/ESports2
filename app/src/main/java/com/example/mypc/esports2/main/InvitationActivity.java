package com.example.mypc.esports2.main;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mypc.esports2.MyApp;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class InvitationActivity extends BaseActivity {

    @BindView(R.id.iv_invitation)
    ImageView ivInvitation;
    @BindView(R.id.tv_invitation_code)
    TextView tvInvitationCode;
    @BindView(R.id.et_invitaion_code)
    EditText etInvitaionCode;
    @BindView(R.id.btn_invitation_commit)
    Button btnInvitationCommit;
    @BindView(R.id.on_back_image)
    ImageView onBackImage;


    @OnClick({R.id.iv_invitation, R.id.btn_invitation_commit, R.id.on_back_image})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.on_back_image:
                onBackPressed();
                break;
            case R.id.iv_invitation:
                ClipboardManager clip = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                clip.getText(); // 粘贴
                clip.setText(MyApp.getUid()); // 复制


                break;
            case R.id.btn_invitation_commit:
                // TODO: 2016/7/31 向服务器提交用户信息，增加蟠桃用户数量
                break;
        }
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_invitation;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvInvitationCode.setText(MyApp.getUid());
    }
}
