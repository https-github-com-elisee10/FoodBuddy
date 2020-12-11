package com.example.foodbuddy;

public class Profile {

    //declaring these objects to hold the title, path and overview from the movie api
    String profileImage, profileTitle, profileInstruction, profileId ;

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


    public Profile(String profileImage, String profileTitle, String profileInstruction, String profileId) {
        this.profileImage = profileImage;
        this.profileTitle = profileTitle;
        this.profileInstruction = profileInstruction;
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

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage){

    this.profileImage = profileImage;
    }


    public String getProfileTitle() {
        return profileTitle;
    }


    public void setProfileTitle(String profileTitle){

        this.profileTitle = profileTitle;
    }


    public String getprofileInstruction() {
        return profileInstruction;
    }


    public void setProfileInstruction(String profileInstruction){

        this.profileInstruction = profileInstruction;
    }


    public String getprofileId(){ return profileId; }


    public void setProfileId(String profileId){

        this.profileId = profileId;
    }


}


