package com.example.mypc.esports2.main.persondetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.mypc.esports2.R;
import com.example.mypc.esports2.base.BaseActivity;
import com.example.mypc.esports2.bean.PersonDetailsBean;

public class PersonDetailsActivity extends BaseActivity implements PersonDetailsContract.View {

    private PersonDetailsContract.Persenter persenter;
    private PersonDetailsContract.Model model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new PersonDetailsModel();
        persenter = new PersonDetailsPersenter(this, model);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        persenter.getDate(id);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_person_details;
    }


    @Override
    public void onSuccess(PersonDetailsBean result) {

    }

    @Override
    public void onFail(String erro) {

    }
}
