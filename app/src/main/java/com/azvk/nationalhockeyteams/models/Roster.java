package com.azvk.nationalhockeyteams.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Roster extends RealmObject{

    @PrimaryKey
    private String name;
    private String team;
    private String position;
    private String birthdate;
    private String birthplace;
    private int number;
    private int weight;
    private int height;
    private String imageUrl;
    private String national_team;

    public Roster(){}

    public Roster(String birthdate, String birthplace, int height, String imageUrl, String name, String national_team, int number, String position, String team, int weight) {
        this.birthdate = birthdate;
        this.birthplace = birthplace;
        this.height = height;
        this.imageUrl = imageUrl;
        this.name = name;
        this.national_team = national_team;
        this.number = number;
        this.position = position;
        this.team = team;
        this.weight = weight;
    }

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
