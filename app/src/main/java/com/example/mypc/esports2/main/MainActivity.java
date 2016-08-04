package com.example.mypc.esports2.main;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;
import com.example.mypc.esports2.fragment.UnLoginFragment;
import com.example.mypc.esports2.gamelib.MyGamesFragment;
import com.example.mypc.esports2.main.news.NewsFragment;

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
    private NewsFragment newsFragment;
    private UnLoginFragment unLoginFragment;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragment();
        selectFragment(SELECTED_GAME);
    }

    private void initFragment() {
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        myGamesFragment = new MyGamesFragment(FLAG);
        newsFragment = new NewsFragment();
        unLoginFragment = new UnLoginFragment();
        transaction.add(R.id.fl_layout, myGamesFragment);
        transaction.add(R.id.fl_layout, newsFragment);
        transaction.add(R.id.fl_layout, unLoginFragment);
        transaction.commit();
    }

    public void selectFragment(int position) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.hide(myGamesFragment).hide(newsFragment).hide(unLoginFragment);
        switch (position) {
            case SELECTED_GAME:
                transaction.show(myGamesFragment);
                break;
            case SELECTED_FOUND:
                break;
            case SELECTED_NEWS:
                transaction.show(newsFragment);
                break;
            case SELECTED_MESSAGE:
                transaction.show(unLoginFragment);
                break;
        }
        transaction.commit();
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
                break;
            case R.id.btn_news:
                selectFragment(SELECTED_NEWS);
                break;
            case R.id.btn_message:
                if (FLAG) {

                } else {
                    selectFragment(SELECTED_MESSAGE);
                }
                break;
        }
    }
}
