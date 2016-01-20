package com.davidpark.wise.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class QuestionData extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "main";

    // Users table name
    private static final String TABLE_CONTACTS = "questions";

    // Users Table Columns names
    private static final String QUESTION_ID = "question_id";
    private static final String USER_ID = "user_id";
    private static final String VIEW = "view";
    private static final String VOTE = "vote";
    private static final String TITLE = "title";
    private static final String CONTENT = "content";
    private static final String DATE = "date";
    private static final String COURSE_ID = "course_id";

    public QuestionData(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + QUESTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + USER_ID + " INTEGER,"
                + COURSE_ID + " INTEGER,"
                + VIEW + " INTEGER,"
                + VOTE + " INTEGER,"
                + TITLE + " TEXT,"
                + CONTENT + " TEXT,"
                + DATE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    // Adding a new question
    public void addQuestion(Question question){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TITLE, question.getTitle()); // Question Title
        values.put(CONTENT, question.getContent()); // Content
        values.put(USER_ID, question.getUserID()); // User ID
        values.put(VIEW, question.getView()); // View
        values.put(VOTE, question.getVote()); // Vote
        values.put(DATE, question.getDate()); // Date
        values.put(COURSE_ID, question.getCourseID());

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection

    }

    // Getting Question by courseID
    public List<Question> getQuestionByCourseID(int courseID){
        List<Question> questionList = new ArrayList<Question>();
        String query = "Select * FROM " + TABLE_CONTACTS + " WHERE course_id = " + courseID;
        
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // Looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setUserID(Integer.parseInt(cursor.getString(1)));
                question.setCourseID(Integer.parseInt(cursor.getString(2)));
                question.setView(Integer.parseInt(cursor.getString(3)));
                question.setVote(Integer.parseInt(cursor.getString(4)));
                question.setTitle(cursor.getString(5));
                question.setContent(cursor.getString(6));
                question.setDate(cursor.getString(7));
                questionList.add(question);
            } while (cursor.moveToNext());
        }

        return questionList;
    }

    // Getting All Questions
    public List<Question> getAllQuestions(){
        List<Question> questionList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setUserID(Integer.parseInt(cursor.getString(1)));
                question.setCourseID(Integer.parseInt(cursor.getString(2)));
                question.setView(Integer.parseInt(cursor.getString(3)));
                question.setVote(Integer.parseInt(cursor.getString(4)));
                question.setTitle(cursor.getString(5));
                question.setContent(cursor.getString(6));
                question.setDate(cursor.getString(7));
                questionList.add(question);
            } while (cursor.moveToNext());
        }

        return questionList;
    }

    // Getting Vote
    public int getVote(int questionID){
        String query = "SELECT vote FROM " + TABLE_CONTACTS + "WHERE question_id = " + questionID;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        int vote = cursor.getInt(0);
        cursor.close();
        return vote;
    }

    // Getting View
    public int getView(int questionID){
        String query = "SELECT view FROM " + TABLE_CONTACTS + "WHERE question_id = " + questionID;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        int view = cursor.getInt(0);
        cursor.close();
        return view;
    }


}
