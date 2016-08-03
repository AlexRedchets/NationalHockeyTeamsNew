package com.azvk.nationalhockeyteams.presenters;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.azvk.nationalhockeyteams.fragments.RostersFragment;
import com.azvk.nationalhockeyteams.interfaces.RostersInterface;
import com.azvk.nationalhockeyteams.models.Rosters;
import com.azvk.nationalhockeyteams.models.RostersModel;

import java.util.List;

public class RostersPresenter implements RostersInterface.ViewPresenterInterface, RostersInterface.ModelPresenterInterface {

    private static final String TAG = RostersPresenter.class.getSimpleName();
    private RostersInterface.PresenterModelInterface presenterModelInterface;
    private RostersInterface.PresenterViewInterface presenterViewInterface;

    @Override
    public void getRoster() {
        Log.i(TAG, "getRoster started");
        presenterModelInterface = new RostersModel();
        presenterModelInterface.downloadRosters();
    }


    @Override
    public void returnRosters(List<Rosters> rosters) {
        Log.i(TAG, "returnRosters");
        presenterViewInterface = new RostersFragment();
        presenterViewInterface.returnRosters(rosters);
    }
}
