package com.itc.iblog.models;

/**
 * Created by student on 9/13/17.
 */

public class PostRequestData {
    private NotificationData data;
    private String to;

    public NotificationData getData() {
        return data;
    }

    public void setData(NotificationData data) {
        this.data = data;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
