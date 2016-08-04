package com.azvk.nationalhockeyteams.realm;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import com.azvk.nationalhockeyteams.models.Roster;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmController {

    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application) {
        realm = Realm.getDefaultInstance();
    }

    public static RealmController with(Fragment fragment) {

        if (instance == null) {
            instance = new RealmController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static RealmController with(Activity activity) {

        if (instance == null) {
            instance = new RealmController(activity.getApplication());
        }
        return instance;
    }

    public static RealmController with(Application application) {

        if (instance == null) {
            instance = new RealmController(application);
        }
        return instance;
    }

    public static RealmController getInstance() {

        return instance;
    }

    public Realm getRealm() {

        return realm;
    }

    //Refresh the realm istance
    public void refresh() {

        realm.waitForChange();
    }

    //clear all objects from Roster.class
    public void clearAll() {

        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }

    //find all objects in the Roster.class
    public RealmResults<Roster> getRoster() {

        return realm.where(Roster.class).findAll();
    }

    //query a single item with the given id
    public Roster getRoster(String id) {

        return realm.where(Roster.class).equalTo("name", id).findFirst();
    }

    //check if Roster.class is empty
    public boolean hasRosters() {

        return !realm.where(Roster.class).findAll().isEmpty();
    }

    //query example
    public RealmResults<Roster> queryedRoster() {

        return realm.where(Roster.class)
                .contains("author", "Author 0")
                .or()
                .contains("title", "Realm")
                .findAll();

    }

}
