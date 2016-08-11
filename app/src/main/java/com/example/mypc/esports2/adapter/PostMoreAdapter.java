package com.example.mypc.esports2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.bean.PostHotBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2016/8/10.
 */
public class PostMoreAdapter extends BaseAdapter {
    private List<PostHotBean> list;

    public PostMoreAdapter(List<PostHotBean> list) {
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
    public int getItemViewType(int position) {
        return list.get(position).getPic_lists().size();
    }

    @Override
    public int getViewTypeCount() {
        return 6;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int itemViewType = getItemViewType(position);
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewHolder1 holder1;
        ViewHolder2 holder2;
        ViewHolder3 holder3;
        ViewHolder4 holder4;
        ViewHolder5 holder5;
        ViewHolder6 holder6;
        switch (itemViewType) {
            case 1:
                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.item_post_hot_fragment6, null);
                    holder1 = new ViewHolder1(convertView);
                    convertView.setTag(holder1);
                } else {
                    holder1 = (ViewHolder1) convertView.getTag();
                }
                Glide.with(parent.getContext())
                        .load(list.get(position).getHead_link())
                        .into(holder1.cvIcon);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(0))
                        .into(holder1.iv1);
                Glide.with(parent.getContext())
                        .load(list.get(position).getIcon())
                        .into(holder1.ivSmall);
                holder1.textviewName.setText(list.get(position).getNickname());
                holder1.textView2.setText(list.get(position).getCreate_time());
                holder1.textviewContent.setText(list.get(position).getContent());
                holder1.textView.setText(list.get(position).getCircle_title());
                holder1.textView8.setText(list.get(position).getPraises());
                holder1.textView_9.setText(list.get(position).getReviews());
                break;
            case 2:
                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.item_post_hot_fragment5, null);
                    holder2 = new ViewHolder2(convertView);
                    convertView.setTag(holder2);
                } else {
                    holder2 = (ViewHolder2) convertView.getTag();
                }
                Glide.with(parent.getContext())
                        .load(list.get(position).getHead_link())
                        .into(holder2.cvIcon);
                Glide.with(parent.getContext())
                        .load(list.get(position).getIcon())
                        .into(holder2.ivSmall);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(0))
                        .into(holder2.iv1);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(1))
                        .into(holder2.iv2);
                holder2.textviewName.setText(list.get(position).getNickname());
                holder2.textView2.setText(list.get(position).getCreate_time());
                holder2.textviewContent.setText(list.get(position).getContent());
                holder2.textView.setText(list.get(position).getCircle_title());
                holder2.textView7.setText(list.get(position).getPraises());
                holder2.textView8.setText(list.get(position).getReviews());
                break;
            case 3:
                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.item_post_hot_fragment4, null);
                    holder3 = new ViewHolder3(convertView);
                    convertView.setTag(holder3);
                } else {
                    holder3 = (ViewHolder3) convertView.getTag();
                }
                Glide.with(parent.getContext())
                        .load(list.get(position).getHead_link())
                        .into(holder3.cvIcon);
                Glide.with(parent.getContext())
                        .load(list.get(position).getIcon())
                        .into(holder3.ivSmall);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(0))
                        .into(holder3.iv1);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(1))
                        .into(holder3.iv2);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(2))
                        .into(holder3.iv3);
                holder3.textviewName.setText(list.get(position).getNickname());
                holder3.textView2.setText(list.get(position).getCreate_time());
                holder3.textviewContent.setText(list.get(position).getContent());
                holder3.textView.setText(list.get(position).getCircle_title());
                holder3.textView5.setText(list.get(position).getPraises());
                holder3.textView6.setText(list.get(position).getReviews());
                break;
            case 4:
                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.item_post_hot_fragment3, null);
                    holder4 = new ViewHolder4(convertView);
                    convertView.setTag(holder4);
                } else {
                    holder4 = (ViewHolder4) convertView.getTag();
                }
                Glide.with(parent.getContext())
                        .load(list.get(position).getHead_link())
                        .into(holder4.cvIcon);
                Glide.with(parent.getContext())
                        .load(list.get(position).getIcon())
                        .into(holder4.ivSmall);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(0))
                        .into(holder4.iv1);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(1))
                        .into(holder4.iv2);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(2))
                        .into(holder4.iv3);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(3))
                        .into(holder4.iv4);
                holder4.textviewName.setText(list.get(position).getNickname());
                holder4.textView2.setText(list.get(position).getCreate_time());
                holder4.textviewContent.setText(list.get(position).getContent());
                holder4.textView.setText(list.get(position).getCircle_title());
                holder4.textView4.setText(list.get(position).getPraises());
                holder4.textview3.setText(list.get(position).getReviews());
                break;
            case 5:
                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.item_post_hot_fragment2, null);
                    holder5 = new ViewHolder5(convertView);
                    convertView.setTag(holder5);
                } else {
                    holder5 = (ViewHolder5) convertView.getTag();
                }
                Glide.with(parent.getContext())
                        .load(list.get(position).getHead_link())
                        .into(holder5.cvIcon);
                Glide.with(parent.getContext())
                        .load(list.get(position).getIcon())
                        .into(holder5.ivSmall);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(0))
                        .into(holder5.iv1);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(1))
                        .into(holder5.iv2);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(2))
                        .into(holder5.iv3);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(3))
                        .into(holder5.iv4);
                Glide.with(parent.getContext())
                         .load(list.get(position).getPic_lists().get(4))
                         .into(holder5.iv5);

                holder5.textviewName.setText(list.get(position).getNickname());
                holder5.textView2.setText(list.get(position).getCreate_time());
                holder5.textviewContent.setText(list.get(position).getContent());
                holder5.textView.setText(list.get(position).getCircle_title());
                holder5.textView3.setText(list.get(position).getPraises());
                holder5.Message.setText(list.get(position).getReviews());
                break;
            default:
                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.item_post_hot_fragment1, null);
                    holder6 = new ViewHolder6(convertView);
                    convertView.setTag(holder6);
                } else {
                    holder6 = (ViewHolder6) convertView.getTag();
                }
                Glide.with(parent.getContext())
                        .load(list.get(position).getHead_link())
                        .into(holder6.cvIcon);
                Glide.with(parent.getContext())
                        .load(list.get(position).getIcon())
                        .into(holder6.ivSmall);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(0))
                        .into(holder6.iv1);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(1))
                        .into(holder6.iv2);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(2))
                        .into(holder6.iv3);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(3))
                        .into(holder6.iv4);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(4))
                        .into(holder6.iv5);
                Glide.with(parent.getContext())
                        .load(list.get(position).getPic_lists().get(5))
                        .into(holder6.iv6);
                holder6.textviewName.setText(list.get(position).getNickname());
                holder6.textView2.setText(list.get(position).getCreate_time());
                holder6.textviewContent.setText(list.get(position).getContent());
                holder6.textView.setText(list.get(position).getCircle_title());
                holder6.loveCount.setText(list.get(position).getPraises());
                holder6.messageCount.setText(list.get(position).getReviews());
                break;
        }
        return convertView;
    }


    static class ViewHolder1 {
        @BindView(R.id.cv_icon)
        CircleImageView cvIcon;
        @BindView(R.id.textview_9)
        TextView textView_9;
        @BindView(R.id.textview_name)
        TextView textviewName;
        @BindView(R.id.textView2)
        TextView textView2;
        @BindView(R.id.textview_content)
        TextView textviewContent;
        @BindView(R.id.iv_1)
        ImageView iv1;
        @BindView(R.id.iv_small)
        ImageView ivSmall;
        @BindView(R.id.textView)
        TextView textView;
        @BindView(R.id.iv_love)
        ImageView ivLove;
        @BindView(R.id.textView8)
        TextView textView8;
        @BindView(R.id.iv_message)
        ImageView ivMessage;

        ViewHolder1(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder2 {
        @BindView(R.id.cv_icon)
        CircleImageView cvIcon;
        @BindView(R.id.textview_name)
        TextView textviewName;
        @BindView(R.id.textView2)
        TextView textView2;
        @BindView(R.id.textview_content)
        TextView textviewContent;
        @BindView(R.id.iv_1)
        ImageView iv1;
        @BindView(R.id.iv_2)
        ImageView iv2;
        @BindView(R.id.iv_small)
        ImageView ivSmall;
        @BindView(R.id.textView)
        TextView textView;
        @BindView(R.id.iv_love)
        ImageView ivLove;
        @BindView(R.id.textView7)
        TextView textView7;
        @BindView(R.id.iv_message)
        ImageView ivMessage;
        @BindView(R.id.textView8)
        TextView textView8;

        ViewHolder2(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder3 {
        @BindView(R.id.cv_icon)
        CircleImageView cvIcon;
        @BindView(R.id.textview_name)
        TextView textviewName;
        @BindView(R.id.textView2)
        TextView textView2;
        @BindView(R.id.textview_content)
        TextView textviewContent;
        @BindView(R.id.iv_1)
        ImageView iv1;
        @BindView(R.id.iv_2)
        ImageView iv2;
        @BindView(R.id.iv_3)
        ImageView iv3;
        @BindView(R.id.iv_small)
        ImageView ivSmall;
        @BindView(R.id.textView)
        TextView textView;
        @BindView(R.id.iv_love)
        ImageView ivLove;
        @BindView(R.id.textView5)
        TextView textView5;
        @BindView(R.id.iv_message)
        ImageView ivMessage;
        @BindView(R.id.textView6)
        TextView textView6;

        ViewHolder3(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder4 {
        @BindView(R.id.cv_icon)
        CircleImageView cvIcon;
        @BindView(R.id.textview_name)
        TextView textviewName;
        @BindView(R.id.textView2)
        TextView textView2;
        @BindView(R.id.textview_content)
        TextView textviewContent;
        @BindView(R.id.iv_1)
        ImageView iv1;
        @BindView(R.id.iv_2)
        ImageView iv2;
        @BindView(R.id.iv_3)
        ImageView iv3;
        @BindView(R.id.iv_4)
        ImageView iv4;
        @BindView(R.id.iv_small)
        ImageView ivSmall;
        @BindView(R.id.textView)
        TextView textView;
        @BindView(R.id.iv_love)
        ImageView ivLove;
        @BindView(R.id.textView4)
        TextView textView4;
        @BindView(R.id.iv_message)
        ImageView ivMessage;
        @BindView(R.id.textview3)
        TextView textview3;

        ViewHolder4(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder5 {
        @BindView(R.id.cv_icon)
        CircleImageView cvIcon;
        @BindView(R.id.textview_name)
        TextView textviewName;
        @BindView(R.id.textView2)
        TextView textView2;
        @BindView(R.id.textview_content)
        TextView textviewContent;
        @BindView(R.id.iv_1)
        ImageView iv1;
        @BindView(R.id.iv_2)
        ImageView iv2;
        @BindView(R.id.iv_3)
        ImageView iv3;
        @BindView(R.id.iv_4)
        ImageView iv4;
        @BindView(R.id.iv_5)
        ImageView iv5;
        @BindView(R.id.iv_small)
        ImageView ivSmall;
        @BindView(R.id.textView)
        TextView textView;
        @BindView(R.id.iv_love)
        ImageView ivLove;
        @BindView(R.id.textView3)
        TextView textView3;
        @BindView(R.id.iv_message)
        ImageView ivMessage;
        @BindView(R.id.Message)
        TextView Message;

        ViewHolder5(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder6 {
        @BindView(R.id.cv_icon)
        CircleImageView cvIcon;
        @BindView(R.id.textview_name)
        TextView textviewName;
        @BindView(R.id.textView2)
        TextView textView2;
        @BindView(R.id.textview_content)
        TextView textviewContent;
        @BindView(R.id.iv_1)
        ImageView iv1;
        @BindView(R.id.iv_2)
        ImageView iv2;
        @BindView(R.id.iv_3)
        ImageView iv3;
        @BindView(R.id.iv_4)
        ImageView iv4;
        @BindView(R.id.iv_5)
        ImageView iv5;
        @BindView(R.id.iv_6)
        ImageView iv6;
        @BindView(R.id.iv_small)
        ImageView ivSmall;
        @BindView(R.id.textView)
        TextView textView;
        @BindView(R.id.iv_love)
        ImageView ivLove;
        @BindView(R.id.love_count)
        TextView loveCount;
        @BindView(R.id.iv_message)
        ImageView ivMessage;
        @BindView(R.id.message_count)
        TextView messageCount;

        ViewHolder6(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
