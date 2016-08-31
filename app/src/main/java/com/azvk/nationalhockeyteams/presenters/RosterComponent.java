package com.azvk.nationalhockeyteams.presenters;

import com.azvk.nationalhockeyteams.activities.MainActivity;
import com.azvk.nationalhockeyteams.dependencies.CustomScope;
import com.azvk.nationalhockeyteams.dependencies.NetComponent;
import com.azvk.nationalhockeyteams.dependencies.NetModule;

import dagger.Component;

@CustomScope
@Component(modules = RosterModule.class, dependencies = NetComponent.class)
public interface RosterComponent {
    void inject(MainActivity activity);
}
