package com.azvk.nationalhockeyteams.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.azvk.nationalhockeyteams.R;
import com.azvk.nationalhockeyteams.fragments.LoginFragment;
import com.azvk.nationalhockeyteams.fragments.RegistrationFragment;

public class RegistrationActivity extends AppCompatActivity {

    private static final String TAG = RegistrationActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_registration, new RegistrationFragment(), "registrationFragment")
                    .commit();
        }
        else{
            Log.i(TAG, "savedInstanceState NOT null");
            RegistrationFragment registrationFragment =  (RegistrationFragment) getSupportFragmentManager().findFragmentByTag("registrationFragment");
        }
    }
}
