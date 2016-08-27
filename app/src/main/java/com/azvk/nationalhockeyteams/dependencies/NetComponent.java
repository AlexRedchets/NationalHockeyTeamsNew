package com.azvk.nationalhockeyteams.dependencies;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = NetModule.class)
public interface NetComponent {

    Retrofit retrofit();
}
