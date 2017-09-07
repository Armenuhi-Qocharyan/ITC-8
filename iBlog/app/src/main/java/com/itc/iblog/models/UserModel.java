package com.itc.iblog.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xacho on 01.09.17.
 */

public class UserModel {
    public int age;
    public String userName;
    public String email;
    public String url;
    private String UID;
    //required default constructor

    public UserModel() {
    }

    public UserModel(String userName, String email, int age) {
        this.age = age;
        this.userName = userName;
        this.email = email;
        this.url = "images/avatar.png";
    }

    public UserModel(String userName, String email, int age, String url ) {
        this.age = age;
        this.userName = userName;
        this.email = email;
        this.url = url;
    }

    public int getAge() {
        return age;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getUrl() {return url; }

    public void setUID (String UID) { this.UID = UID; }

    public String getUID() { return UID; }
}
