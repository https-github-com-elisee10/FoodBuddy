package com.example.foodbuddy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SearchItem {

    //declaring these objects to hold the title, path and overview from the movie api
    String imagePath, title;
    int time, id;


    //this is the constructor we passed the data from mainactivity class

    //if error it will throw exception

    //JSONobject

    //empty constructor created by Parcels library

    public SearchItem(JSONObject jsonObject) throws JSONException {
        imagePath = jsonObject.getString("image");
        title = jsonObject.getString("title");
        time = jsonObject.getInt("readyInMinutes");
        id = jsonObject.getInt("id");

    }

    public static List<SearchItem> fromJsonArray(JSONArray searchItemJsonArray) throws JSONException{

        List<SearchItem> searchItems = new ArrayList<>();

        for (int i=0; i< searchItemJsonArray.length(); i++){
            searchItems.add(new SearchItem(searchItemJsonArray.getJSONObject(i)));

        }

        return searchItems;
    }

    public String getimagePath() {
        return "https://spoonacular.com/recipeImages/" + imagePath;
    }


    public String getTitle() {
        return title;
    }

    public int getTime() {
        return time;
    }

    public int getId(){ return id; }

}
