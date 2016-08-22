package com.azvk.nationalhockeyteams.dependencies;

import dagger.Component;
import retrofit2.Retrofit;

@Component(modules = NetModule.class)
public interface NetComponent {

    Retrofit retrofit();
}
