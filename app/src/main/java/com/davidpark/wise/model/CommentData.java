package com.davidpark.wise.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CommentData extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "main";

    // Users table name
    private static final String TABLE_CONTACTS = "comments";

    // Users Table Columns names
    private static final String COMMENT_ID = "comment_id";
    private static final String USER_ID = "user_id";
    private static final String QUESTION_ID = "question_id";
    private static final String CONTENT = "content";
    private static final String DATE = "date";

    public CommentData(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + COMMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + USER_ID + " INTEGER,"
                + QUESTION_ID + " INTEGER,"
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

    // Adding a new comment
    void addComment(Comment comment){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(QUESTION_ID, comment.getQuestionID()); //QuestionID
        values.put(USER_ID, comment.getUserID()); //UserID
        values.put(CONTENT, comment.getContent()); //Content
        values.put(DATE, comment.getDate());

        //Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }

}
