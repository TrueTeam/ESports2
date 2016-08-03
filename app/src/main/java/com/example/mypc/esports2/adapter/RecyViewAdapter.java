package com.example.mypc.esports2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mypc.esports2.R;

import java.util.List;

/**
 * Created by MyPC on 2016/7/31.
 */
public class RecyViewAdapter extends RecyclerView.Adapter<RecyViewAdapter.ItemViewHolder> {

    private List<String> mList;
    public RecyViewAdapter(List<String> list){
        this.mList = list;
    }
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {


        holder.recy_text_view.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView recy_text_view;
        public ItemViewHolder(View itemView) {
            super(itemView);
            recy_text_view = (TextView) itemView.findViewById(R.id.recy_view_tv);
        }
    }
}
