package com.example.foodbuddy.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.Headers;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.foodbuddy.R;
import com.example.foodbuddy.Recipe;
import com.example.foodbuddy.RecipeAdapter;
import com.example.foodbuddy.SearchItem;
import com.example.foodbuddy.SearchItemAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class searchFragment extends Fragment {

    //API RELATED

    List<SearchItem> searchItems;
    public String RECIPE_URL, search;
    public static final String TAG = "searchFragment";
    String[] cuisine = {
            "chicken",
            "icecream",
            "mutton",
            "gram",
            "mushroom",
            "peas",
            "carrot",
            "turkey",
            "beef",
            "goat",
            "asparagus"

    };
    Random random = new Random();
    int randomNumber = random.nextInt(cuisine.length);

    //API RELATED


    public searchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //API FETCH STARTS HERE

        //This rvMovies is from activity_main, represents the recycler view screen
        RecyclerView rvSearch = view.findViewById(R.id.rvSearch);

        //decraling movies arraylist
        searchItems = new ArrayList<>();

        //user searched item name is put in the search string


        RECIPE_URL = "https://api.spoonacular.com/recipes/search?query=" + cuisine[randomNumber] + "&number=20&apiKey=7e4bf9cab7ab42b1aa7d886374bf0b51";
        //creating async object
        AsyncHttpClient client = new AsyncHttpClient();
//
        //Create a constrcutor for movieAdapter class, and send context and movies

        final SearchItemAdapter searchitemAdapter = new SearchItemAdapter(getContext(), searchItems);
//
        //set the adapter in recycler view

        rvSearch.setAdapter(searchitemAdapter);

        //set a layout manager on the recycler view

        rvSearch.setLayoutManager(new LinearLayoutManager(getContext()));


        //fetching the API with client.get
        client.get(RECIPE_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {

                //logging onSuccess to make sure onSuccess method is invoked
                Log.d(TAG, "onSuccess");

                //Initiating a jsonObject of type json which will let us access the movie api, key and value
                JSONObject jsonObject = json.jsonObject;

                //To make sure we don't run into error, use try catch
                try {

                    //result is a json array that will fetch the results from movie api


                    JSONArray results = jsonObject.getJSONArray("results");

                    //logging result to make sure it parses the api
//                    Log.i(TAG, "Results" + results.toString());

                    //sending to Movie class the result object

                    searchItems.addAll(SearchItem.fromJsonArray(results));

                    //notify when its rendered
                    searchitemAdapter.notifyDataSetChanged();

                    //logging the size of the movies object, which is an array list

                    Log.i(TAG, "recipe size" + searchItems.size());
                } catch (JSONException e) {

                    //if error, log JSON exception
                    Log.e(TAG, "JSON exception");
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {

            }
        });

    }

    }