package com.azvk.nationalhockeyteams.models;

import com.google.gson.annotations.Expose;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Roster extends RealmObject{

    @PrimaryKey
    @Expose
    private String name;
    @Expose
    private String team;
    @Expose
    private String position;
    @Expose
    private String birthdate;
    @Expose
    private String birthplace;
    @Expose
    private int number;
    @Expose
    private int weight;
    @Expose
    private int height;
    @Expose
    private String imageUrl;
    @Expose
    private String national_team;

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNational_team() {
        return national_team;
    }

    public void setNational_team(String national_team) {
        this.national_team = national_team;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
