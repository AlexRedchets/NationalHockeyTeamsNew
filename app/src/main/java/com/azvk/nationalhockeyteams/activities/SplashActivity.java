package com.azvk.nationalhockeyteams.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.azvk.nationalhockeyteams.Navigator;
import com.azvk.nationalhockeyteams.R;
import com.azvk.nationalhockeyteams.interfaces.TeamInterface;
import com.azvk.nationalhockeyteams.models.Team;
import com.azvk.nationalhockeyteams.presenters.TeamPresenter;

public class SplashActivity extends AppCompatActivity implements TeamInterface.ResponseDB{


    private boolean team;
    private TeamInterface.RequestDB requestDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int splash_time_out = 3000;
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);

        requestDB = new TeamPresenter(this, this);

        requestDB.isDBExists();

        new Handler().postDelayed(new Runnable() {

            SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

            @Override
            public void run() {
                //checking if sharedPreferences file exists
                if (sharedPref.contains("username") && (sharedPref.contains("password"))) {
                    Intent i = new Intent(SplashActivity.this, TeamInfoActivity.class);
                    i.putExtra("team", team);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }, splash_time_out);
    }

    @Override
    public void responseDB(boolean team) {
        this.team = team;
    }
}
