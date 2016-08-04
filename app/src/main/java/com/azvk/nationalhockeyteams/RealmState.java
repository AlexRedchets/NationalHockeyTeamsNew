package com.azvk.nationalhockeyteams;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

import static java.security.AccessController.getContext;

public class RealmState {

    private Realm realm;
    private RealmConfiguration realmConfig;
    private Context context;

    public RealmState(Context context) {

        this.context = context;
        //Initialize Realm
        realmConfig = new RealmConfiguration
                .Builder(context)
                .name("rosters")
                .deleteRealmIfMigrationNeeded()
                .build();
        realm = Realm.getInstance(realmConfig);
    }

    public Realm getRealm() {
        return realm;
    }
}
