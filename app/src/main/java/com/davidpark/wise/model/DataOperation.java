package com.davidpark.wise.model;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class DataOperation extends Activity {

    private UserData userData = new UserData(this);
    private QuestionData questionData = new QuestionData(this);
    private CommentData commentData = new CommentData(this);

    private static final String USER_TABLE = "users";
    private static final String QUESTION_TABLE = "questions";
    private static final String COMMENT_TABLE = "comments";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //addUserData();
        addCommentData();
        addQuestionData();
        finish();
    }

    public void addUserData(){

        //UserName, Password, Email
        userData.addUser(new User("Kevin", "123456", "kevin@gmail.com"));
        userData.addUser(new User("David", "123456", "david@gmail.com"));
        userData.addUser(new User("Kelvin", "123456", "kelvin@gmail.com"));
    }

    public void addQuestionData(){

        //userID, CourseID, Title, View, Vote, Content, Date
        questionData.addQuestion(new Question(1, 1, "What is ISCG5420?", 0, 0, "Can someone tell me?", "2016"));
        questionData.addQuestion(new Question(1, 1, "How can I enrol ISCG 5420?", 0, 0, "I dont know how to do this, pls tell me.", "2016"));
        questionData.addQuestion(new Question(2, 1, "Can I study ISCG 5420 part time?", 0, 0, "I would like to study this course part time.", "2016"));
        questionData.addQuestion(new Question(3, 2, "Is ISCG 6420 a compulsory course?", 0, 0, "I want to know this.", "2016"));
        questionData.addQuestion(new Question(3, 2, "How will class be taught?", 0, 0, "Can someone tell me?", "2016"));
        questionData.addQuestion(new Question(3, 2, "What is ISCG 6420?", 0, 0, "Is it good?", "2016"));
        questionData.addQuestion(new Question(2, 3, "Who is enrolling ISCG 7420?", 0, 0, "Is it good?", "2016"));
        questionData.addQuestion(new Question(2, 3, "Is it similar to ISCG 7430?", 0, 0, "I am not sure about if I choose this course.", "2016"));
    }

    public void addCommentData(){

        //UserID, QuestionID, Content, Date
        commentData.addComment(new Comment(1, 1, "Very good", "2016"));
        commentData.addComment(new Comment(2, 2, "Very good", "2016"));
        commentData.addComment(new Comment(1, 2, "i do not know", "2016"));
        commentData.addComment(new Comment(3, 3, "Very good", "2016"));
        commentData.addComment(new Comment(1, 4, "Very good", "2016"));
        commentData.addComment(new Comment(2, 3, "Very good", "2016"));
    }
}
