package com.itc.iblog.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by student on 9/13/17.
 */

public class PostRequestData {

    @SerializedName("data")
    private NotificationData data;
    @SerializedName("to")
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
