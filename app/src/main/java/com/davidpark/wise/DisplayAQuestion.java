package com.davidpark.wise;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.davidpark.wise.model.Comment;
import com.davidpark.wise.model.CommentData;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by davidpark on 19/01/16.
 */
public class DisplayAQuestion extends AppCompatActivity {

    private TextView questionBody; // body of question
    private Button addComment; // comment
    private TextView tagDept;  //departmentTag
    private TextView tagCourse; // courseTag
    private TextView questionTitle; // title of question
    private int questionID;
    private List<Comment> commentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_question_body);

        init();

        CommentData dbConnectionComment = new CommentData(this);
        commentList = dbConnectionComment.getCommentByQuestionID(1);

        Log.d("commentList","" + questionID);

        Log.d("commentList","" + commentList.size());


        if (commentList.size() > 0)
        {
            Log.d("commentList","" + commentList.size());
            Log.d("commentList","" + commentList.get(0).getContent());
        }
    }

    /**
     *  This method is to initialise the components that will used in this activity.
     */
    public void init() {

        questionBody = (TextView) findViewById(R.id.textQuestionBody);
        tagDept = (TextView) findViewById(R.id.tagDept);
        tagCourse = (TextView)findViewById(R.id.tagCourse);
        addComment = (Button) findViewById(R.id.btnAddCommment);
        questionTitle = (TextView) findViewById(R.id.textTitle);


        addComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(DisplayAQuestion.this,AddComment.class);
                startActivity(intent4);
            }
        });

        Intent intent = getIntent();

        // set view's texts
        tagCourse.setText(intent.getStringExtra("courseTitle"));
        tagDept.setText(intent.getStringExtra("deptName"));
        questionBody.setText(intent.getStringExtra("content"));
        questionTitle.setText(intent.getStringExtra("questionTitle"));
        this.questionID = intent.getIntExtra("questionID",0);

    }
}
