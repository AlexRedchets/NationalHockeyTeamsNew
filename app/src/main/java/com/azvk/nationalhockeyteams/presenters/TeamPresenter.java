package com.azvk.nationalhockeyteams.presenters;

import android.util.Log;

import com.azvk.nationalhockeyteams.Generator;
import com.azvk.nationalhockeyteams.client.RostersClient;
import com.azvk.nationalhockeyteams.client.TeamClient;
import com.azvk.nationalhockeyteams.interfaces.TeamInterface;
import com.azvk.nationalhockeyteams.models.Roster;
import com.azvk.nationalhockeyteams.models.Team;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TeamPresenter implements TeamInterface.ViewPresenter {

    private TeamInterface.PresenterView view;
    private static final String TAG = TeamPresenter.class.getSimpleName();

    public TeamPresenter(TeamInterface.PresenterView view) {
        this.view = view;
    }

    @Override
    public void getTeam() {
        Log.i(TAG, "getRoster started");

        TeamClient teamClient = Generator.createService(TeamClient.class);
        Observable<List<Team>> teamObservable = rostersClient.rosters("Russia");
        rostersObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(rostersData -> {
                            Log.i(TAG, "Downloading data from server: SUCCESS");
                            rosterList = rostersData;
                            view.returnRosters(rosterList);
                        },
                        throwable -> Log.e(TAG + "ERROR: ", throwable.getMessage()));
    }
}
