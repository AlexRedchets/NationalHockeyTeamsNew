package com.azvk.nationalhockeyteams.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.azvk.nationalhockeyteams.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int splash_time_out = 3000;

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //checking if sharedPreferences file exists
                if (sharedPref.contains("username") && (sharedPref.contains("password"))) {
                    Intent i = new Intent(SplashActivity.this, TeamInfoActivity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                }
            }
        }, splash_time_out);
    }
}
