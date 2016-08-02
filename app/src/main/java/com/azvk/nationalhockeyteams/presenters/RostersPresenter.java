package com.azvk.nationalhockeyteams.presenters;

import android.provider.Settings;
import android.util.Log;

import com.azvk.nationalhockeyteams.Generator;
import com.azvk.nationalhockeyteams.client.RostersClient;
import com.azvk.nationalhockeyteams.client.UserClient;
import com.azvk.nationalhockeyteams.models.Rosters;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RostersPresenter {

    private static final String TAG = RostersPresenter.class.getSimpleName();

    public RostersPresenter() {
        Rosters rosters = new Rosters();
        RostersClient rostersClient = Generator.createService(RostersClient.class);
        Observable<List<Rosters>> rostersObservable = rostersClient.rosters("Russia");
        rostersObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(rostersData -> System.out.print("COOL"),
                        throwable -> Log.e("Error", throwable.getMessage()));
    }
}
