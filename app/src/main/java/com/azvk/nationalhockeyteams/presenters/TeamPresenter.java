package com.azvk.nationalhockeyteams.presenters;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

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

public class TeamPresenter implements TeamInterface.ViewPresenter, TeamInterface.RequestDB, TeamInterface.GetDB {

    private TeamInterface.PresenterView presenterView;
    private TeamInterface.ResponseDB responseDB;
    private TeamInterface.SendDB sendDB;
    private static final String TAG = TeamPresenter.class.getSimpleName();
    private List<Team> teamsList;
    private DBHandler dbHandler;
    private Context context;
    private Team team;

    public TeamPresenter(TeamInterface.PresenterView presenterView, Context context) {
        this.presenterView = presenterView;
        this.context = context;
    }

    public TeamPresenter(TeamInterface.ResponseDB responseDB, Context context) {
        this.responseDB = responseDB;
        this.context = context;
    }

    public TeamPresenter(TeamInterface.SendDB sendDB, Context context) {
        this.sendDB = sendDB;
        this.context = context;
    }

    public void isDBExists() {
        dbHandler = new DBHandler(context, null, null, 1);
        team = dbHandler.getTeam();
        if (team.getName() != null )
            responseDB.responseDB(true);
        else
            responseDB.responseDB(false);
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
                            presenterView.returnTeam(teamsList);
                        },
                        throwable -> {
                            Log.e(TAG + "ERROR: ", throwable.getMessage());
                            presenterView.errorServer(throwable.getMessage());
                        });
    }

    @Override
    public void saveTeamDB(Team team) {
        dbHandler = new DBHandler(context, null, null, 1);
        dbHandler.addTeam(team);
        Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getDB() {
        dbHandler = new DBHandler(context, null, null, 1);
        team = dbHandler.getTeam();
        sendDB.sendDB(team);
    }
}
