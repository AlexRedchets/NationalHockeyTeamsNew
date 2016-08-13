package com.azvk.nationalhockeyteams.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.azvk.nationalhockeyteams.R;
import com.azvk.nationalhockeyteams.interfaces.TeamInterface;
import com.azvk.nationalhockeyteams.presenters.TeamPresenter;

public class SplashActivity extends AppCompatActivity implements TeamInterface.ResponseDB{

    private static final String TAG = SplashActivity.class.getSimpleName();
    private boolean team;
    private boolean sharpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate started");

        int splash_time_out = 3000;
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);

        TeamInterface.RequestDB requestDB = new TeamPresenter(this, this);
        requestDB.isDBExists();
        requestDB.checkSharePref();

        new Handler().postDelayed(() -> {
            //checking if sharedPreferences file exists
            if (sharpref) {
                Log.i(TAG, "SharePref contains username and password");
                Intent i = new Intent(SplashActivity.this, TeamInfoActivity.class);
                i.putExtra("team", team);
                startActivity(i);
                finish();
            } else {
                Log.i(TAG, "no username and password in SharePref");
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, splash_time_out);
    }

    @Override
    public void responseDB(boolean team) {
        Log.i(TAG, "responseDB started");
        this.team = team;
    }

    @Override
    public void responseSharePref(boolean sharpref) {
        Log.i(TAG, "responseSharePref started");
        this.sharpref = sharpref;
    }
}
