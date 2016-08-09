package com.example.mypc.esports2.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.bean.MatchDetailsBean;

import java.util.List;

/**
 * Created by MyPC on 2016/8/5.
 */
public class GamesDetailsAdapter extends BaseQuickAdapter<MatchDetailsBean.SignListsBean> {
    private int count = 0;
    public GamesDetailsAdapter(int layoutResId, List<MatchDetailsBean.SignListsBean> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MatchDetailsBean.SignListsBean signListsBean) {
        Glide.with(baseViewHolder.convertView.getContext())
                .load(signListsBean.getHeadLink())
                .into((ImageView) baseViewHolder.getView(R.id.iv_circe_view));
        if (signListsBean.getHeadLink().equals("R.mipmap.icon_mao")){
                Glide.with(baseViewHolder.convertView.getContext())
                        .load(R.mipmap.icon_mao)
                        .into((ImageView) baseViewHolder.getView(R.id.iv_circe_view));
            }



    }


}
