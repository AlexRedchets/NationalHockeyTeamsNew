package com.azvk.nationalhockeyteams.models;

import android.util.Log;

import com.azvk.nationalhockeyteams.Generator;
import com.azvk.nationalhockeyteams.client.RostersClient;
import com.azvk.nationalhockeyteams.interfaces.RostersInterface;

import java.util.List;

import io.realm.Realm;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RostersModel implements RostersInterface.PresenterModel {

    private static final String TAG = RostersModel.class.getSimpleName();
    private List<Roster> rosters;
    private RostersInterface.ModelPresenter view;
    private Realm realm;
    private List<Roster> rosterList;


    public RostersModel(RostersInterface.ModelPresenter view) {
        this.view = view;
    }

    @Override
    public void downloadRosters() {
        Log.i(TAG, "downloadRosters started");
        RostersClient rostersClient = Generator.createService(RostersClient.class);
        Observable<List<Roster>> rostersObservable = rostersClient.rosters("Russia");
        rostersObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(rostersData -> {
                            Log.i(TAG, "COOL");
                            rosters = rostersData;
                            view.returnRosters(rosters);
                        },
                        throwable -> Log.e("Error", throwable.getMessage()));
    }

    @Override
    public void downloadRostersDB() {
        Log.i(TAG, "downloadRostersDB started");
        realm = Realm.getDefaultInstance();
        rosterList = realm.where(Roster.class).findAll();
        view.returnRostersDB(rosterList);
    }
}
