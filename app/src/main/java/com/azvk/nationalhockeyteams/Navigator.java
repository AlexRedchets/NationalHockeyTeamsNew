package com.azvk.nationalhockeyteams;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Navigator {

    private Context context;

    public Navigator(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
