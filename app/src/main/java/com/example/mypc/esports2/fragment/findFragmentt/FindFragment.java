package com.example.mypc.esports2.fragment.findFragmentt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.adapter.FindAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 强 on 2016/8/4.
 */
public class FindFragment extends Fragment {

    @BindView(R.id.radiobutton_find)
    RadioButton radiobuttonFind;
    @BindView(R.id.radiobutton_focus)
    RadioButton radiobuttonFocus;
    @BindView(R.id.radiogroup_find)
    RadioGroup radiogroupFind;
    private List<Fragment> list;
    @BindView(R.id.viewpager_find)
    ViewPager viewpagerFind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);

        ButterKnife.bind(this, view);
        createFragment();
        FindAdapter adapter = new FindAdapter(getFragmentManager(), list);
        viewpagerFind.setAdapter(adapter);
        radiobuttonFind.setChecked(true);
        viewpagerFind.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radiobuttonFind.setChecked(true);
                        break;
                    case 1:
                        radiobuttonFocus.setChecked(true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    private void createFragment() {
        list = new ArrayList<>();
        list.add(new FindfindFragment());
        list.add(new FindfocusFragment());
    }

    @OnClick({R.id.radiobutton_find, R.id.radiobutton_focus})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.radiobutton_find:
                viewpagerFind.setCurrentItem(0);
                break;
            case R.id.radiobutton_focus:
                viewpagerFind.setCurrentItem(1);
                break;
        }
    }
}
