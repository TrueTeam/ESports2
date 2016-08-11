package com.example.mypc.esports2.fragment.findFragmentt.circlemore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.adapter.HotMoreAdapter;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HotMoreActivity extends AppCompatActivity {

    @BindView(R.id.on_back_image)
    ImageView onBackImage;
    @BindView(R.id.radiobutton_circle)
    RadioButton radiobuttonCircle;
    @BindView(R.id.radiobutton_post)
    RadioButton radiobuttonPost;
    @BindView(R.id.viewpager_hot)
    ViewPager viewpagerHot;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_more);
        ButterKnife.bind(this);
        radiobuttonCircle.setChecked(true);

        createFragment();
        HotMoreAdapter adapter=new HotMoreAdapter(getSupportFragmentManager(),list);
        viewpagerHot.setAdapter(adapter);

        viewpagerHot.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        radiobuttonCircle.setChecked(true);
                        break;
                    case 1:
                        radiobuttonPost.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void createFragment() {
        list=new ArrayList<>();
        CircleFragment circleFragment=new CircleFragment();
        list.add(circleFragment);
        PostFragment postFragment=new PostFragment();
        list.add(postFragment);

    }

    @OnClick({R.id.on_back_image, R.id.radiobutton_circle, R.id.radiobutton_post})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.on_back_image:
                finish();
                break;
            case R.id.radiobutton_circle:
                viewpagerHot.setCurrentItem(0);
                break;
            case R.id.radiobutton_post:
                viewpagerHot.setCurrentItem(1);
                break;
        }
    }
}
