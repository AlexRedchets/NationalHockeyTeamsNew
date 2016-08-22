package com.azvk.nationalhockeyteams.presenters;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.azvk.nationalhockeyteams.Generator;
import com.azvk.nationalhockeyteams.client.UserClient;
import com.azvk.nationalhockeyteams.interfaces.UserInterface;
import com.azvk.nationalhockeyteams.models.User;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static java.security.AccessController.getContext;


public class LoginPresenter implements UserInterface.LoginViewPresenter{

    private static final String TAG = LoginPresenter.class.getSimpleName();
    private UserInterface.LoginPresenterView view;
    private Context context;

    public LoginPresenter(UserInterface.LoginPresenterView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void loginUser(String username, String password) {

        User user = new User(username, password);

        UserClient userClient = Generator.createService(UserClient.class);
        Observable<Boolean> userObservable = userClient.userLogin(user);
        userObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userData -> {
                    if (userData){
                        Log.i(TAG, "Login successful");
                        saveUserInfoSharePref(username, password);
                        view.userAuthSuccess(true);
                    }else{
                        Log.i(TAG, "Login UNsuccessful");
                        view.userAuthSuccess(false);
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