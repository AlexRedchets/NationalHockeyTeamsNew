package com.azvk.nationalhockeyteams.interfaces;

public interface TeamInterface {

    interface ViewPresenter{
        void getTeam();
    }

    interface PresenterView{
        void returnTeam();
    }
}
