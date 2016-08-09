package com.example.mypc.esports2.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by MyPC on 2016/8/7.
 */
public class InterestedActivity extends BaseActivity {
    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.tv_finsh_interested)
    TextView tvFinshInterested;
    @BindView(R.id.lv_interested)
    ListView lvInterested;

    @Override
    public int getLayoutID() {
        return R.layout.activity_interested;
    }


    @OnClick({R.id.on_back_image, R.id.tv_finsh_interested})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.on_back_image:
                onBackPressed();
                break;
            case R.id.tv_finsh_interested:
                break;
        }
    }
}
