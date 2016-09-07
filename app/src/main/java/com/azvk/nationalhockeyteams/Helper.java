package com.azvk.nationalhockeyteams;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.EditText;

public class Helper {

    public boolean isValid(EditText inputName, EditText inputPassword) {
        return (!inputName.getText().toString().isEmpty() && !inputPassword.getText().toString().isEmpty());
    }
}
