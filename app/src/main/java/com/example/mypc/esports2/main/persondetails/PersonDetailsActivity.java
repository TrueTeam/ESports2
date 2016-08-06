package com.example.mypc.esports2.main.persondetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;
import com.example.mypc.esports2.bean.PersonDetailsBean;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class PersonDetailsActivity extends BaseActivity implements PersonDetailsContract.View {

    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.tv_person_name)
    TextView tvPersonName;
    @BindView(R.id.iv_person_details)
    ImageView ivPersonDetails;
    @BindView(R.id.tv_person_details_fllow)
    TextView tvPersonDetailsFllow;
    @BindView(R.id.tv_person_details_fen)
    TextView tvPersonDetailsFen;
    @BindView(R.id.iv_target_one)
    ImageView ivTargetOne;
    @BindView(R.id.iv_target_two)
    ImageView ivTargetTwo;
    @BindView(R.id.tv_person_details_id)
    TextView tvPersonDetailsId;
    @BindView(R.id.tv_person_details_content)
    TextView tvPersonDetailsContent;
    @BindView(R.id.tv_watch_more)
    TextView tvWatchMore;
    @BindView(R.id.btn_call_other)
    Button btnCallOther;
    @BindView(R.id.btn_fllow)
    Button btnFllow;
    @BindView(R.id.iv_ls_icon_default1)
    ImageView ivLsIconDefault1;
    @BindView(R.id.iv_ls_icon_circle)
    CircleImageView ivLsIconCircle;
    private PersonDetailsContract.Persenter persenter;
    private PersonDetailsContract.Model model;
    private String headLink;
    private String tag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new PersonDetailsModel();
        persenter = new PersonDetailsPersenter(this, model);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        persenter.getDate(id);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_person_details;
    }


    @Override
    public void onSuccess(PersonDetailsBean result) {
        if (result != null) {
            headLink = result.getHeadLink();
            String followCount = result.getFollowCount();
            String fansCount = result.getFansCount();

            List<?> tags = result.getTags();
            if (tags.size() > 0) {
                tag = (String) tags.get(0);
            }
            String id = result.getId();
            String sign = result.getSign();
            Glide.with(this).load(headLink).into(ivPersonDetails);
            Glide.with(this).load(tag).into(ivTargetOne);
            tvPersonDetailsFllow.setText("关注 : " + followCount);
            tvPersonDetailsFen.setText("粉丝 : " + fansCount);
            tvPersonDetailsId.setText(id);
            tvPersonDetailsContent.setText(sign);
        }
    }

    @Override
    public void onFail(String erro) {
    }

    @OnClick({R.id.on_back_image, R.id.btn_call_other, R.id.btn_fllow, R.id.iv_person_details})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.on_back_image:
                onBackPressed();
                break;
            case R.id.btn_call_other:
                Toast.makeText(this, "打招呼", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_fllow:
                Toast.makeText(this, "关注", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_person_details:
                Intent intent = new Intent(this, PersonDetailsPicActivity.class);
                intent.putExtra("headLink", headLink);
                startActivity(intent);
                break;

        }
    }
}
