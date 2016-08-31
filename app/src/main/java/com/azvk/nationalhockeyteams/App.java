package com.azvk.nationalhockeyteams;

import android.app.Application;

import com.azvk.nationalhockeyteams.dependencies.AppModule;
import com.azvk.nationalhockeyteams.dependencies.DaggerNetComponent;
import com.azvk.nationalhockeyteams.dependencies.NetComponent;
import com.azvk.nationalhockeyteams.dependencies.NetModule;

public class App extends android.app.Application {

    private NetComponent netComponent;

    @Override
    public void onCreate() {
        resolveDependencies();
        super.onCreate();
    }

    private void resolveDependencies() {
        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://54.186.57.223:3000/"))
                .build();
    }

    public NetComponent getNetComponent(){
        return netComponent;
    }

}
