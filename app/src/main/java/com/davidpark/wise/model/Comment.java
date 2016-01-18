package com.davidpark.wise.model;


public class Comment {

    //private variables
    int commentID;
    int userID;
    int questionID;
    String content;
    String date;

    // constructor
    public Comment(int commentID, int userID, int questionID, String content, String date) {
        this.commentID = commentID;
        this.userID = userID;
        this.questionID = questionID;
        this.content = content;
        this.date = date;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
