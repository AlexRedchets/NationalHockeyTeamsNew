package com.azvk.nationalhockeyteams.presenters;

import android.util.Log;

import com.azvk.nationalhockeyteams.fragments.RostersFragment;
import com.azvk.nationalhockeyteams.interfaces.ModelPresenterInterface;
import com.azvk.nationalhockeyteams.interfaces.PresenterViewInterface;
import com.azvk.nationalhockeyteams.interfaces.ViewPresenterInterface;
import com.azvk.nationalhockeyteams.interfaces.PresenterModelInterface;
import com.azvk.nationalhockeyteams.models.Rosters;
import com.azvk.nationalhockeyteams.models.RostersModel;

import java.util.List;

public class RostersPresenter implements ViewPresenterInterface, ModelPresenterInterface {

    private static final String TAG = RostersPresenter.class.getSimpleName();
    PresenterModelInterface presenterModelInterface;
    PresenterViewInterface presenterViewInterface;

    public RostersPresenter() {
    }

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
