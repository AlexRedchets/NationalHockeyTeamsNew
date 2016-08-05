package com.azvk.nationalhockeyteams.presenters;

import android.util.Log;

import com.azvk.nationalhockeyteams.interfaces.RostersInterface;
import com.azvk.nationalhockeyteams.models.Roster;
import com.azvk.nationalhockeyteams.models.RostersDBModel;
import com.azvk.nationalhockeyteams.models.RostersModel;

import java.util.List;

public class RostersDBPresenter implements RostersInterface.ViewPresenterDB, RostersInterface.ModelPresenterDB {

    private static final String TAG = RostersDBPresenter.class.getSimpleName();
    private RostersInterface.PresenterModelDB presenterModelDB;
    private RostersInterface.PresenterViewDB context;


    public RostersDBPresenter(RostersInterface.PresenterViewDB context) {
        this.context = context;
        presenterModelDB = new RostersDBModel(this);
    }

    @Override
    public void getRosterDB() {
        Log.i(TAG, "getRosterDB started");
        presenterModelDB.downloadRostersDB();
    }

    @Override
    public void returnRostersDB(List<Roster> rosters) {
        Log.i(TAG, "returnRostersDB");
        if (context != null) {
            context.returnRostersDB(rosters);
        }
    }
}
