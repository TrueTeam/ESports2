package com.example.mypc.esports2.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.bean.MatchDetailsBean;

import java.util.List;

/**
 * Created by MyPC on 2016/8/6.
 */
public class PersonDetailsGridAdapter extends BaseQuickAdapter<MatchDetailsBean.SignListsBean> {
    public PersonDetailsGridAdapter(int layoutResId, List<MatchDetailsBean.SignListsBean> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder baseViewHolder, MatchDetailsBean.SignListsBean signListsBean) {
        String headLink = signListsBean.getHeadLink();
        String name = signListsBean.getName();
        String head = signListsBean.getHead();

        baseViewHolder.setText(R.id.tv_child_person_grid,name);
        Glide.with(baseViewHolder.convertView.getContext())
                .load(headLink)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into((ImageView) baseViewHolder.convertView.findViewById(R.id.iv_child_person_grid));
    }
}
