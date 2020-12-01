package com.example.foodbuddy;

public class UserHelperClass {

    String userName, password;

    public UserHelperClass(){

    }

    public UserHelperClass(String userName, String password) {

        this.password = password;
        this.userName = userName;

    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }
}
