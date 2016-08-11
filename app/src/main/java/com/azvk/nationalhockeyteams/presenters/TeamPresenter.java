package com.azvk.nationalhockeyteams.presenters;

import android.content.Context;
import android.util.Log;

import com.azvk.nationalhockeyteams.Generator;
import com.azvk.nationalhockeyteams.SQLite.DBHandler;
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
    private List<Team> teamsList;
    private DBHandler dbHandler;
    private Context context;

    public TeamPresenter(TeamInterface.PresenterView view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void getTeam() {
        Log.i(TAG, "getRoster started");

        dbHandler = new DBHandler(context, null, null, 1);

        TeamClient teamClient = Generator.createService(TeamClient.class);
        Observable<List<Team>> teamObservable = teamClient.teams();
        teamObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(teamsData -> {
                            Log.i(TAG, "Downloading data from server: SUCCESS");
                            teamsList = teamsData;
                            view.returnTeam(teamsList);
                        },
                        throwable -> {
                            Log.e(TAG + "ERROR: ", throwable.getMessage());
                            view.errorServer(throwable.getMessage());
                        });
    }
}
