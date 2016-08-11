package com.azvk.nationalhockeyteams.interfaces;

import com.azvk.nationalhockeyteams.models.Team;

import java.util.List;

public interface TeamInterface {

    interface ViewPresenter{
        void getTeam();
        void saveTeamDB(Team team);
    }

    interface PresenterView{
        void returnTeam(List<Team> teamsList);
        void errorServer(String error);
    }
}
