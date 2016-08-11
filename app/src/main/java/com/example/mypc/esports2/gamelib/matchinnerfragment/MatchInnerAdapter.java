package com.example.mypc.esports2.gamelib.matchinnerfragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.bean.GamesBean;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by MyPC on 2016/8/3.
 */
public class MatchInnerAdapter extends BaseQuickAdapter<GamesBean> {
    //match_nature
    private static final String REGIST_END = "0";
    private static final String REGIST_NOSTART = "1";
    private static final String REGISTING_MARK = "2";
    private static final String ACTIVING_MARK = "3";
    private static final String UPLINE = "1";
    private static final String LOWELINE = "0";

    public MatchInnerAdapter(int layoutResId, List<GamesBean> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, GamesBean gamesBean) {
        baseViewHolder.setText(R.id.inner_tv_title, gamesBean.getTitle());
        if (gamesBean.getMatchAddress().length() > 0) {
            baseViewHolder.setText(R.id.tv_match_address, gamesBean.getMatchAddress());
            Bitmap bitmap = BitmapFactory.decodeResource(baseViewHolder.convertView.getResources(), R.mipmap.location);
            baseViewHolder.setImageBitmap(R.id.iv_match_address, bitmap);
        }else{
            baseViewHolder.setText(R.id.tv_match_address, "不限大区");
            Bitmap bitmap = BitmapFactory.decodeResource(baseViewHolder.convertView.getResources(), R.mipmap.match_online);
            baseViewHolder.setImageBitmap(R.id.iv_match_address, bitmap);
        }
        String applytime = getDate(gamesBean.getApplyStartTime());
        baseViewHolder.setText(R.id.tv_apply_start_time, applytime);
        String applyendtime = getDate(gamesBean.getApplyEndTime());
        baseViewHolder.setText(R.id.tv_apply_end_time,applyendtime);
        String starttime = getDate(gamesBean.getStartTime());
        baseViewHolder.setText(R.id.tv_match_start_time,starttime);
        String endtime = getDate(gamesBean.getEndTime());
        baseViewHolder.setText(R.id.tv_end_time,endtime);
        File photoCacheDir = Glide.getPhotoCacheDir(baseViewHolder.convertView.getContext());
    Glide.with(baseViewHolder.getConvertView().getContext())
            .load(gamesBean.getCoverLink())
//                .placeholder(R.mipmap.recyad)
            .into((ImageView) baseViewHolder.getView(R.id.care_image));
    setMatchStatus(gamesBean.getMatchStatus(), baseViewHolder);
    setMatchNature(gamesBean.getMatchStatus(), baseViewHolder);

    }

    private String getDate(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        long time1 = date.getTime();
        long l = time1 +Long.parseLong(time)/2 ;
        return  format.format(new Date(l));
    }

    private void setMatchNature(String nature,BaseViewHolder baseViewHolder) {
        switch(nature){
               case UPLINE:
                   baseViewHolder.setText(R.id.tv_match_status,"线上赛");
                     break;
               case LOWELINE:
                   baseViewHolder.setText(R.id.tv_match_status,"线下赛");
                     break;

        }
    }

    // 线上线下  nature
    private void setMatchStatus(String match, BaseViewHolder baseViewHolder) {
        switch (match) {
            case REGIST_END:
                Bitmap bitmap = BitmapFactory.decodeResource(baseViewHolder.convertView.getResources(), R.mipmap.regist_end_mark);
                baseViewHolder.setImageBitmap(R.id.iv_match_status, bitmap);
                break;
            case REGIST_NOSTART:
                bitmap = BitmapFactory.decodeResource(baseViewHolder.convertView.getResources(), R.mipmap.regist_nostart);
                baseViewHolder.setImageBitmap(R.id.iv_match_status, bitmap);
                break;
            case REGISTING_MARK:

                bitmap = BitmapFactory.decodeResource(baseViewHolder.convertView.getResources(), R.mipmap.registing_mark);
                baseViewHolder.setImageBitmap(R.id.iv_match_status, bitmap);
                break;
            case ACTIVING_MARK:
                bitmap = BitmapFactory.decodeResource(baseViewHolder.convertView.getResources(), R.mipmap.activing_mark);
                baseViewHolder.setImageBitmap(R.id.iv_match_status, bitmap);
                break;

        }
    }
}
