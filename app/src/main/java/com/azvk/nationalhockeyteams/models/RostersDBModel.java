package com.azvk.nationalhockeyteams.models;

import android.util.Log;

import com.azvk.nationalhockeyteams.RealmState;
import com.azvk.nationalhockeyteams.interfaces.RostersInterface;

import java.util.List;

import io.realm.Realm;

public class RostersDBModel implements RostersInterface.PresenterModelDB {

    private static final String TAG = RostersDBModel.class.getSimpleName();
    private List<Roster> rosters;
    private RostersInterface.ModelPresenterDB view;
    private Realm realm;
    private List<Roster> rosterList;


    public RostersDBModel(RostersInterface.ModelPresenterDB view) {
        this.view = view;

    }

    @Override
    public void downloadRostersDB() {
        Log.i(TAG, "downloadRostersDB started");
        realm = Realm.getDefaultInstance();
        rosterList = realm.where(Roster.class).findAll();
        view.returnRostersDB(rosterList);
    }
}
