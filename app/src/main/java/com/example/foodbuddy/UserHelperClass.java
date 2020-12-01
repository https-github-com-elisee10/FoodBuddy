package com.example.foodbuddy;

public class UserHelperClass {

    String userName, password, email;

    public UserHelperClass(){

    }

    public UserHelperClass(String userName, String password, String email) {

        this.password = password;
        this.userName = userName;
        this.email = email;

    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
