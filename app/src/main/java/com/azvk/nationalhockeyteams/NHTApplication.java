package com.azvk.nationalhockeyteams;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class NHTApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration realmConfig = new RealmConfiguration
                .Builder(this)
                .name("rosters")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfig);
    }
}
