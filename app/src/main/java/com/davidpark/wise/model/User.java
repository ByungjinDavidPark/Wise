package com.davidpark.wise.model;

public class User {

    //private variables
    int userId;
    String userName;
    String password;
    String email;

    //empty constructor
    public User(){

    }

    //constructor
    public User(int id, String userName, String password, String email)
    {
        this.userId = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    //getting id
    public int getID(){
        return this.userId;
    }

    //setting id
    public void setID(int id){
        this.userId = id;
    }

    //getting userName
    public String getUserName(){
        return this.userName;
    }

    //setting userName
    public void setUserName(String userName){
        this.userName = userName;
    }

    //getting password
    public String getPassword(){
        return this.password;
    }

    //setting password
    public void setPassword(String password){
        this.password = password;
    }

    //getting email
    public String getEmail(){
        return this.email;
    }

    //setting email
    public void setEmail(String email){
        this.email = email;
    }





}
