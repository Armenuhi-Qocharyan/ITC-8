package com.instigatemobile.imessenger.Models;

/**
 * Created by vachagan on 9/4/17.
 */

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
