package com.itc.iblog.models;

public class UsersModel {
    public int age;
    public String userName;
    public String email;
    public String url;
    public int imageId;

    public UsersModel() {
    }

    public UsersModel(String userName, int imageId, String email) {
        this.userName = userName;
        this.imageId = imageId;
        this.email = email;
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

    public String getUrl() {
        return url;
    }

}
