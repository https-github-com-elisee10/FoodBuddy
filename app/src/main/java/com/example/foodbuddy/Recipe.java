package com.example.foodbuddy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    //declaring these objects to hold the title, path and overview from the movie api
    String title, overView, image;

    //JSONobject
    public Recipe(JSONObject jsonObject) throws JSONException {
        image = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overView = jsonObject.getString("overview");
    }

    public static List<Recipe> fromJsonArray(JSONArray movieJsonArray) throws JSONException{

        List<Recipe> recipes = new ArrayList<>();

        for (int i=0; i< movieJsonArray.length(); i++){
            recipes.add(new Recipe(movieJsonArray.getJSONObject(i)));

        }

        return recipes;
    }

    public String getImage() {
        return image;
    }


    public String getTitle() {
        return title;
    }

    public String getOverView() {
        return overView;
    }



















}
