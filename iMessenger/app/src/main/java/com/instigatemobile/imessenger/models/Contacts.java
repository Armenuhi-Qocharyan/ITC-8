package com.instigatemobile.imessenger.models;

public class Contacts {
    private String User;
    private String lastMessage;
    private int Image;


    public Contacts(String user, String lastMessage, int image) {
        this.User = user;
        this.lastMessage = lastMessage;
        this.Image = image;
    }

    public String getUser() {
        return User;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public int getImage() {
        return Image;
    }
}
