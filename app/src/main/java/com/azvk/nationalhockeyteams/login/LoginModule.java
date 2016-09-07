package com.azvk.nationalhockeyteams.login;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    private LoginInterface.View view;

    public LoginModule(LoginInterface.View view) {
        this.view = view;
    }

    @Provides
    @LoginScope
    LoginInterface.View provideLoginInterfaceView(){
        return view;
    }
}
