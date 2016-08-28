package com.azvk.nationalhockeyteams.interfaces;

import com.azvk.nationalhockeyteams.models.Roster;

import java.util.List;

import rx.Observable;

public interface RosterViewInterface {

    void onCompleted();

    void onError(String message);

    void onRoster(List<Roster> rosters);

    Observable<List<Roster>> getRosters();
}
