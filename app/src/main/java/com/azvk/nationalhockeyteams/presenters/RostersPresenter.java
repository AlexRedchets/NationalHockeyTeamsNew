package com.azvk.nationalhockeyteams.presenters;

import android.util.Log;

import com.azvk.nationalhockeyteams.Generator;
import com.azvk.nationalhockeyteams.client.RostersClient;
import com.azvk.nationalhockeyteams.interfaces.RostersInterface;
import com.azvk.nationalhockeyteams.models.Roster;

import java.util.List;

import io.realm.Realm;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RostersPresenter implements RostersInterface.ViewPresenter {

    private static final String TAG = RostersPresenter.class.getSimpleName();
    private RostersInterface.PresenterView view;
    private List<Roster> rosterList;
    private Realm realm;


    public RostersPresenter(RostersInterface.PresenterView view) {
        this.view = view;
    }

    @Override
    public void getRoster() {
        Log.i(TAG, "getRoster started");

        RostersClient rostersClient = Generator.createService(RostersClient.class);
        Observable<List<Roster>> rostersObservable = rostersClient.rosters("Russia");
        rostersObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(rostersData -> {
                            Log.i(TAG, "Downloading data from server: SUCCESS");
                            rosterList = rostersData;
                            //save data to DB
                            realm = Realm.getDefaultInstance();
                            realm.beginTransaction();
                            if (realm != null){
                                realm.deleteAll();
                            }
                            realm.copyToRealmOrUpdate(rosterList);
                            realm.commitTransaction();

                            view.returnRosters(rosterList);
                        },
                        throwable -> {
                            Log.e(TAG + "ERROR: ", throwable.getMessage());
                            view.returnError(throwable.getMessage());
                        });
    }

    @Override
    public void getRosterDB() {
        Log.i(TAG, "getRosterDB started");

        realm = Realm.getDefaultInstance();
        rosterList = realm.where(Roster.class).findAll();
        view.returnRostersDB(rosterList);
    }
}