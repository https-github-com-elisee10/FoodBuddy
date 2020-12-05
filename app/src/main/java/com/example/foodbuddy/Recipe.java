package com.example.foodbuddy;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    //declaring these objects to hold the title, path and overview from the movie api
    String posterPath, title, overView, backdropPath;


    //this is the constructor we passed the data from mainactivity class

    //if error it will throw exception

    //JSONobject

    //empty constructor created by Parcels library

    public Recipe(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overView = jsonObject.getString("overview");

    }

    public static List<Recipe> fromJsonArray(JSONArray recipeJsonArray) throws JSONException{

        List<Recipe> recipes = new ArrayList<>();

        for (int i=0; i< recipeJsonArray.length(); i++){
            recipes.add(new Recipe(recipeJsonArray.getJSONObject(i)));

        }

        return recipes;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverView() {
        return overView;
    }



}


