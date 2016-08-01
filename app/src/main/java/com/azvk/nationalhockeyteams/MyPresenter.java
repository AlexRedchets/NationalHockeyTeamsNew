package com.azvk.nationalhockeyteams;

import android.util.Log;

import com.azvk.nationalhockeyteams.client.UserClient;
import com.azvk.nationalhockeyteams.fragments.LoginFragment;
import com.azvk.nationalhockeyteams.models.User;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MyPresenter {

    private static final String TAG = MyPresenter.class.getSimpleName();
    LoginFragment view;

    public MyPresenter(LoginFragment view) {
        this.view = view;
    }

    public void loginUser(String username, String password) {

        User user = new User(username, password);
        UserClient userClient = Generator.createService(UserClient.class);
        Observable<Boolean> userObservable = userClient.userLogin(user);
        userObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userData ->
                {if (userData){
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