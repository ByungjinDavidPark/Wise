package com.davidpark.wise;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

import com.davidpark.wise.model.Question;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by o0sel on 18/01/2016.
 */


public class UploadQuestion extends AppCompatActivity {

    // view widgets
    private TextView tVTitle;
    private TextView tVContent;
    private EditText etTitle;
    private EditText etContent;
    private Button btnSubmit;

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
        tVTitle = (TextView) findViewById(R.id.uploadQuestionTitle);
        tVContent = (TextView) findViewById(R.id.uploadQuestionContent);
        etTitle = (EditText) findViewById(R.id.uploadQuestionTitleText);
        etContent = (EditText) findViewById(R.id.uploadQuestionContentText);
        btnSubmit = (Button) findViewById(R.id.uploadQuestionSubmit);



        //(int userID, int courseID, String title, int view, int vote, String content, String date)
        btnSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
//                    submissionTitle = etTitle.getText().toString();
//                    submissionContent = etContent.getText().toString();
//                    submissionDate = getSubmissionDateDate();
//                    uploadQuestion = new Question(userID, submissionTitle, view, vote, submissionContent, submissionDate);
                } catch (NullPointerException e) {
                }
            }
        });
    }

    public String getSubmissionDateDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String submissionDate = dateFormat.format(date).toString();
        return submissionDate;
    }
}
