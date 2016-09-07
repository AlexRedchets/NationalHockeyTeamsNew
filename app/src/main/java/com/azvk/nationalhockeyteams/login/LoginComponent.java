package com.azvk.nationalhockeyteams.login;

import dagger.Subcomponent;

@LoginScope
@Subcomponent(modules = LoginModule.class)
public interface LoginComponent {
    LoginFragment inject (LoginFragment fragment);
}
