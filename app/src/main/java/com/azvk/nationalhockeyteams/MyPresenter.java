package com.azvk.nationalhockeyteams;

import android.util.Log;

import com.azvk.nationalhockeyteams.client.UserClient;
import com.azvk.nationalhockeyteams.fragments.LoginFragment;
import com.azvk.nationalhockeyteams.fragments.RegistrationFragment;
import com.azvk.nationalhockeyteams.models.User;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MyPresenter {

    private static final String TAG = MyPresenter.class.getSimpleName();
    private LoginFragment loginView;
    private RegistrationFragment registrationView;
    private User user;

    public MyPresenter(LoginFragment view, String username, String password) {
        loginView = view;
        user = new User(username, password);
    }

    public MyPresenter(RegistrationFragment view, String username, String password) {
        registrationView = view;
        user = new User(username, password);
    }

    public void loginUser() {

        UserClient userClient = Generator.createService(UserClient.class);
        Observable<Boolean> userObservable = userClient.userLogin(user);
        userObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userData ->
                {if (userData){
                    Log.i(TAG, "Login successful");
                    loginView.userAuthSuccess(true);
                } else{
                    Log.i(TAG, "Login UNsuccessful");
                    loginView.userAuthSuccess(false);
                }
                },
                    throwable -> {
                        Log.e("Error", throwable.getMessage());
                    });
    }

    public void registrationUser() {

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
                                    registrationView.userExists();
                                    break;
                                case "1":
                                    Log.i(TAG, "Error on save");
                                    registrationView.errorOnSave();
                                    break;
                                default:
                                    Log.i(TAG, "User added");
                                    registrationView.userAdded();
                                    break;
                            }
                        },
                        throwable -> {
                            Log.e("Error", throwable.getMessage());
                        });
    }
}