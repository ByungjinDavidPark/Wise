package com.davidpark.wise;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.davidpark.wise.model.Question;
import com.davidpark.wise.model.QuestionData;

import java.util.List;

/**
 * Created by davidpark on 18/01/16.
 */
public class DisplayQuestions extends Activity {



    private View[] questionHolder;

    private QuestionData questionData;
    private List<Question> questionList;




    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.display_questions);

        init();
        displayDBrows();

    }

    private void init()
    {
        questionData = new QuestionData(this);
        questionList = questionData.getAllQuestions();
        Log.d("Question list element ", "" + questionList.size());
        displayDBrows();

    }

    public void displayDBrows()
    {

        // maximum number of question that display can have ( due to limitation of size)
        int dbMaxDisplayCount = 4;

        if(dbMaxDisplayCount > questionList.size())
        {
            dbMaxDisplayCount = questionList.size();
        }

        questionHolder = new View[5];

        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        for (int dbRowCount = 0 ; dbRowCount < dbMaxDisplayCount ; dbRowCount++)
        {


            if (questionList.get(dbRowCount) != null)
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

                // fill in any details dynamically here
                TextView voteCount = (TextView) v.findViewById(R.id.voteCount);
                voteCount.setText(questionList.get(dbRowCount).getVote());

                TextView answerCount = (TextView) v.findViewById(R.id.answerCount);
                answerCount.setText(questionList.get(dbRowCount).getView());

                TextView viewCount = (TextView) v.findViewById(R.id.viewCount);
                viewCount.setText(questionList.get(dbRowCount).getView());

                TextView question = (TextView) v.findViewById(R.id.textQuestion);
                question.setText(questionList.get(dbRowCount).getTitle());

                TextView time = (TextView) v.findViewById(R.id.textAskedTime);
                time.setText("asked at " + questionList.get(dbRowCount).getDate());

                TextView id = (TextView) v.findViewById(R.id.textID);
                id.setText(questionList.get(dbRowCount).getUserID());

                // insert into main view
                ViewGroup insertPoint = (ViewGroup) findViewById(R.id.displayquestions);
                insertPoint.addView(v, dbRowCount+1);

                questionHolder[dbRowCount] = v;

            }
        }
    }

    public void eventFired(View view)
    {
        Log.d("View" , "" + view.getId());
        int viewID = view.getId();
        switch (viewID)
        {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;

        }

    }


}

