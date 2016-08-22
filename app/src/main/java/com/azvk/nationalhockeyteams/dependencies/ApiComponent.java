package com.azvk.nationalhockeyteams.dependencies;

import dagger.Component;

@CustomScope
@Component(modules = ApiModule.class)
public interface ApiComponent {
}
