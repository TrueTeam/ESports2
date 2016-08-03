package com.example.mypc.esports2.gamelib.matchinnerfragment;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.bean.GamesBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by MyPC on 2016/8/3.
 */
public class MatchInnerAdapter extends BaseQuickAdapter<GamesBean>{


    public MatchInnerAdapter(int layoutResId, List<GamesBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, GamesBean gamesBean) {
        baseViewHolder.setText(R.id.inner_tv_title,gamesBean.getTitle());

//        Glide.with(baseViewHolder.convertView.getContext())
//                .load(gamesBean.getCoverLink())
//                .into((ImageView) baseViewHolder.getView(R.id.care_image));
        Picasso.with(baseViewHolder.convertView.getContext())
                .load(gamesBean.getCoverLink())
                .into((ImageView) baseViewHolder.getView(R.id.care_image));

    }
}
