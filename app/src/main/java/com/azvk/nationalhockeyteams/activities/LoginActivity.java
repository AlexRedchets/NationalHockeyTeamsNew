package com.azvk.nationalhockeyteams.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.azvk.nationalhockeyteams.login.LoginFragment;
import com.azvk.nationalhockeyteams.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_login, new LoginFragment())
                    .commit();
        }
    }
}

