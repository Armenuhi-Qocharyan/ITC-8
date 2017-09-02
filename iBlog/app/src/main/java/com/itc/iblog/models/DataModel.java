package com.itc.iblog.models;

public class DataModel {

    private String userName;
    private String userSurname;
    private String postTime;
    private int userImage;
    private int postImage;
    private String postTitle;
    private String postText;
    private int likeCount;
    private int commentCount;

    public DataModel(String name, String userSurname, int userImage, int postImage,String postTime, String postTitle, String postText, int likeCount, int commentCount) {
        this.userName = name;
        this.userSurname = userSurname;
        this.userImage = userImage;
        this.postImage = postImage;
        this.postTitle = postTitle;
        this.postText = postText;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.postTime = postTime;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserSurname() {
        return this.userSurname;
    }

    public int getUserImage() {
        return this.userImage;
    }

    public int getPostImage() {
        return this.postImage;
    }

    public String getPostTitle() {
        return this.postTitle;
    }

    public String getPostText() {
        return this.postText;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }
    public String getPostTime() {
        return this.postTime;
    }
}