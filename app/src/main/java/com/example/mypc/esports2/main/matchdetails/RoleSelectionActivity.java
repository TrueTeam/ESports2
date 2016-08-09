package com.example.mypc.esports2.main.matchdetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;
import com.example.mypc.esports2.main.MyPartActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class RoleSelectionActivity extends BaseActivity {

    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.et_phone_number)
    EditText etPhoneNumber;
    @BindView(R.id.et_qq_number)
    EditText etQqNumber;
    @BindView(R.id.btn_add_role)
    Button btnAddRole;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_role_selection;
    }

    @OnClick({R.id.on_back_image, R.id.btn_add_role})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.on_back_image:
                onBackPressed();
                break;
            case R.id.btn_add_role:
                //// TODO: 2016/8/7  具体实现流程还没有加入,应该需要ORMLite来进行数据的存储
                startActivity(new Intent(this, MyPartActivity.class));
                break;
        }
    }
}
