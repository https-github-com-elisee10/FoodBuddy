package com.example.foodbuddy.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.foodbuddy.R;
import com.example.foodbuddy.Recipe;
import com.example.foodbuddy.RecipeAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class trendingFragment extends Fragment {


    public static final String TAG = "TrendingFragment";
    private RecyclerView rvTrending;
    protected RecipeAdapter recipeAdapter;
    protected List<Recipe> allRecipe;

    public trendingFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trending, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTrending = view.findViewById(R.id.rvTrending);


        //Steps to use the recycler view:
        //0. create layout for one row in the list
        //1. create the adapter
        //2. create the data source
        allRecipe = new ArrayList<>();
        recipeAdapter = new RecipeAdapter(getContext(), allRecipe);
        //3. set the adapter on the recycler view
        rvTrending.setAdapter(recipeAdapter);
        //4 set the layout manager on the recycler view
        rvTrending.setLayoutManager(new LinearLayoutManager(getContext()));

    }
}
