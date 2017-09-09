package com.itc.iblog.models;


import java.util.ArrayList;
import java.util.Date;

public class PostModel {
    private int userImage;
    private String userName;
    private String userEmail;
    private String postImagePath;
    private String postId;
    private String postTitle;
    private String postText;
    ArrayList<String> users;
    private Date postTime;
    private Integer likeCount;
    private Integer commentCount;
    private Integer favCount;

    public PostModel() {}

    public PostModel(String userName, String userEmail,int userImage, String postImagePath,
                     Date postTime,  String postId, String postTitle, String postText,
                     Integer likeCount, Integer favCount,Integer commentCount,
                     ArrayList<String> users) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.postImagePath = postImagePath;
        this.postTime = postTime;
        this.userImage = userImage;
        this.postId = postId;
        this.postTitle = postTitle;
        this.postText = postText;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.users = users;
        this.favCount = favCount;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public int getUserImage() {
        return this.userImage;
    }

    public String getPostId() {
        return this.postId;
    }

    public String getPostTitle() {
        return this.postTitle;
    }

    public String getPostText() {
        return this.postText;
    }

    public Integer getLikeCount() {
        return this.likeCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public Date getPostTime() {
        return this.postTime;
    }

    public ArrayList<String> getUsers() {
        return this.users;
    }


    public String getPostImagePath() {
        return postImagePath;
    }

    public Integer getFavCount() {
        return favCount;
    }
}