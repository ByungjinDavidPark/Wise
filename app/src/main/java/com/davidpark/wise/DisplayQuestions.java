package com.davidpark.wise;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by davidpark on 18/01/16.
 */
public class DisplayQuestions extends Activity{

    private int dbRowCount = 3;



   public void onCreate(Bundle savedInstanceState)
   {
       super.onCreate(savedInstanceState);

       setContentView(R.layout.display_questions);



       LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View v = vi.inflate(R.layout.a_question, null);

       // fill in any details dynamically here
       TextView voteCount = (TextView) v.findViewById(R.id.voteCount);
       voteCount.setText("3");

       TextView answerCount = (TextView) v.findViewById(R.id.answerCount);
       answerCount.setText("2");

       TextView viewCount = (TextView) v.findViewById(R.id.viewCount);
       viewCount.setText("10");

       TextView question = (TextView) v.findViewById(R.id.textQuestion);
       question.setText("ISCG 5420 Plase advise me some info!");

        // insert into main view
       ViewGroup insertPoint = (ViewGroup) findViewById(R.id.displayquestions);
       insertPoint.addView(v, 1, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));




   }
}
