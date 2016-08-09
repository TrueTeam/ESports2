package com.example.mypc.esports2.main.linkpage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.mypc.esports2.MyApp;
import com.example.mypc.esports2.R;

public class ShowHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_home);
        final Handler handler=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                //要做的事情
                if (MyApp.isFirstStart(ShowHomeActivity.this)) {
                    startActivity(new Intent(ShowHomeActivity.this, MyIntroActivity.class));
                }else{
                    finish();
                }

                handler.postDelayed(this, 3000);
            }
        };
        handler.postDelayed(runnable, 3000);//每两秒执行一次runnable.

    }
}
