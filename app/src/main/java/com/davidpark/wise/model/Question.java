package com.davidpark.wise.model;


public class Question {

    //private variables

    int questionID;
    int userID;
    int courseID;
    String title;
    int view;
    int vote;
    String Content;
    String date;


    //empty constructor
    public Question(){

    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    //constructor
    public Question(int questionID, int userID, int courseID, String title, int view, int vote, String content, String date) {

        this.questionID = questionID;

        this.userID = userID;
        this.title = title;
        this.view = view;
        this.vote = vote;
        this.Content = content;
        this.date = date;
        this.courseID = courseID;
    }

    //constructor
    public Question(int userID, int courseID, String title, int view, int vote, String content, String date) {

        this.userID = userID;
        this.title = title;
        this.view = view;
        this.vote = vote;
        this.Content = content;
        this.date = date;
        this.courseID = courseID;
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

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}
