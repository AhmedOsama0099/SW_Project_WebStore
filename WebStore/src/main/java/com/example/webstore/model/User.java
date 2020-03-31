package com.example.webstore.model;

public class User {
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPw() {
        return pw;
    }

    protected String userName;
    protected String email;
    protected String pw;

    public User() {

    }

    public User(String userName, String email, String pw) {
        this.userName = userName;
        this.email = email;
        this.pw = pw;
    }

}
