package com.itc.iblog.models;

/**
 * Created by xacho on 01.09.17.
 */

public class UserModel {
    public double age;
    public String userName;
    public String email;

    //required default constructor
    public UserModel() {
    }

    public UserModel(String userName, String email, double age) {
        this.age = age;
        this.userName = userName;
        this.email = email;
    }

    public double getAge() {
        return age;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }
}
