package com.example.mypc.esports2.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypc.esports2.MyApp;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;
import com.example.mypc.esports2.login.LoginActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {

    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.change_password)
    RelativeLayout changePassword;
    @BindView(R.id.version_mode)
    TextView versionMode;
    @BindView(R.id.now_version)
    RelativeLayout nowVersion;
    @BindView(R.id.clear_cache)
    RelativeLayout clearCache;
    @BindView(R.id.about_us)
    RelativeLayout aboutUs;
    @BindView(R.id.btn_user_exit)
    Button btnUsrExit;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (MyApp.getFalg()){
            btnUsrExit.setVisibility(View.VISIBLE);
            SharedPreferences preferences = getSharedPreferences("info.txt", MODE_PRIVATE);
            edit = preferences.edit();
            btnUsrExit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
                    builder.setTitle("提示").setMessage("您确定要退出当前账号么？");
                    builder.setNegativeButton("取消", null).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edit.clear().commit();
                            MyApp.setFalg(false);
                            startActivity(new Intent(SettingActivity.this, LoginActivity.class));
                        }
                    }).create().show();
                }
            });
        }
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_setting;
    }


    @OnClick({R.id.on_back_image, R.id.change_password, R.id.version_mode, R.id.now_version, R.id.clear_cache, R.id.about_us})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.on_back_image:
                onBackPressed();
                break;
            case R.id.change_password:
                Toast.makeText(this,"修改密码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.now_version:
                Toast.makeText(this,"当前版本", Toast.LENGTH_SHORT).show();
                break;
            case R.id.clear_cache:
                Toast.makeText(this,"清楚缓存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.about_us:
                startActivity(new Intent(this,AboutUsActivity.class));
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
