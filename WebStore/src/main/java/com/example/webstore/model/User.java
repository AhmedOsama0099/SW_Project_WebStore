package com.example.webstore.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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

    /*public void setToken(String token) {
        this.token = token;
    }*/

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPw() {
        return pw;
    }

    /*public String getToken() {
        return token;
    }*/

    protected String userName;
    @NotBlank
    @Email
    protected String email;
    protected String pw;
    //protected String token;
    public User() {

    }

    public User(String userName, String email, String pw) {
        this.userName = userName;
        this.email = email;
        this.pw = pw;
    }

}
