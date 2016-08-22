package com.azvk.nationalhockeyteams.dependencies;

import com.azvk.nationalhockeyteams.models.Roster;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    @CustomScope
    Roster provideRoster(Retrofit retrofit){
        return retrofit.create(Roster.class);
    }
}
