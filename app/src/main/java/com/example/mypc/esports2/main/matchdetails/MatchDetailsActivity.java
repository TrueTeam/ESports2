package com.example.mypc.esports2.main.matchdetails;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.adapter.GamesDetailsAdapter;
import com.example.mypc.esports2.base.BaseActivity;
import com.example.mypc.esports2.bean.MatchDetailsBean;
import com.example.mypc.esports2.main.GamesDetailsActivity;
import com.example.mypc.esports2.main.persondetails.PersonDetailsActivity;
import com.example.mypc.esports2.main.persondetails.PersonDetailsGridActivity;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MatchDetailsActivity extends BaseActivity implements MatchDetailsContract.View {

    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.iv_head_image)
    ImageView ivHeadImage;
    @BindView(R.id.tv_include_tile)
    TextView tvIncludeTile;
    @BindView(R.id.tv_include_intro)
    TextView tvIncludeIntro;
    @BindView(R.id.tv_include_more)
    TextView tvIncludeMore;
    @BindView(R.id.tv_sign_count)
    TextView tvSignCount;
    @BindView(R.id.tv_show_image)
    TextView tvShowImage;
    @BindView(R.id.btn_entered)
    Button btnEntered;
    @BindView(R.id.rv_include_view)
    RecyclerView rvIncludeView;
    @BindView(R.id.tv_web_p)
    TextView tvWebP;
    @BindView(R.id.image_share_sdk)
    ImageView imageShare;

    private static final int REGIST_END = 0;
    private static final int REGIST_NOSTART = 1;
    private static final int REGISTING_MARK = 2;
    private static final int ACTIVING_MARK = 3;
    private MatchDetailsContract.Model model;
    private MatchDetailsContract.Persenter persenter;
    private Handler handler = new Handler();
    private String content;
    private GamesDetailsAdapter adapter;
    private List<MatchDetailsBean.SignListsBean> signLists;
    private List<MatchDetailsBean.SignListsBean> mList;
    private String matchStatus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new MatchDetailsModel();
        persenter = new MatchDetailsPersenter(this, model);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        matchStatus = intent.getStringExtra("matchStatus");
        persenter.getDate(id);

        switch (Integer.parseInt(matchStatus)) {
            case REGIST_END:
                btnEntered.setEnabled(false);
                btnEntered.setText("已结束");
                btnEntered.setTextColor(0xff00c3be);
                btnEntered.setBackgroundColor(0xffeeeeee);
                break;
            case REGIST_NOSTART:
                btnEntered.setEnabled(false);
                btnEntered.setText("未开始");
                btnEntered.setTextColor(0xff00c3be);
                btnEntered.setBackgroundColor(0xffeeeeee);
                break;
            case REGISTING_MARK:
                btnEntered.setEnabled(true);
                btnEntered.setText("立即报名");
                btnEntered.setTextColor(0xffeeeeee);
                btnEntered.setBackgroundColor(0xff00c3be);
                btnEntered.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MatchDetailsActivity.this, RoleSelectionActivity.class));
                        Toast.makeText(MatchDetailsActivity.this, "现在可以报名.. 来报名吧", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case ACTIVING_MARK:
                btnEntered.setEnabled(false);
                btnEntered.setText("活动中");
                btnEntered.setTextColor(0xff00c3be);
                btnEntered.setBackgroundColor(0xffeeeeee);
                break;

        }
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_match_details;
    }


    @Override
    public void onSuccess(MatchDetailsBean mdb) {
        if (mdb != null) {
            final String coverLink = mdb.getCoverLink();
            mList = new ArrayList<>();

            signLists = mdb.getSignLists();
            if (signLists.size() > 41) {
                for (int i = 0; i < 41; i++) {
                    mList.add(signLists.get(i));
                }
            } else {
                mList.addAll(signLists);
            }

            mList.add(new MatchDetailsBean.SignListsBean("10", "halou", "R.mipmap.icon_mao"));
            StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager(7, StaggeredGridLayoutManager.VERTICAL);
            rvIncludeView.setLayoutManager(sgm);
            adapter = new GamesDetailsAdapter(R.layout.rv_details_adapter, mList);
            rvIncludeView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            final String prize = mdb.getPrize();
            content = mdb.getContent();
            final String title = mdb.getTitle();
            final String intro = mdb.getIntro();
            final String signCount = mdb.getSignCount();

            handler.post(new Runnable() {
                @Override
                public void run() {
                    tvIncludeTile.setText(title);
                    tvIncludeIntro.setText(intro);
                    tvSignCount.setText(signCount + "人在参与");
                    tvWebP.setText(Html.fromHtml(prize));
                    Glide.with(MatchDetailsActivity.this)
                            .load(coverLink)
                            .into(ivHeadImage);


                }
            });


            adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(View view, int i) {
                    if (mList.size() - 1 == i) {
                        Intent intent = new Intent(MatchDetailsActivity.this, PersonDetailsGridActivity.class);
                        intent.putExtra("signLists", (Serializable) signLists);
                        intent.putExtra("signCount", signCount);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(MatchDetailsActivity.this, PersonDetailsActivity.class);
                        intent.putExtra("id", signLists.get(i).getId());
                        startActivity(intent);
                    }
                }
            });
        }
    }

    @Override
    public void onFild(String msg) {
        Toast.makeText(this, "网络连接错误", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.on_back_image, R.id.tv_include_more, R.id.image_share_sdk})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.on_back_image:
                onBackPressed();
                break;
            case R.id.tv_include_more:
                Intent intent = new Intent(this, GamesDetailsActivity.class);
                intent.putExtra("content", content);
                startActivity(intent);
                break;
            case R.id.image_share_sdk:
                SHARE_MEDIA[] displaylist = new SHARE_MEDIA[]
                        {
                                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.SINA,
                                SHARE_MEDIA.QQ,SHARE_MEDIA.SMS
                        };

                UMShareListener umShareListener = new UMShareListener() {
                    @Override
                    public void onResult(SHARE_MEDIA platform) {
                        Toast.makeText(MatchDetailsActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(SHARE_MEDIA platform, Throwable t) {
                        Toast.makeText(MatchDetailsActivity.this, platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA platform) {
                        Toast.makeText(MatchDetailsActivity.this, platform + " 分享取消了", Toast.LENGTH_SHORT).show();
                    }
                };

                new ShareAction(this).setDisplayList(displaylist)
                        .withText(content)
                        .withTitle("title")
                        .withTargetUrl("http://www.baidu.com")
                        .setListenerList(umShareListener)
                        .open();
                break;
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}