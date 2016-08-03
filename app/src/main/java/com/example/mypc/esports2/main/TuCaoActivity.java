package com.example.mypc.esports2.main;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class TuCaoActivity extends BaseActivity {

    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.rl_tucao)
    RelativeLayout rlTucao;
    @BindView(R.id.tu_cao_spi)
    Spinner tuCaoSpi;
    @BindView(R.id.et_tu_cao)
    EditText etTuCao;
    @BindView(R.id.btn_add_team)
    Button btnAddTeam;



    @OnClick({R.id.on_back_image, R.id.btn_add_team})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.on_back_image:
                onBackPressed();
                break;
            case R.id.btn_add_team:
                Toast.makeText(this,"确认提交",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_tu_cao;
    }
}
