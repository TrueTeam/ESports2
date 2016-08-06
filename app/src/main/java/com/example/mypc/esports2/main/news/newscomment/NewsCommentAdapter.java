package com.example.mypc.esports2.main.news.newscomment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.bean.CommentBean;
import com.example.mypc.esports2.main.persondetails.PersonDetailsActivity;

import java.util.List;

/**
 * Created by peter on 2016/8/6.
 */
public class NewsCommentAdapter extends BaseAdapter {

    private List<CommentBean> list;

    public NewsCommentAdapter(List<CommentBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
    public View getView(int position, View convertView, final ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_comment_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final CommentBean commentBean = list.get(position);
        holder.tvcontent.setText(commentBean.getContentText());
        holder.tvnickname.setText(commentBean.getNickname());
        holder.tvtime.setText(commentBean.getCreateTime());
        holder.tvprise.setText(commentBean.getPraise());
        if (commentBean.getHeadLink() != null) {
            Glide.with(parent.getContext()).load(commentBean.getHeadLink()).into(holder.ivlogo);
        }

        holder.ivlogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(), PersonDetailsActivity.class);
                intent.putExtra("id", commentBean.getUid());
                parent.getContext().startActivity(intent);
            }
        });

        return convertView;
    }

    class ViewHolder {
        TextView tvnickname, tvcontent, tvtime, tvprise;
        ImageView ivlogo;

        public ViewHolder(View view) {
            tvcontent = (TextView) view.findViewById(R.id.tv_content_user);
            tvnickname = (TextView) view.findViewById(R.id.tv_nickname_user);
            tvtime = (TextView) view.findViewById(R.id.tv_time_user);
            tvprise = (TextView) view.findViewById(R.id.tv_prise_user);
            ivlogo = (ImageView) view.findViewById(R.id.cv_comment_user);
        }
    }
}
