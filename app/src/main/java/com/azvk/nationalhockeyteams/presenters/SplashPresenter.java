/*
package com.azvk.nationalhockeyteams.presenters;

import android.content.Context;

import com.azvk.nationalhockeyteams.SQLite.DBHandler;
import com.azvk.nationalhockeyteams.interfaces.TeamInterface;
import com.azvk.nationalhockeyteams.models.Team;

public class SplashPresenter implements TeamInterface.RequestDB{

    private TeamInterface.ResponseDB view;
    private Context context;
    private DBHandler dbHandler;
    private Team team;

    public SplashPresenter(TeamInterface.ResponseDB view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void request() {
        dbHandler = new DBHandler(context, null, null, 1);
        team = dbHandler.getTeam();
        if (team.getName() != null )
            view.response(true);
        else
            view.response(false);
    }
}
*/
