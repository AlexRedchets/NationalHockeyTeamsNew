package com.azvk.nationalhockeyteams.presenters;

import android.util.Log;

import com.azvk.nationalhockeyteams.Generator;
import com.azvk.nationalhockeyteams.client.UserClient;
import com.azvk.nationalhockeyteams.interfaces.UserInterface;
import com.azvk.nationalhockeyteams.models.User;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class LoginPresenter implements UserInterface.LoginViewPresenter{

    private static final String TAG = LoginPresenter.class.getSimpleName();
    private UserInterface.LoginPresenterView view;
    private User user;

    public LoginPresenter(UserInterface.LoginPresenterView view) {
        this.view = view;
    }

    public void loginUser(String username, String password) {

        user = new User(username, password);

        UserClient userClient = Generator.createService(UserClient.class);
        Observable<Boolean> userObservable = userClient.userLogin(user);
        userObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userData -> {
                    if (userData){
                    Log.i(TAG, "Login successful");
                    view.userAuthSuccess(true);
                } else{
                    Log.i(TAG, "Login UNsuccessful");
                    view.userAuthSuccess(false);
                }
                },
                    throwable -> {
                        Log.e("Error", throwable.getMessage());
                    });
    }
}