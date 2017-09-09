package com.instigatemobile.imessenger.models;


public class User {
    public String name;
    public String email;
    public String avata;
    public Status status;
    public Message message;
    public int resource = 0;


    public User() {
        status = new Status();
        message = new Message();
        status.isOnline = false;
        status.timestamp = 0;
        message.setReceiver("0");
        message.setSender("0");
        message.setMessage("");
        message.setMessageTime(0);
    }

    public User(String username, int res) {
        name = username;
        resource = res;
    }

    public User(String name, String message, String image) {
        this.name = name;
        this.message = new Message();
        this.message.setMessage(message);
        this.avata = image;
    }
}
