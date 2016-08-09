package com.azvk.nationalhockeyteams.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Team extends RealmObject{

    @PrimaryKey
    private String name;
    private String flag;
    private String head_coach;
    private String captain;
    private String[] header_pic;

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getHead_coach() {
        return head_coach;
    }

    public void setHead_coach(String head_coach) {
        this.head_coach = head_coach;
    }

    public String[] getHeader_pic() {
        return header_pic;
    }

    public void setHeader_pic(String[] header_pic) {
        this.header_pic = header_pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}