package com.azvk.nationalhockeyteams.presenters;

import android.util.Log;

import com.azvk.nationalhockeyteams.interfaces.RostersInterface;
import com.azvk.nationalhockeyteams.models.Roster;
import com.azvk.nationalhockeyteams.models.RostersModel;

import java.util.List;

public class RostersPresenter implements RostersInterface.ViewPresenterInterface, RostersInterface.ModelPresenterInterface {

    private static final String TAG = RostersPresenter.class.getSimpleName();
    private RostersInterface.PresenterModelInterface presenterModelInterface;
    private RostersInterface.PresenterViewInterface presenterViewInterface;
    RostersInterface.PresenterViewInterface view;


    public RostersPresenter(RostersInterface.PresenterViewInterface view) {
        this.view = view;
        presenterModelInterface = new RostersModel(this);
    }

    @Override
    public void getRoster() {
        Log.i(TAG, "getRoster started");
        presenterModelInterface.downloadRosters();
    }


    @Override
    public void returnRosters(List<Roster> rosters) {
        Log.i(TAG, "returnRosters");
        if (view != null) {
            view.returnRosters(rosters);
        }
    }
}
