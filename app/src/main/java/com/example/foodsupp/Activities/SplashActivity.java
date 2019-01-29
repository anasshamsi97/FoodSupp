package com.example.foodsupp.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.foodsupp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        timerForLogin();
    }

    private void timerForLogin() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                launchLogin();
            }
        },2000);
    }

    private void launchLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

}
