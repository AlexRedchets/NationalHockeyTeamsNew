package com.azvk.nationalhockeyteams.presenters;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.azvk.nationalhockeyteams.Generator;
import com.azvk.nationalhockeyteams.SQLite.DBHandler;
import com.azvk.nationalhockeyteams.client.TeamClient;
import com.azvk.nationalhockeyteams.interfaces.TeamInterface;
import com.azvk.nationalhockeyteams.models.Team;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TeamPresenter implements TeamInterface.TeamListViewPresenter, TeamInterface.RequestDB {

    private static final String TAG = TeamPresenter.class.getSimpleName();
    private TeamInterface.TeamListPresenterView presenterView;
    private TeamInterface.ResponseDB responseDB;
    private TeamInterface.SendDB sendDB;
    private List<Team> teamsList;
    private DBHandler dbHandler;
    private Context context;
    private Realm realm;
    private Team team;

    public TeamPresenter(TeamInterface.TeamListPresenterView presenterView, Context context) {
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
        Log.i(TAG, "isDBExists started");
        dbHandler = new DBHandler(context, null, null, 1);
        team = dbHandler.getTeam();
        if (team.getName() != null )
            responseDB.responseDB(true);
        else
            responseDB.responseDB(false);
    }

    @Override
    public void getTeamList() {
        Log.i(TAG, "getRoster started");

        TeamClient teamClient = Generator.createService(TeamClient.class);
        Observable<List<Team>> teamObservable = teamClient.teams();
        teamObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(teamsData -> {
                            Log.i(TAG, "Downloading data from server: SUCCESS");
                            teamsList = teamsData;

                            RealmConfiguration realmConfig = new RealmConfiguration
                                    .Builder(context)
                                    .name("teams")
                                    .deleteRealmIfMigrationNeeded()
                                    .build();
                            Realm.setDefaultConfiguration(realmConfig);

                            if (teamsList != null){
                                //save data to DB
                                realm = Realm.getDefaultInstance();
                                realm.beginTransaction();
                                if (realm != null){
                                    realm.deleteAll();
                                }
                                realm.copyToRealmOrUpdate(teamsList);
                                realm.commitTransaction();
                            }
                            presenterView.returnTeam(teamsList);
                        },
                        throwable -> {
                            Log.e(TAG + "ERROR: ", throwable.getMessage());
                            presenterView.errorServer(throwable.getMessage());
                        });
    }

    @Override
    public void getTeamListDB() {
        RealmConfiguration realmConfig = new RealmConfiguration
                .Builder(context)
                .name("teams")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfig);

        realm = Realm.getDefaultInstance();
        teamsList = realm.where(Team.class).findAll();
        presenterView.returnTeamListDB(teamsList);
    }

    @Override
    public void saveTeamDB(Team team) {
        Log.i(TAG, "saveTeamDB started");
        dbHandler = new DBHandler(context, null, null, 1);
        dbHandler.addTeam(team);
        Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show();
        presenterView.runTeamInfo();
    }

    @Override
    public void getDB() {
        Log.i(TAG, "getDB started");
        dbHandler = new DBHandler(context, null, null, 1);
        team = dbHandler.getTeam();
        sendDB.sendDB(team);
    }

    @Override
    public void checkSharePref() {
        SharedPreferences sharedPref = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        if (sharedPref.contains("username") && (sharedPref.contains("password"))){
            responseDB.responseSharePref(true);
        }
        else {
            responseDB.responseSharePref(false);
        }
    }
}
