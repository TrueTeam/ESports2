package com.example.mypc.esports2.main.persondetails;

import android.content.Intent;
import android.os.Bundle;

import com.alexvasilkov.gestures.views.GestureImageView;
import com.bumptech.glide.Glide;
import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;

import butterknife.BindView;

public class PersonDetailsPicActivity extends BaseActivity {

    @BindView(R.id.gestureimage)
    GestureImageView gestureimage;

    @Override
    public int getLayoutID() {
        return R.layout.activity_person_details_pic;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String headLink = intent.getStringExtra("headLink");
        gestureimage = (GestureImageView) findViewById(R.id.gestureimage);
        Glide.with(this).load(headLink).into(gestureimage);

    }
}
