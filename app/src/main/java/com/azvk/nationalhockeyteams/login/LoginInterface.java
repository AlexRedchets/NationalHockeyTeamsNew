package com.azvk.nationalhockeyteams.login;

public interface LoginInterface {

    interface View{

    }

    interface Presenter{
        void loginUser(String username, String password);
    }
}
