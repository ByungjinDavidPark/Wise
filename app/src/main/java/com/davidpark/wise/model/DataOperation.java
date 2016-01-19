package com.davidpark.wise.model;

import android.app.Activity;
import android.os.Bundle;

public class DataOperation extends Activity {

    private UserData userData = new UserData(this);
    private QuestionData questionData = new QuestionData(this);
    private CommentData commentData = new CommentData(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addUserData();
        addCommentData();
        addQuestionData();
    }

    public void addUserData(){

        userData.addUser(new User("Kevin", "123456", "kevin@gmail.com"));
        userData.addUser(new User("David", "123456", "david@gmail.com"));
        userData.addUser(new User("Kelvin", "123456", "kelvin@gmail.com"));
    }

    public void addQuestionData(){

        questionData.addQuestion(new Question(1, "What is ISCG6400?", 0, 0, "Can someone tell me?", "2016"));
        questionData.addQuestion(new Question(1, "How is ISCG6400?", 0, 0, "Is it good?", "2016"));
        questionData.addQuestion(new Question(2, "Who is enrolling ISCG7421?", 0, 0, "Is it good?", "2016"));
        questionData.addQuestion(new Question(3, "I love ISCG 6211", 0, 0, "I love it", "2016"));
    }

    public void addCommentData(){

        commentData.addComment(new Comment(1, 1, "Very good", "2016"));
        commentData.addComment(new Comment(2, 2, "Very good", "2016"));
    }
}