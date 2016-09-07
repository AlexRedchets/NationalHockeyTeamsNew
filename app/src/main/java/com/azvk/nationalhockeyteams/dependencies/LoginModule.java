package com.azvk.nationalhockeyteams.dependencies;

import com.azvk.nationalhockeyteams.interfaces.LoginInterface;

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
    @Singleton
    LoginInterface.View provideLoginInterfaceView(){
        return view;
    }
}