package com.azvk.nationalhockeyteams.models;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.azvk.nationalhockeyteams.Generator;
import com.azvk.nationalhockeyteams.client.RostersClient;
import com.azvk.nationalhockeyteams.interfaces.RostersInterface;
import com.azvk.nationalhockeyteams.presenters.RostersPresenter;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RostersModel implements RostersInterface.PresenterModelInterface {

    private static final String TAG = RostersModel.class.getSimpleName();
    private List<Rosters> rosters;
    private RostersInterface.ModelPresenterInterface modelPresenterInterface;

    @Override
    public void downloadRosters() {
        Log.i(TAG, "downloadRosters started");
        RostersClient rostersClient = Generator.createService(RostersClient.class);
        Observable<List<Rosters>> rostersObservable = rostersClient.rosters("Russia");
        rostersObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(rostersData -> {
                    Log.i(TAG, "COOL");
                    rosters = rostersData;
                    modelPresenterInterface = new RostersPresenter();
                    modelPresenterInterface.returnRosters(rosters);
                },
                        throwable -> Log.e("Error", throwable.getMessage()));
    }
}
