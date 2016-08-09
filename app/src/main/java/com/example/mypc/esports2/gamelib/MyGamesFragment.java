package com.example.mypc.esports2.gamelib;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypc.esports2.MyApp;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.login.LoginActivity;
import com.example.mypc.esports2.main.ExchangeActivity;
import com.example.mypc.esports2.main.InterestedActivity;
import com.example.mypc.esports2.main.InvitationActivity;
import com.example.mypc.esports2.main.MyMatchActivity;
import com.example.mypc.esports2.main.MyPartActivity;
import com.example.mypc.esports2.main.MyReplyActivity;
import com.example.mypc.esports2.main.MyTeamActivity;
import com.example.mypc.esports2.main.SettingActivity;
import com.example.mypc.esports2.main.TuCaoActivity;
import com.example.mypc.esports2.main.persondetails.EditingInterfaceActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyGamesFragment extends Fragment {


    @BindView(R.id.head_circleiv)
    CircleImageView headCircleiv;
    @BindView(R.id.game_tablayout)
    TabLayout gameTablayout;
    @BindView(R.id.body_viewpager)
    ViewPager bodyViewpager;
    @BindView(R.id.head_image_setting)
    ImageView headImageSetting;
    @BindView(R.id.head_image_pic)
    CircleImageView headImagePic;
    @BindView(R.id.tv_login_text)
    TextView tvLoginText;
    @BindView(R.id.head_tv_quest)
    TextView headTvQuest;
    @BindView(R.id.head_tv_pantaoyuan)
    TextView headTvPantaoyuan;
    @BindView(R.id.head_tv_record)
    TextView headTvRecord;
    @BindView(R.id.head_tv_more)
    TextView headTvMore;
    @BindView(R.id.head_tv_mygame)
    TextView headTvMygame;
    @BindView(R.id.head_tv_war_team)
    TextView headTvWarTeam;
    @BindView(R.id.head_tv_mine_march)
    TextView headTvMineMarch;
    @BindView(R.id.head_tv_replay)
    TextView headTvReplay;
    @BindView(R.id.head_tv_yaoqingma)
    TextView headTvYaoqingma;
    @BindView(R.id.head_tv_tucao)
    TextView headTvTucao;
    @BindView(R.id.game_draw_layout)
    DrawerLayout gameDrawLayout;
    private MatchPagerAdapter adapter;

    public MyGamesFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_games, container, false);
        String[] matchFragment = getResources().getStringArray(R.array.match_selcet_fragment);
        bodyViewpager = (ViewPager) view.findViewById(R.id.body_viewpager);
        gameTablayout = (TabLayout) view.findViewById(R.id.game_tablayout);
        adapter = new MatchPagerAdapter(getFragmentManager(), matchFragment);
        bodyViewpager.setAdapter(adapter);
        gameTablayout.setupWithViewPager(bodyViewpager);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick({R.id.head_circleiv, R.id.head_image_setting, R.id.head_image_pic, R.id.tv_login_text, R.id.head_tv_quest, R.id.head_tv_pantaoyuan, R.id.head_tv_record, R.id.head_tv_more, R.id.head_tv_mygame, R.id.head_tv_war_team, R.id.head_tv_mine_march, R.id.head_tv_replay, R.id.head_tv_yaoqingma, R.id.head_tv_tucao})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.head_circleiv:
                if (gameDrawLayout.isDrawerOpen(Gravity.LEFT)){
                    gameDrawLayout.closeDrawer(Gravity.LEFT);
                }else{
                    gameDrawLayout.openDrawer(Gravity.LEFT);
                }
                break;
            case R.id.head_image_setting:
                startActivity(new Intent(getContext(), SettingActivity.class));
                break;
            case R.id.head_image_pic:
                if (MyApp.getFalg()){
                    startActivityForResult(new Intent(getActivity(), EditingInterfaceActivity.class),1);
                }else{
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            case R.id.tv_login_text:
                if (MyApp.getFalg()){
                    Toast.makeText(getContext(),"功能暂时未实现",Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            case R.id.head_tv_quest:
                if (MyApp.getFalg()) {
                    Toast.makeText(getContext(),"功能暂时未实现",Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            case R.id.head_tv_pantaoyuan:
                if (MyApp.getFalg()) {
                    Toast.makeText(getContext(),"功能暂时未实现",Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            case R.id.head_tv_record:
                if (MyApp.getFalg()) {
                    startActivity(new Intent(getContext(), ExchangeActivity.class));
                } else {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            case R.id.head_tv_more:
                if (MyApp.getFalg()) {
                    startActivity(new Intent(getContext(), MyPartActivity.class));
                } else {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            case R.id.head_tv_mygame:
                if (MyApp.getFalg()) {
                    startActivity(new Intent(getActivity(), InterestedActivity.class));
                } else {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            case R.id.head_tv_war_team:
                if (MyApp.getFalg()) {
                    startActivity(new Intent(getContext(), MyTeamActivity.class));
                } else {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            case R.id.head_tv_mine_march:
                if (MyApp.getFalg()) {
                    startActivity(new Intent(getContext(), MyMatchActivity.class));
                } else {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            case R.id.head_tv_replay:
                if (MyApp.getFalg()) {
                    startActivity(new Intent(getContext(), MyReplyActivity.class));
                } else {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            case R.id.head_tv_yaoqingma:
                if (MyApp.getFalg()) {
                    startActivity(new Intent(getContext(), InvitationActivity.class));
                } else {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            case R.id.head_tv_tucao:
                if (MyApp.getFalg()) {
                    startActivity(new Intent(getContext(), TuCaoActivity.class));
                } else {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1){
            Bundle extras = data.getExtras();
            Bitmap bitmap = extras.getParcelable("photo");
            headImagePic.setImageBitmap(bitmap);
            headCircleiv.setImageBitmap(bitmap);
        }
    }
}
