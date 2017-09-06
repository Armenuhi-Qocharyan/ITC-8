package com.itc.iblog.models;

import android.net.Uri;

/**
 * Created by xacho on 01.09.17.
 */

public class UsersModel {
    public int age;
    public String userName;
    public String email;
    public String url;


    //required default constructor
    public UsersModel() {
    }

    public UsersModel(String userName, String url) {
        this.userName = userName;
        this.url = url;
    }

    public UsersModel(String userName, String email, int age, String image) {
        this.age = age;
        this.userName = userName;
        this.email = email;
        this.url = image;
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

}
