package com.azvk.nationalhockeyteams.presenters;

import android.content.Context;

import com.azvk.nationalhockeyteams.NHTApplication;
import com.azvk.nationalhockeyteams.SQLite.DBHandler;
import com.azvk.nationalhockeyteams.interfaces.TeamInterface;
import com.azvk.nationalhockeyteams.models.Team;

public class SplashPresenter implements TeamInterface.RequestDB{

    TeamInterface.ResponseDB view;
    Context context;
    DBHandler dbHandler;
    Team team;

    public SplashPresenter(Context context, TeamInterface.ResponseDB view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void request() {
        dbHandler = new DBHandler(NHTApplication.getContext(), null, null, 1);
        team = dbHandler.getTeam();
        view.response(team);
    }
}
