package com.azvk.nationalhockeyteams.presenters;

import android.util.Log;

import com.azvk.nationalhockeyteams.interfaces.RostersInterface;
import com.azvk.nationalhockeyteams.models.Roster;
import com.azvk.nationalhockeyteams.models.RostersModel;

import java.util.List;

public class RostersPresenter implements RostersInterface.ViewPresenter, RostersInterface.ModelPresenter {

    private static final String TAG = RostersPresenter.class.getSimpleName();
    private RostersInterface.PresenterModel presenterModel;
    RostersInterface.PresenterView view;


    public RostersPresenter(RostersInterface.PresenterView view) {
        this.view = view;
        presenterModel = new RostersModel(this);
    }

    @Override
    public void getRoster() {
        Log.i(TAG, "getRoster started");
        presenterModel.downloadRosters();
    }

    @Override
    public void returnRosters(List<Roster> rosters) {
        Log.i(TAG, "returnRosters");
        if (view != null) {
            view.returnRosters(rosters);
        }
    }
}