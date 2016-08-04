package com.example.mypc.esports2.main.news.newsinner;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.bean.ListBean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by peter on 2016/8/2.
 */
public class NewsInnerRecycleviewAdapter extends BaseQuickAdapter<ListBean> {

    public NewsInnerRecycleviewAdapter(int layoutResId, List<ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ListBean listBean) {
        String createTime = listBean.getCreateTime();
        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
        String time = format.format(new Date(Long.valueOf(createTime)));
        baseViewHolder.setText(R.id.tv_news_item_title, listBean.getTitle())
                .setText(R.id.tv_news_item_time, time);
        Glide.with(baseViewHolder.itemView.getContext())
                .load(listBean.getCoverLink())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into((ImageView) baseViewHolder.itemView.findViewById(R.id.iv_news_item_logo));
    }
}
