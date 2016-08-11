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

    interface RequestDB{
        void isDBExists();
    }

    interface ResponseDB{
        void responseDB(boolean team);
    }

    interface GetDB{
        void getDB();
    }

    interface SendDB{
        void sendDB(Team team);
    }
}
