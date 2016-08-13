package com.azvk.nationalhockeyteams.interfaces;

import com.azvk.nationalhockeyteams.models.Team;

import java.util.List;

public interface TeamInterface {

    interface TeamListViewPresenter{
        void getTeamList();
        void getTeamListDB();
        void saveTeamDB(Team team);
    }

    interface TeamListPresenterView{
        void returnTeam(List<Team> teamsList);
        void errorServer(String error);
        void returnTeamListDB(List<Team> teamsList);
    }

    interface RequestDB{
        void isDBExists();
        void getDB();
        void checkSharePref();
    }

    interface ResponseDB{
        void responseDB(boolean team);
        void responseSharePref(boolean sharpref);
    }

    interface SendDB{
        void sendDB(Team team);
    }
}
