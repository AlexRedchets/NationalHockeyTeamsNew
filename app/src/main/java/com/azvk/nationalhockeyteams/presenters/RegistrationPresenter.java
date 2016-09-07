/*
package com.azvk.nationalhockeyteams.presenters;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.azvk.nationalhockeyteams.Generator;
import com.azvk.nationalhockeyteams.client.UserClient;
import com.azvk.nationalhockeyteams.login.LoginPresenter;
import com.azvk.nationalhockeyteams.models.User;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RegistrationPresenter implements LoginPresenter.LoginInterface.RegistrationViewPresenter{

    private static final String TAG = RegistrationPresenter.class.getSimpleName();
    private LoginPresenter.LoginInterface.RegistrationPresenterView view;
    private Context context;

    public RegistrationPresenter(LoginPresenter.LoginInterface.RegistrationPresenterView view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void registerUser(String username, String password) {
        Log.i(TAG, "registerUser started");

        User user = new User(username, password);
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
                                    saveUserInfoSharePref(username, password);
                                    view.registerAuthComplete(2);
                                    break;
                            }
                        },
                        throwable -> {
                            Log.e("Error", throwable.getMessage());
                            view.errorServer(throwable.getMessage());
                        });
    }

    private void saveUserInfoSharePref(String username, String password) {
        //save username and password into shared preferences
        SharedPreferences sharedPref = context.getSharedPreferences(
                "userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }
}
*/
