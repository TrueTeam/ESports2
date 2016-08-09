package com.example.mypc.esports2.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

    private SharedPreferences sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = getSharedPreferences("tucao", MODE_PRIVATE);

    }

    @OnClick({R.id.on_back_image, R.id.btn_add_team})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.on_back_image:
                onBackPressed();
                break;
            case R.id.btn_add_team:

                String yijian = tuCaoSpi.getSelectedItem().toString();
                String trim = etTuCao.getText().toString().trim();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("title", yijian);
                editor.putString("context", trim);
                boolean resule = editor.commit();
                if (resule) {
                    Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
                    etTuCao.setText("");
                    tuCaoSpi.setSelection(0);
                    break;
                }
        }
    }



    @Override
    public int getLayoutID() {
        return R.layout.activity_tu_cao;
    }
}
