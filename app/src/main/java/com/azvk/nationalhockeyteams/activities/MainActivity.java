package com.azvk.nationalhockeyteams.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.azvk.nationalhockeyteams.NHTApplication;
import com.azvk.nationalhockeyteams.R;
import com.azvk.nationalhockeyteams.client.RostersClient;
import com.azvk.nationalhockeyteams.interfaces.RosterViewInterface;
import com.azvk.nationalhockeyteams.models.Roster;
import com.azvk.nationalhockeyteams.presenters.RosterPresenter;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class MainActivity extends AppCompatActivity implements RosterViewInterface {

    @Inject
    RostersClient rostersClient;

    private RosterPresenter rosterPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((NHTApplication)getApplication())
                .getApiComponent()
                .inject(this);

        rosterPresenter = new RosterPresenter(this);
        rosterPresenter.onCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        rosterPresenter.onResume();
        rosterPresenter.fetchRoster();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onRoster(List<Roster> rosters) {

    }

    @Override
    public Observable<List<Roster>> getRosters() {
        return rostersClient.getRosters("Russia");
    }
}
