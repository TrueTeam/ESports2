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
import com.example.mypc.esports2.bean.PostBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 强 on 2016/8/5.
 */
public class FindpostAdapter extends BaseAdapter {
    private List<PostBean> list;

    public FindpostAdapter(List<PostBean> list) {
        this.list = list;
        for (int i = 0; i <list.size() ; i++) {
            String circle_title = list.get(i).getCircle_title();
            Log.i("TAG",circle_title);
        }
    }

    @Override
    public int getCount() {
        int size = list.size();
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gridview_postfind, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder= (ViewHolder) convertView.getTag();
        }
            holder.textviewTitle.setText(list.get(position).getNickname());
            holder.textviewContent.setText(list.get(position).getContent());
            holder.textviewPeople.setText(list.get(position).getPraises());
            holder.textviewLike.setText(list.get(position).getReviews());
        //Glide.with(convertView.getContext()).load(list.get(position).getPic_lists().get(0)).into(holder.imageViewBigmap);
        Glide.with(convertView.getContext()).load(list.get(position).getHead_link()).into(holder.imageViewIcan);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.imageView_bigmap)
        ImageView imageViewBigmap;
        @BindView(R.id.imageView_ican)
        CircleImageView imageViewIcan;
        @BindView(R.id.textview_title)
        TextView textviewTitle;
        @BindView(R.id.textview_content)
        TextView textviewContent;
        @BindView(R.id.textview_people)
        TextView textviewPeople;
        @BindView(R.id.textview_like)
        TextView textviewLike;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
