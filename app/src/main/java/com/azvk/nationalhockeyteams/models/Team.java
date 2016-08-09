package com.azvk.nationalhockeyteams.models;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Team extends RealmObject{

    @PrimaryKey
    private String name;
    private String flag;
    private String head_coach;
    private String captain;
    private String header_pic_1;
    private String header_pic_2;
    private String header_pic_3;
    private String header_pic_4;
    private String header_pic_5;

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

    public String getHeader_pic_1() {
        return header_pic_1;
    }

    public void setHeader_pic_1(String header_pic_1) {
        this.header_pic_1 = header_pic_1;
    }

    public String getHeader_pic_2() {
        return header_pic_2;
    }

    public void setHeader_pic_2(String header_pic_2) {
        this.header_pic_2 = header_pic_2;
    }

    public String getHeader_pic_3() {
        return header_pic_3;
    }

    public void setHeader_pic_3(String header_pic_3) {
        this.header_pic_3 = header_pic_3;
    }

    public String getHeader_pic_4() {
        return header_pic_4;
    }

    public void setHeader_pic_4(String header_pic_4) {
        this.header_pic_4 = header_pic_4;
    }

    public String getHeader_pic_5() {
        return header_pic_5;
    }

    public void setHeader_pic_5(String header_pic_5) {
        this.header_pic_5 = header_pic_5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}