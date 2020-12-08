package com.example.foodbuddy;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Headers;

import android.os.Bundle;
import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

public class DetailTrendingActivity extends AppCompatActivity {

    //url to get the information about the food with given id

    private static final String RECIPE_URL_TRENDING = "https://api.spoonacular.com/recipes/%d/information";
    final String TAG = "DetailTrendingActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_trending);
//
//
////        get id sent from the recipe class
//        Recipe recipe = Parcels.unwrap(getIntent().getParcelableExtra("recipe"));
//
//        Log.i(TAG, "id is " + recipe.getId());


        //API fetching start
            // creating async object
//        AsyncHttpClient client = new AsyncHttpClient();
            //JSONObject jsonObject = new JSONObject();


//fetching the API with client.get
//        client.get(String.format(RECIPE_URL_TRENDING, Integer.parseInt(recipe.getId())), new JsonHttpResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, Headers headers, JSON json) {
//
//                //logging onSuccess to make sure onSuccess method is invoked
//                Log.d(TAG, "onSuccess");
//
//                //Initiating a jsonObject of type json which will let us access the movie api, key and value
//                JSONObject jsonObject = json.jsonObject;
//
//                //To make sure we don't run into error, use try catch
//                try {
//
//                    //result is a json array that will fetch the results from movie api
//
//
//                    JSONArray ingredients = jsonObject.getJSONArray("extendedIngredients");
//
//                    //logging result to make sure it parses the api
//                    Log.i(TAG, "Results" + ingredients.toString());
//
//
//                }
//
//                catch (JSONException e){
//
//                    //if error, log JSON exception
//                    Log.e(TAG, "JSON exception");
//                }
//            }
//
//            @Override
//            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
//
//            }
//        });
        //API fetching start ends here


    }


    }
