package com.azvk.nationalhockeyteams.dependencies;

import com.azvk.nationalhockeyteams.login.LoginComponent;
import com.azvk.nationalhockeyteams.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    LoginComponent inject (LoginModule module);
}
