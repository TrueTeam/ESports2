package com.example.mypc.esports2.main.news;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.bean.ListBean;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by peter on 2016/8/2.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ItemViewHolder> {

    private List<ListBean> list;

    public NewsAdapter(List<ListBean> list) {
        this.list = list;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView tvtitle, tvtime;
        private ImageView ivlogo;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tvtime = (TextView) itemView.findViewById(R.id.tv_news_item_time);
            tvtitle = (TextView) itemView.findViewById(R.id.tv_news_item_time);
            ivlogo = (ImageView) itemView.findViewById(R.id.iv_news_item_logo);
        }
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_listitem, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        ListBean listBean = list.get(position);
        String title = listBean.getTitle();
        holder.tvtitle.setText(title);
        String createTime = listBean.getCreateTime();
        holder.tvtime.setText(createTime);
        String content = listBean.getContent();
        Picasso.with(holder.itemView.getContext()).load(content).into(holder.ivlogo);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
