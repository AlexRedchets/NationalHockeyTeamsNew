package com.azvk.nationalhockeyteams.dependencies;

import com.azvk.nationalhockeyteams.fragments.LoginFragment;

import dagger.Component;

@CustomScope
@Component(modules = ApiModule.class, dependencies = NetComponent.class)
public interface ApiComponent {

    void inject(LoginFragment loginFragment);

}
