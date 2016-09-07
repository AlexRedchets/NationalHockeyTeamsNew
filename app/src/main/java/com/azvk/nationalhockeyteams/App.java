package com.azvk.nationalhockeyteams;

import com.azvk.nationalhockeyteams.dependencies.AppModule;
import com.azvk.nationalhockeyteams.dependencies.DaggerNetComponent;
import com.azvk.nationalhockeyteams.dependencies.NetComponent;
import com.azvk.nationalhockeyteams.dependencies.NetModule;
import com.azvk.nationalhockeyteams.login.LoginComponent;
import com.azvk.nationalhockeyteams.login.LoginInterface;
import com.azvk.nationalhockeyteams.login.LoginModule;

public class App extends android.app.Application {

    private NetComponent netComponent;
    private LoginComponent loginComponent;

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

    public LoginComponent getLoginComponent(LoginInterface.View view){
        loginComponent = netComponent.plus(new LoginModule(view));
        return loginComponent;
    }

    public void releaseLoginComponent(){
        loginComponent = null;
    }

    public NetComponent getNetComponent(){
        return netComponent;
    }

}
