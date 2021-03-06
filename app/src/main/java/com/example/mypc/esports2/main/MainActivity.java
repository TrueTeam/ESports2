package com.example.mypc.esports2.main;

import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.example.mypc.esports2.MyApp;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;
import com.example.mypc.esports2.bean.UserBean;
import com.example.mypc.esports2.fragment.UnLoginFragment;
import com.example.mypc.esports2.fragment.circle.LoggedFragment;
import com.example.mypc.esports2.fragment.findFragmentt.FindFragment;
import com.example.mypc.esports2.gamelib.MyGamesFragment;
import com.example.mypc.esports2.httputils.register.UserDao;
import com.example.mypc.esports2.main.linkpage.ShowHomeActivity;
import com.example.mypc.esports2.main.news.NewsFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.btn_games)
    RadioButton btnGames;
    @BindView(R.id.btn_found)
    RadioButton btnFound;
    @BindView(R.id.btn_news)
    RadioButton btnNews;
    @BindView(R.id.btn_message)
    RadioButton btnMessage;
    private MyGamesFragment myGamesFragment;
    public static final int SELECTED_GAME = 0;
    public static final int SELECTED_FOUND = 1;
    public static final int SELECTED_NEWS = 2;
    public static final int SELECTED_MESSAGE = 3;
    public static final int SELECTED_SHOW_MESSAGE = 4;
    private NewsFragment newsFragment;
    private UnLoginFragment unLoginFragment;
    private FragmentManager manager;
    private FindFragment findFragment;
    private LoggedFragment loggedFragment;
    private String headimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, ShowHomeActivity.class));
        SharedPreferences preferences = getSharedPreferences("info.txt", MODE_PRIVATE);
        String username = preferences.getString("username", "");
//        String password = preferences.getString("password", "");
        //数据库获取头像信息--路径
        List<UserBean> beanList = UserDao.QueryOne(this, "username", username);
        if (username.length() > 0) {
            MyApp.setFalg(true);
            String s = beanList.get(0).getHeadimg();
            if (s != null) {
                headimg = s;
            } else {
                headimg = "";
            }
        } else {
            headimg = "";
        }
        initFragment();
        selectFragment(SELECTED_GAME);
    }

    private void initFragment() {
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        myGamesFragment = new MyGamesFragment();
        newsFragment = new NewsFragment();
        unLoginFragment = new UnLoginFragment();
        findFragment = new FindFragment();
        loggedFragment = new LoggedFragment();
        //将头像信息传递给myGamesFragment
        Bundle bundle = new Bundle();
        bundle.putString("headimg", headimg);
        myGamesFragment.setArguments(bundle);
        transaction.add(R.id.fl_layout, myGamesFragment);
        transaction.add(R.id.fl_layout, newsFragment);
        transaction.add(R.id.fl_layout, unLoginFragment);
        transaction.add(R.id.fl_layout, findFragment);
        transaction.add(R.id.fl_layout, loggedFragment);
        transaction.commitAllowingStateLoss();
    }

    public void selectFragment(int position) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.hide(myGamesFragment).hide(newsFragment).hide(unLoginFragment).hide(findFragment).hide(loggedFragment);
        switch (position) {
            case SELECTED_GAME:
                transaction.show(myGamesFragment);
                break;
            case SELECTED_FOUND:
                transaction.show(findFragment);
                break;
            case SELECTED_NEWS:
                transaction.show(newsFragment);
                break;
            case SELECTED_MESSAGE:
                transaction.show(unLoginFragment);
                break;
            case SELECTED_SHOW_MESSAGE:
                transaction.show(loggedFragment);
                break;

        }
        transaction.commitAllowingStateLoss();
    }


    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }


    @OnClick({R.id.btn_games, R.id.btn_found, R.id.btn_news, R.id.btn_message})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_games:
                selectFragment(SELECTED_GAME);
                break;
            case R.id.btn_found:
                selectFragment(SELECTED_FOUND);
                break;
            case R.id.btn_news:
                selectFragment(SELECTED_NEWS);
                break;
            case R.id.btn_message:
                if (!MyApp.getFalg()) {
                    selectFragment(SELECTED_MESSAGE);
                } else {
                    selectFragment(SELECTED_SHOW_MESSAGE);
                }
                break;

        }
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        if (MyApp.getFalg()){
//            btnGames.setChecked(true);
//            selectFragment(SELECTED_GAME);
//        }
//    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (MyApp.getFalg()) {
            btnGames.setChecked(true);
            selectFragment(SELECTED_GAME);
        }
    }
}
