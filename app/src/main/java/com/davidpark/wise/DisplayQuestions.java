package com.davidpark.wise;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.davidpark.wise.model.Question;
import com.davidpark.wise.model.QuestionData;

import java.util.List;

/**
 * Created by davidpark on 18/01/16.
 *
 * This class is to display recent questions based on
 * user's course selection in previous activity
 *
 * 4 recent question will be displayed and we will plan to have "More" button or
 *  scroll bar to expand questions
 */
public class DisplayQuestions extends AppCompatActivity {

    private View[] questionHolder; // to hold view objects
    private QuestionData questionData; // database connection class
    private List<Question> questionList; // list that holds recent questions
    private Button btnAskQ; // button to ask question
    private String courseTitle; // courseTitle for display purpose
    private int courseId; // courseId
    private TextView courseTitleText; // text view where course id is to be set.




    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.display_questions);

        // get data from previous activity
        Intent getData = getIntent();
        courseTitle = getData.getStringExtra("courseName");
        courseId =  getData.getIntExtra("courseID", 0);

        init();


    }

    /**
     *  This method is to initialise component for this class.
     */
    private void init()
    {

        btnAskQ = (Button) findViewById(R.id.btnAsk);
        btnAskQ.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                uploadQuestion();
                return false;
            }
        });

        // initialise text view and set course title to view
        courseTitleText = (TextView) findViewById(R.id.textCourseTitle);
        courseTitleText.setText(courseTitle);



        questionData = new QuestionData(this);
        questionList = questionData.getQuestionByCourseID(courseId);



        Log.d("Question list element ", "" + questionList.size());
        displayDBrows();

    }

    /**
     *  This method is to start UploadQuestion when user clicked Ask Question button
     */
    public void uploadQuestion()
    {
        Intent intent = new Intent(this,UploadQuestion.class);
        intent.putExtra("courseTitle",courseTitle);
        intent.putExtra("deptName", "BCS");
        startActivity(intent);

    }

    /**
     * This method is to create display questions that stored in database.
     *
     */
    public void displayDBrows()
    {

        // maximum number of question that display can have ( due to limitation of size)
        // in later, more button or scrolling will be added to display more items.
        int dbMaxDisplayCount = 4;

        if(questionList.size() < dbMaxDisplayCount)
        {
            dbMaxDisplayCount = questionList.size();
        }

        Log.d("dbMaxDisplayCount ", "" + dbMaxDisplayCount);


        questionHolder = new View[4];


        // get layoutInflater to inject view to parent layout
        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // for number of db rows, display each rows
        for (int dbRowCount = 0 ; dbRowCount < dbMaxDisplayCount; dbRowCount++)
        {
                View v = vi.inflate(R.layout.a_question, null);

                v.setId(dbRowCount);
                v.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        eventFired(view);
                        return false;
                    }
                });

                // fill in details dynamically
                TextView voteCount = (TextView) v.findViewById(R.id.voteCount);
                voteCount.setText("" + questionList.get(dbRowCount).getVote());

                TextView answerCount = (TextView) v.findViewById(R.id.answerCount);
                answerCount.setText("" + questionList.get(dbRowCount).getView());

                TextView viewCount = (TextView) v.findViewById(R.id.viewCount);
                viewCount.setText("" + questionList.get(dbRowCount).getView());

                TextView question = (TextView) v.findViewById(R.id.textQuestion);
                question.setText(questionList.get(dbRowCount).getTitle());

                TextView time = (TextView) v.findViewById(R.id.textAskedTime);
                time.setText("asked at " + questionList.get(dbRowCount).getDate());

                TextView id = (TextView) v.findViewById(R.id.textID);
                id.setText(""+ questionList.get(dbRowCount).getUserID());

                // insert into main view
                ViewGroup insertPoint = (ViewGroup) findViewById(R.id.displayquestions);
                insertPoint.addView(v,dbRowCount + 1);

                questionHolder[dbRowCount] = v;

            Log.d("dbRowCount ", "" + dbRowCount);


        }
    }

    @Override
    protected void onRestart() {
        // for refreshing activity
        super.onRestart();
    }


    /**
     * This method is litneing event and call startSubActivity
     * @param view - the question object is clicked
     */
    public void eventFired(View view)
    {
        Log.d("View" , "" + view.getId());
        int viewID = view.getId();
        startSubActivity(viewID);
    }

    /**
     *
     * This method is executed when user click one of the questions to start
     * sub-activity(Display A question)
     * @param viewID - question view object that user selected
     */
    public void startSubActivity(int viewID)
    {
        Intent intentForDisplayAQuestion = new Intent(this,DisplayAQuestion.class);
        intentForDisplayAQuestion.putExtra("courseID",questionList.get(viewID).getCourseID());
        intentForDisplayAQuestion.putExtra("questionTitle", questionList.get(viewID).getTitle());
        intentForDisplayAQuestion.putExtra("content", questionList.get(viewID).getContent());
        intentForDisplayAQuestion.putExtra("userID",questionList.get(viewID).getUserID());
        intentForDisplayAQuestion.putExtra("courseTitle",courseTitle);
        intentForDisplayAQuestion.putExtra("deptName","BCS");
        startActivity(intentForDisplayAQuestion);
    }


}

