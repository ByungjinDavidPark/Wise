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

        addUserData();
        addCommentData();
        addQuestionData();
        finish();
    }

    public void addUserData(){

        userData.addUser(new User("Kevin", "123456", "kevin@gmail.com"));
        userData.addUser(new User("David", "123456", "david@gmail.com"));
        userData.addUser(new User("Kelvin", "123456", "kelvin@gmail.com"));
    }

    public void addQuestionData(){

        //userID, CourseID, Title, View, Vote, Content, Date
        questionData.addQuestion(new Question(1, 1, "What is ISCG5420?", 0, 0, "Can someone tell me?", "2016"));
        questionData.addQuestion(new Question(1, 1, "How is ISCG5420?", 0, 0, "Is it good?", "2016"));
        questionData.addQuestion(new Question(2, 1, "Who is enrolling ISCG6421?", 0, 0, "Is it good?", "2016"));
        questionData.addQuestion(new Question(3, 2, "I love ISCG 6211", 0, 0, "I love it", "2016"));
        questionData.addQuestion(new Question(3, 2, "What is ISCG5400?", 0, 0, "Can someone tell me?", "2016"));
        questionData.addQuestion(new Question(3, 3, "How is ISCG5400?", 0, 0, "Is it good?", "2016"));
        questionData.addQuestion(new Question(2, 1, "Who is enrolling ISCG6421?", 0, 0, "Is it good?", "2016"));
        questionData.addQuestion(new Question(2, 2, "I love ISCG 6211", 0, 0, "I love it", "2016"));
    }

    public void addCommentData(){

        commentData.addComment(new Comment(1, 1, "Very good", "2016"));
        commentData.addComment(new Comment(2, 2, "Very good", "2016"));
        commentData.addComment(new Comment(1, 2, "Very good", "2016"));
        commentData.addComment(new Comment(3, 3, "Very good", "2016"));
        commentData.addComment(new Comment(1, 4, "Very good", "2016"));
        commentData.addComment(new Comment(2, 3, "Very good", "2016"));
    }
}
