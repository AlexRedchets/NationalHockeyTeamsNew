package com.azvk.nationalhockeyteams;

import android.app.Application;

import com.azvk.nationalhockeyteams.dependencies.ApiComponent;
import com.azvk.nationalhockeyteams.dependencies.DaggerApiComponent;
import com.azvk.nationalhockeyteams.dependencies.DaggerNetComponent;
import com.azvk.nationalhockeyteams.dependencies.NetComponent;
import com.azvk.nationalhockeyteams.dependencies.NetModule;

public class NHTApplication extends Application {

    private ApiComponent apiComponent;

    @Override
    public void onCreate() {
        resolveDependencies();
        super.onCreate();
    }

    private void resolveDependencies() {
        apiComponent = DaggerApiComponent.builder()
                .netComponent(getNetComponent())
                .build();
    }

    private NetComponent getNetComponent() {
        return DaggerNetComponent.builder()
                .netModule(new NetModule(Constant.BASE_URL))
                .build();
    }

    public ApiComponent getApiComponent(){
        return apiComponent;
    }
}
