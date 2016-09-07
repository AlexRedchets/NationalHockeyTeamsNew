package com.azvk.nationalhockeyteams.presenters;

import com.azvk.nationalhockeyteams.interfaces.RosterViewInterface;

import dagger.Module;
import dagger.Provides;

@Module
public class RosterModule {

    private RosterViewInterface rosterViewInterface;

    public RosterModule(RosterViewInterface rosterViewInterface) {
        this.rosterViewInterface = rosterViewInterface;
    }

    @Provides
    @CustomScope
    RosterViewInterface getRosterViewInterface(){
        return rosterViewInterface;
    }
}
