package com.azvk.nationalhockeyteams.interfaces;

import com.azvk.nationalhockeyteams.models.Roster;

import java.util.List;

public interface RostersInterface {
    interface ViewPresenter {
        void getRoster();
    }

    interface PresenterView {
        void returnRosters(List<Roster> rosters);
    }

    interface PresenterModel {
        void downloadRosters();
    }

    interface ModelPresenter {
        void returnRosters(List<Roster> rosters);
    }

    interface ViewPresenterDB {
        void getRosterDB();
    }

    interface PresenterViewDB {
        void returnRostersDB(List<Roster> rosters);
    }

    interface PresenterModelDB {
        void downloadRostersDB();
    }

    interface ModelPresenterDB {
        void returnRostersDB(List<Roster> rosters);
    }
}