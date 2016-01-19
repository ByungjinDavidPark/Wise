package com.davidpark.wise;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnTouchListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.davidpark.wise.model.Comment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by o0sel on 18/01/2016.
 */
public class AddComment extends Activity {

    // view widgets
    private TextView tVQuestion;
    private TextView tVTag1;
    private TextView tVTag2;
    private EditText eTEdit;
    private Button btnSubmit;

    // view widget values
    private String questionText = "null";
    private String tagText1 = "BCS";
    private String tagText2 = "ISCG";

    // database values
    // Comment(int userID, int questionID, String content, String date)
    public Comment addComment;
    private Integer userID = 1;
    private Integer questionID = 1;
    private String submissionText = "null";
    private String submissionDate = "null";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_comment);
        // binding
        tVQuestion = (TextView) findViewById(R.id.addCommentQuestion);
        tVTag1 = (TextView) findViewById(R.id.addCommentTag1);
        tVTag2 = (TextView) findViewById(R.id.addCommentTag2);
        eTEdit = (EditText) findViewById(R.id.addCommentEdit);
        btnSubmit = (Button) findViewById(R.id.addCommentSubmit);
        // set view widget values from database
        tVQuestion.setText(questionText);
        tVTag1.setText(tagText1);
        tVTag2.setText(tagText2);

        btnSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //get userID
                //get QuestionID
                submissionText = getSubmission();
                submissionDate = getSubmissionDateDate();
                addComment = new Comment(userID, questionID, submissionText, submissionDate);
                finish();
            }
        });
    }

    public String getSubmission (){
        submissionText = eTEdit.getText().toString();
        return submissionText;
    }

    public String getSubmissionDateDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String submissionDate = dateFormat.format(date).toString();
        return submissionDate;
    }
}