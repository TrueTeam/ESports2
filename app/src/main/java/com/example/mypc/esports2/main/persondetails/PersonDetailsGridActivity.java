package com.example.mypc.esports2.main.persondetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.adapter.PersonDetailsGridAdapter;
import com.example.mypc.esports2.base.BaseActivity;
import com.example.mypc.esports2.bean.MatchDetailsBean;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonDetailsGridActivity extends BaseActivity {

    @BindView(R.id.recy_grid_person_details)
    RecyclerView recyGridPersonDetails;
    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.tv_participation_person)
    TextView tvParticipationPerson;
    private List<MatchDetailsBean.SignListsBean> signLists;

    @Override
    public int getLayoutID() {
        return R.layout.activity_person_details_grid;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String signCount = intent.getStringExtra("signCount");
        tvParticipationPerson.setText("参与人员("+signCount+")");
        signLists = (List<MatchDetailsBean.SignListsBean>) intent.getSerializableExtra("signLists");
        StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        recyGridPersonDetails.setLayoutManager(sgm);
        PersonDetailsGridAdapter adapter = new PersonDetailsGridAdapter(R.layout.person_details_grid, signLists);
        recyGridPersonDetails.setAdapter(adapter);
        adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(PersonDetailsGridActivity.this, PersonDetailsActivity.class);
                intent.putExtra("id", signLists.get(i).getId());
                startActivity(intent);
            }
        });
    }

    @OnClick(R.id.on_back_image)
    public void onClick() {
    }
}
