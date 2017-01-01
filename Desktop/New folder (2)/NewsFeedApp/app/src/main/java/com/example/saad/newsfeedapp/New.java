package com.example.saad.newsfeedapp;

/**
 * Created by saad on 12/19/2016.
 */
public class New {

    private String mTitle;
    private String mAuthor;
    private String mPublichedAt;

    public New(String title, String author, String publishedAt) {
        mTitle = title;
        mAuthor = author;
        mPublichedAt = publishedAt;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmAuthor() {
        return mAuthor;
    }
    public String getmPublichedAt() {
        return mPublichedAt;
    }
}
