package com.davidpark.wise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

import com.davidpark.wise.model.Question;
import com.davidpark.wise.model.QuestionData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;

/**
 * Created by o0sel on 18/01/2016.
 */


public class UploadQuestion extends Activity {

    // view widgets
    private TextView tVPath;
    private TextView tVTitle;
    private TextView tVContent;
    private EditText etTitle;
    private EditText etContent;
    private Button btnSubmit;

    //  view widget values
    private String dptPath = "null";
    private String crsPath = "null";
    private String fullPath;

    // database values
    // Question(int userID, String title, int view, int vote, String content, String date)
    public Question uploadQuestion;
    private Integer userID = 1;
    private String submissionTitle = "null";
    private Integer view = 1;
    private Integer vote = 1;
    private String submissionContent = "null";
    private String submissionDate;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_question);
        //binding
        tVPath = (TextView) findViewById(R.id.uploadQuestionPath);
        tVTitle = (TextView) findViewById(R.id.uploadQuestionTitle);
        tVContent = (TextView) findViewById(R.id.uploadQuestionContent);
        etTitle = (EditText) findViewById(R.id.uploadQuestionTitleText);
        etContent = (EditText) findViewById(R.id.uploadQuestionContentText);
        btnSubmit = (Button) findViewById(R.id.uploadQuestionSubmit);

        Intent intent = getIntent();
        dptPath = intent.getStringExtra("courseTitle");
        crsPath = intent.getStringExtra("deptName");



        // set view widget values
        fullPath = dptPath + " / " + crsPath;
        tVPath.setText(fullPath);



        btnSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    submissionTitle = etTitle.getText().toString();
                    submissionContent = etContent.getText().toString();
                    submissionDate = getSubmissionDate();
                    uploadQuestion = new Question(userID, submissionTitle, view, vote, submissionContent, submissionDate);
                } catch (NullPointerException e) {
                }
            }
        });
    }

    public String getSubmissionDate(){
        // define local date format
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        // define local date
        Date date = new Date();
        // convert date to string
        String submissionDate = dateFormat.format(date).toString();
        return submissionDate;
    }
}
