package com.example.foodbuddy;

public class Profile {

    //declaring these objects to hold the title, path and overview from the movie api
    private String userImage, userTitle, userInstruction, profileId ;

    //this is the constructor we passed the data from mainactivity class

    //if error it will throw exception

    //JSONobject

    //empty constructor created by Parcels library
//
//    public Profile(JSONObject jsonObject) throws JSONException {
//        profileImage = jsonObject.getString("userImage");
//        profileTitle = jsonObject.getString("userTitle");
//        profileInstruction = jsonObject.getString("userInstruction");
//        profileId = jsonObject.getString("profileId");
//
//    }

public Profile(){

}


    public Profile(String userImage, String userTitle, String userInstruction, String profileId) {
        this.userImage = userImage;
        this.userTitle = userTitle;
        this.userInstruction = userInstruction;
        this.profileId = profileId;
    }


//
//    public static List<Profile> fromJsonArray(JSONArray recipeJsonArray) throws JSONException{
//
//        List<Profile> profileRecipes = new ArrayList<>();
//
//        for (int i=0; i< recipeJsonArray.length(); i++){
//            profileRecipes.add(new Profile(recipeJsonArray.getJSONObject(i)));
//
//        }
//
//        return profileRecipes;
//    }

//    public void setProfileImage(String userImage){
//
//        this.userImage = userImage;
//    }



    public String getProfileImage() {
        return userImage;
    }



    public String getProfileTitle() {
        return userTitle;
    }


//    public void setProfileTitle(String userTitle){
//
//        this.userTitle = userTitle;
//    }


    public String getprofileInstruction() {
        return userInstruction;
    }


//    public void setProfileInstruction(String userInstruction){
//
//        this.userInstruction = userInstruction;
//    }


    public String getprofileId(){ return profileId; }

//
//    public void setProfileId(String profileId){
//
//        this.profileId = profileId;
//    }


}


