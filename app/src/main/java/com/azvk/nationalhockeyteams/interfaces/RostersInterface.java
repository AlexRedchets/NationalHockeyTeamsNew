package com.azvk.nationalhockeyteams.interfaces;

import com.azvk.nationalhockeyteams.models.Roster;

import java.util.List;

public interface RostersInterface {
    interface ViewPresenter {
        void getRoster();
        void getRosterDB();
    }

    interface PresenterView {
        void returnRosters(List<Roster> rosters);
        void returnRostersDB(List<Roster> rosters);
    }

    interface PresenterModel {
        void downloadRosters();
        void downloadRostersDB();
    }

    interface ModelPresenter {
        void returnRosters(List<Roster> rosters);
        void returnRostersDB(List<Roster> rosters);
    }
}