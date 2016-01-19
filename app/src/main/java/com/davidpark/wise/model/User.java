package com.davidpark.wise.model;

public class User {

    //private variables
    String userName;
    String password;
    String email;

    //empty constructor
    public User(){

    }

    //constructor
    public User(String userName, String password, String email)
    {
        this.userName = userName;
        this.password = password;
        this.email = email;
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
