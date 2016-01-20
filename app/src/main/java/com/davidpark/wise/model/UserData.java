package com.davidpark.wise.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserData extends SQLiteOpenHelper{

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "main";

    // Users table name
    private static final String TABLE_CONTACTS = "users";

    // Users Table Columns names
    private static final String USER_ID = "user_id";
    private static final String USER_NAME = "user_name";
    private static final String USER_PASSWORD = "password";
    private static final String USER_EMAIL = "email";

    public UserData(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + USER_NAME + " TEXT,"
                + USER_PASSWORD + " TEXT,"
                + USER_EMAIL + " TEXT" + ")";
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

    /**
     * ALL CRUD Operations
     */

    // Getting a single user
    void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_NAME, user.getUserName());
        values.put(USER_PASSWORD, user.getPassword());
        values.put(USER_EMAIL, user.getEmail());

        //Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }

    // Getting a user name
    public String getUserName(int userID){
        String query = "SELECT user_name FROM " + TABLE_CONTACTS + " WHERE user_id = " + userID;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        String userName = cursor.getString(0);
        cursor.close();
        return userName;
    }

    // Drop Question Table
    public void dropTable(){

        String dropUserTableQuery = "DROP TABLE IF EXISTS" + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(dropUserTableQuery);
    }

}
