package com.azvk.nationalhockeyteams.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.azvk.nationalhockeyteams.fragments.LoginFragment;
import com.azvk.nationalhockeyteams.R;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_login, new LoginFragment(), "loginFragment")
                    .commit();
        }
        else{
            Log.i(TAG, "savedInstanceState NOT null");
            LoginFragment loginFragment =  (LoginFragment) getSupportFragmentManager().findFragmentByTag("loginFragment");
        }
    }
}
