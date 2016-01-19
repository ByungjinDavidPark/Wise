package com.davidpark.wise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.davidpark.wise.model.DataOperation;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner deptSelection;
    private static final String[]depts = {"BCS","Test"};

    private Spinner courseSelection;
    private static final String[]courses = {"ISCG 5420", "ISCG 6420", "ISCG 7420"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        deptSelection = (Spinner)findViewById(R.id.deptSelection);
        ArrayAdapter<String>adapter1 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,depts);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        deptSelection.setAdapter(adapter1);

        courseSelection = (Spinner)findViewById(R.id.courseSelection);
        ArrayAdapter<String>adapter2 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,courses);


        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courseSelection.setAdapter(adapter2);


        courseSelection.setOnItemSelectedListener(this);

    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected


                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                getDatabaseInfo();
                Intent intent = new Intent(this,DisplayQuestions.class);
                intent.putExtra("Test","CHeck");
                startActivity(intent);
                break;

        }
    }

    private void getDatabaseInfo() {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
