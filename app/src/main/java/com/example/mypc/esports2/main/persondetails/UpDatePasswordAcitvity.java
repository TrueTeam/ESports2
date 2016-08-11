package com.example.mypc.esports2.main.persondetails;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;
import com.example.mypc.esports2.bean.UserBean;
import com.example.mypc.esports2.httputils.register.UserDao;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class UpDatePasswordAcitvity extends BaseActivity {


    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.et_new_password)
    EditText etNewPassword;
    @BindView(R.id.et_queren_password)
    EditText etQuerenPassword;
    @BindView(R.id.btn_add_new_password)
    Button btnAddNewPassword;

    @Override
    public int getLayoutID() {
        return R.layout.activity_up_date_password_acitvity;
    }



    @OnClick({R.id.on_back_image, R.id.btn_add_new_password})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.on_back_image:
                onBackPressed();
                break;
            case R.id.btn_add_new_password:
                List<UserBean> username = UserDao.QueryAll(this);
                Log.i("TAG", "onClick: " + username.get(0).getUsername());
                String newPass = etNewPassword.getText().toString().trim();
                String querenPass = etQuerenPassword.getText().toString().trim();
                UserBean userBean = new UserBean();
                userBean.setUsername(username.get(0).getUsername());
                if (newPass.equals(querenPass)) {
                    UserDao.update(this,userBean , "password", newPass);
                    Toast.makeText(this, "修改完成", Toast.LENGTH_SHORT).show();
                    List<UserBean> userBeen1 = UserDao.QueryAll(this);
                    Log.i("TAG", "onClick: "+ userBeen1.get(0).getPassword());
                    finish();
                } else {
                    Toast.makeText(this, "两次输入密码不一致,请重新输入", Toast.LENGTH_SHORT).show();
                }
                break;



        }
    }

}
