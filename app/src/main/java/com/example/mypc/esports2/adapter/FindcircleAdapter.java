package com.example.mypc.esports2.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.bean.CircleBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 强 on 2016/8/5.
 */
public class FindcircleAdapter extends BaseAdapter {
    private List<CircleBean> list;

    public FindcircleAdapter(List<CircleBean> list) {
        this.list = list;

    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gridview_circlefind, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.itemGridTextviewTitle.setText(list.get(position).getTitle());
        holder.itemGridTextviewPeople.setText(list.get(position).getUsers()+"人");
        holder.itemGridTextviewPost.setText(list.get(position).getPosts()+"帖子");
        Glide.with(parent.getContext()).load(list.get(position).getLogo()).into(holder.itemGridImageview);
        return convertView;
    }

     class ViewHolder {
        @BindView(R.id.item_grid_imageview)
        ImageView itemGridImageview;
        @BindView(R.id.item_grid_textview_title)
        TextView itemGridTextviewTitle;
        @BindView(R.id.item_grid_textview_people)
        TextView itemGridTextviewPeople;
        @BindView(R.id.item_grid_textview_post)
        TextView itemGridTextviewPost;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
