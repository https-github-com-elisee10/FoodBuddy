package com.example.foodbuddy;

public class UserHelperClass {

    String  email, password, RepeatPassword;

    public UserHelperClass(){

    }

    public UserHelperClass(String email, String password, String RepeatPassword) {
        this.email = email;
        this.password = password;
        this.RepeatPassword = RepeatPassword;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return RepeatPassword;
    }

    public void setRepeatPassword(String RepeatPassword) {
        this.RepeatPassword = RepeatPassword;
    }
}
