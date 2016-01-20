package com.davidpark.wise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


/**
 * This class is main activity where user can choose department and course to see
 * questions on their selection.
 *
 */

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // dropdown menu for department, course
    // contents is hard-corded for development purpose but will get from database
    private Spinner deptSelection;
    private static final String[]deps = {"Please Select Department","BCS","BA"};
    private Spinner courseSelection;
    private static final String[]courses = {"Please Select Course", "ISCG5420" ,"ISCG6420", "ISCG7420"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        // initialize spinners
        init();

    }

    /**
     *  This method is to initialise required components for this activity.
     */
    private void init()
    {

        // init spinner
        deptSelection = (Spinner)findViewById(R.id.deptSelection);
        ArrayAdapter<String>adapter1 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,deps);

        // set content to spinner
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        deptSelection.setAdapter(adapter1);

        courseSelection = (Spinner)findViewById(R.id.courseSelection);
        ArrayAdapter<String>adapter2 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,courses);


        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courseSelection.setAdapter(adapter2);

        courseSelection.setOnItemSelectedListener(this);
    }

    /**
     * This method is to handle the course choice of user and start sub-activity based on
     * their selection
     *
     * @param parent content of view
     * @param v  - view
     * @param position - position that user selected item
     * @param id - id of item
     */
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        Intent intent = new Intent(this,DisplayQuestions.class);

        switch (position) {
            case 0:
                // do nothing
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                intent.putExtra("courseName",courseSelection.getItemAtPosition(position).toString());
                startActivity(intent);
                break;
            case 2:
                // Whatever you want to happen when the third item gets selected
                intent.putExtra("courseName",courseSelection.getItemAtPosition(position).toString());
                startActivity(intent);
                break;
            case 3:
                intent.putExtra("courseName",courseSelection.getItemAtPosition(position).toString());
                startActivity(intent);
                break;


        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
