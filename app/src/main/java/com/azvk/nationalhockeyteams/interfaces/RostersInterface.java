package com.azvk.nationalhockeyteams.interfaces;

import com.azvk.nationalhockeyteams.fragments.RostersFragment;
import com.azvk.nationalhockeyteams.models.Rosters;

import java.util.List;

public interface RostersInterface {
    interface ViewPresenterInterface {

        void getRoster();

    }

    interface PresenterViewInterface {

        void returnRosters(List<Rosters> rosters);

    }

    interface PresenterModelInterface {

        void downloadRosters();

    }

    interface ModelPresenterInterface {

        void returnRosters(List<Rosters> rosters);

    }
}
