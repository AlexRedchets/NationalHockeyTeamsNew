package com.azvk.nationalhockeyteams.interfaces;

public interface UserInterface {

    interface LoginViewPresenter{
        void loginUser(String username, String password);
    }

    interface LoginPresenterView{
        void userAuthSuccess(boolean user);
    }

    interface RegistrationViewPresenter{
        void registerUser(String username, String password);
    }

    interface RegistrationPresenterView{
        void registerAuthComplete(int result);
    }
}
