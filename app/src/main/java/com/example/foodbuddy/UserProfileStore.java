package com.example.foodbuddy;

public class UserProfileStore {


String userId, userTitle, userImage, userInstruction;

public UserProfileStore(){

        }

public UserProfileStore(String userId, String userTitle, String userImage, String userInstruction) {

        this.userId = userId;
        this.userTitle = userTitle;
        this.userImage =userImage;
        this.userInstruction = userInstruction;

        }



public String getprofileId() {
        return userId;
        }

public void setprofileId(String userId) {
        this.userId = userId;
        }


public String getUserTitle() {
        return userTitle;
        }

public void setUserName(String userTitle) {
        this.userTitle = userTitle;
        }

public String getuserImage() {
        return userImage;
        }

public void setuserImage(String userImage) {
        this.userImage = userImage;
        }

        public String getUserInstruction() {
                return userInstruction;
        }

        public void setUserInstruction(String userInstruction) {
                this.userInstruction = userInstruction;
        }



}
