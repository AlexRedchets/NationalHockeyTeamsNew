/*

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

public class TeamFromDBPresenter implements TeamInterface.GetDB {


    private TeamInterface.SendDB sendDB;
    private static final String TAG = com.azvk.nationalhockeyteams.presenters.TeamFromDBPresenter.class.getSimpleName();

    private DBHandler dbHandler;
    private Context context;
    private Team team;

    public TeamFromDBPresenter(TeamInterface.SendDB sendDB, Context context) {
        this.sendDB = sendDB;
        this.context = context;
    }

    @Override
    public void getDB() {
        dbHandler = new DBHandler(context, null, null, 1);
        team = dbHandler.getTeam();
        sendDB.sendDB(team);
    }
}
*/
