package com.azvk.nationalhockeyteams.models;


public class User {

    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.password = password;
        this.username = username;
    }
}
