package com.azvk.nationalhockeyteams.presenters;

import android.util.Log;

import com.azvk.nationalhockeyteams.Generator;
import com.azvk.nationalhockeyteams.client.UserClient;
import com.azvk.nationalhockeyteams.interfaces.UserInterface;
import com.azvk.nationalhockeyteams.models.User;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RegistrationPresenter implements UserInterface.RegistrationViewPresenter{

    private static final String TAG = RegistrationPresenter.class.getSimpleName();
    private UserInterface.RegistrationPresenterView view;
    private User user;

    public RegistrationPresenter(UserInterface.RegistrationPresenterView view) {
        this.view = view;
    }

    @Override
    public void registerUser(String username, String password) {
        Log.i(TAG, "registerUser started");
        user = new User(username, password);
        UserClient userClient = Generator.createService(UserClient.class);
        Observable<String> userObservable = userClient.userRegistration(user);
        userObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userData ->
                        {
                            switch (userData) {
                                case "0":
                                    Log.i(TAG, "User exists");
                                    view.registerAuthComplete(0);
                                    break;
                                case "1":
                                    Log.i(TAG, "Error on save");
                                    view.registerAuthComplete(1);
                                    break;
                                case "2":
                                    Log.i(TAG, "User added");
                                    view.registerAuthComplete(2);
                                    break;
                            }
                        },
                        throwable -> {
                            Log.e("Error", throwable.getMessage());
                        });
    }
}
