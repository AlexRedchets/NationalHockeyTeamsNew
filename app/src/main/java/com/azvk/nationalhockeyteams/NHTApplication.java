package com.azvk.nationalhockeyteams;

import android.app.Application;

import com.azvk.nationalhockeyteams.dependencies.ApiComponent;
import com.azvk.nationalhockeyteams.dependencies.DaggerApiComponent;
import com.azvk.nationalhockeyteams.dependencies.DaggerNetComponent;
import com.azvk.nationalhockeyteams.dependencies.NetComponent;

public class NHTApplication extends Application {

    @Override
    public void onCreate() {
        resolveDependencies();
        super.onCreate();
    }

    private void resolveDependencies() {
        ApiComponent apiComponent = DaggerApiComponent.builder()
                .netComponent(getNetComponent())
                .build();
    }

    private NetComponent getNetComponent() {
        return DaggerNetComponent.builder()
                .build();
    }
}
