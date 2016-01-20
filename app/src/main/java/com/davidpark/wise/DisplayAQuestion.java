package com.davidpark.wise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by davidpark on 19/01/16.
 */
public class DisplayAQuestion extends AppCompatActivity {

    private TextView questionBody;
    private Button addComment;
    private TextView tagDept;
    private TextView tagCourse;
    private TextView questionTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_question_body);

        init();

    }

    public void init() {

        questionBody = (TextView) findViewById(R.id.textQuestionBody);
        tagDept = (TextView) findViewById(R.id.tagDept);
        tagCourse = (TextView)findViewById(R.id.tagCourse);
        addComment = (Button) findViewById(R.id.btnAddCommment);
        questionTitle = (TextView) findViewById(R.id.textCourseTitle);


        addComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(DisplayAQuestion.this,AddComment.class);
                startActivity(intent4);
            }
        });

        Intent intent = getIntent();

        tagCourse.setText(intent.getStringExtra("courseTitle"));
        tagDept.setText(intent.getStringExtra("deptName"));
        questionBody.setText(intent.getStringExtra("content"));
        questionTitle.setText(intent.getStringExtra("questionTitle"));

    }
}
