package com.azvk.nationalhockeyteams.interfaces;

import com.azvk.nationalhockeyteams.models.Roster;

import java.util.List;

public interface RostersInterface {
    interface ViewPresenterInterface {

        void getRoster();

    }

    interface PresenterViewInterface {

        void returnRosters(List<Roster> rosters);

    }



    interface PresenterModelInterface {

        void downloadRosters();
        void downloadRostersFromDB();

    }

    interface ModelPresenterInterface {

        void returnRosters(List<Roster> rosters);

    }
}
