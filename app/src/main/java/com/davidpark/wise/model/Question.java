package com.davidpark.wise.model;


public class Question {

    //private variables

    int questionID;
    int userID;
    String title;
    int view;
    int vote;
    String Content;
    String date;

    //empty constructor
    public Question(){

    }

    //constructor
    public Question(int questionID, int userID, String title, int view, int vote, String content, String date) {
        this.questionID = questionID;
        this.userID = userID;
        this.title = title;
        this.view = view;
        this.vote = vote;
        Content = content;
        this.date = date;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
