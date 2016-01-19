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

import java.util.Date;


/**
 * Created by o0sel on 18/01/2016.
 */
public class AddComment extends Activity {
    private TextView tVQuestion;
    private TextView tVTag1;
    private TextView tVTag2;
    private EditText eTEdit;
    private Button btnSubmit;
    private String questionText = "null";
    private String tagText1 = "BCS";
    private String tagText2 = "ISCG";
    private String submitionText = "null";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_comment);

        tVQuestion = (TextView) findViewById(R.id.addCommentQuestion);
        tVTag1 = (TextView) findViewById(R.id.addCommentTag1);
        tVTag2 = (TextView) findViewById(R.id.addCommentTag2);
        eTEdit = (EditText) findViewById(R.id.addCommentEdit);
        btnSubmit = (Button) findViewById(R.id.addCommentSubmit);
        tVQuestion.setText(questionText);
        tVTag1.setText(tagText1);
        tVTag2.setText(tagText2);
        btnSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //tVACQuestion.setText(tVACQuestionText);
            }
        });
    }
    public String getSubmition (){
        submitionText = eTEdit.getText().toString();
        return submitionText;

    }
}