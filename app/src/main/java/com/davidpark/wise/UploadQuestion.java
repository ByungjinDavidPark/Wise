package com.davidpark.wise;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Created by o0sel on 18/01/2016.
 */

public class UploadQuestion extends Activity {
    private TextView tVTitle;
    private TextView tVContent;
    private EditText etTitle;
    private EditText etContent;
    private Button btnSubmit;
    private String submitionTitle = "null";
    private String submitionContent = "null";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_question);
        tVTitle = (TextView) findViewById(R.id.uploadQuestionTitle);
        tVContent = (TextView) findViewById(R.id.uploadQuestionContent);
        etTitle = (EditText) findViewById(R.id.uploadQuestionTitleText);
        etContent = (EditText) findViewById(R.id.uploadQuestionContentText);
        btnSubmit = (Button) findViewById(R.id.uploadQuestionSubmit);


        btnSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    submitionTitle = etTitle.getText().toString();
                    submitionContent = etContent.getText().toString();
                } catch (NullPointerException e) {

                }
            }
        });
    }
}
