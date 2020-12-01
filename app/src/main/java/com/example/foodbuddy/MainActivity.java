package com.example.foodbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.Headers;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.foodbuddy.fragments.profileFragment;
import com.example.foodbuddy.fragments.searchFragment;
import com.example.foodbuddy.fragments.trendingFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;
    private Button btn_logout;
    private BottomNavigationView bottomNavigationView;
    final FragmentManager fragmentManager = getSupportFragmentManager();
    public static final String NOW_PLAYING_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
    public static final String TAG = "MainActivity";
    List<Recipe> recipes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvTrending = findViewById(R.id.rvTrending);
        recipes = new ArrayList<>();

        btn_logout = findViewById(R.id.btnLogOut);
        bottomNavigationView = findViewById(R.id.bottom_navigation);




        //get google informations

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);




        if (account!= null){

            //show the bottom navigation views


        }

        // fetching the api for the recipes

        //creating async object
        AsyncHttpClient client = new AsyncHttpClient();

        //Create an adapter
        final RecipeAdapter recipeAdapter = new RecipeAdapter(this, recipes);

        //set the adapter in recycler view

        rvTrending.setAdapter(recipeAdapter);

        //set a layout manager on the recycler view

        rvTrending.setLayoutManager(new LinearLayoutManager(this));







        //fetching the API with client.get
        client.get(NOW_PLAYING_URL, new JsonHttpResponseHandler() {
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
                    Log.i(TAG, "Results" + results.toString());

                    //sending to Movie class the result object

                    recipes.addAll(Recipe.fromJsonArray(results));

                    //notify when its rendered
                    recipeAdapter.notifyDataSetChanged();

                    //logging the size of the movies object, which is an array list

                    Log.i(TAG, "movie size" + recipes.size());
                }

                catch (JSONException e){

                    //if error, log JSON exception
                    Log.e(TAG, "JSON exception");
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {

            }
        });







        // navigation buttons from here and below


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.profile:
                        fragment = new profileFragment();
                        break;
                    case R.id.trending:
                        fragment = new trendingFragment();
                        break;
                    case R.id.search:
                        fragment = new searchFragment();
                        break;
                    default:
                        fragment = new profileFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });

        //set the profile to be default selection
        bottomNavigationView.setSelectedItemId(R.id.profile);


//
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();

                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}



