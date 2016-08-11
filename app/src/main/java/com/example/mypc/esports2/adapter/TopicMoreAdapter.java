package com.example.mypc.esports2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.bean.TopicMoreBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/10.
 */
public class TopicMoreAdapter extends BaseAdapter {
    private List<TopicMoreBean> list;

    public TopicMoreAdapter(List<TopicMoreBean> list) {
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topicmore, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textviewTitle.setText(list.get(position).getTitle());
        holder.textviewRight.setText(list.get(position).getRed_title());
        holder.textviewLeft.setText(list.get(position).getBlue_title());
        holder.textviewCountRight.setText(list.get(position).getRed_count());
        holder.textviewCountLeft.setText(list.get(position).getBlue_count());
        Glide.with(parent.getContext()).load(list.get(position).getPic()).into(holder.imagviewIcan);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.textview_title)
        TextView textviewTitle;
        @BindView(R.id.imagview_ican)
        ImageView imagviewIcan;
        @BindView(R.id.textview_right)
        TextView textviewRight;
        @BindView(R.id.textview_left)
        TextView textviewLeft;
        @BindView(R.id.textview_count_right)
        TextView textviewCountRight;
        @BindView(R.id.textview_count_left)
        TextView textviewCountLeft;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
