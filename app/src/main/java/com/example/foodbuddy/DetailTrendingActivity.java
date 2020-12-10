package com.example.foodbuddy;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Headers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DetailTrendingActivity extends AppCompatActivity {
    public static  Context context;
    TextView tvDetailTitle,tvInstructions;
    ImageView ivDetailImage;

    //url to get the information about the food with given id
    String id;

    final String TAG = "DetailTrendingActivity";

    TextView tvDetail;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_trending);


        context = getApplicationContext();

        tvDetailTitle = findViewById(R.id.tvDetailTitle);
        ivDetailImage = findViewById(R.id.ivDetailImage);
        tvInstructions = findViewById(R.id.tvInstructions);
//
//
//        get id sent from the recipe class
//        Recipe recipe = Parcels.unwrap(getIntent().getParcelableExtra("recipe"));
//
//        Log.i(TAG, "id is " + recipe.getId());

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
//        Log.i("showId", "id is " + id);
//        tvDetail.setText(id);
//        tvDetail.setText("https://api.spoonacular.com/recipes/" + id + "/information");


        //url to fetch after receiving the corrsponding id

        String URL_FETCH ="https://api.spoonacular.com/recipes/" + id + "/information?includeNutrition=false&apiKey=7e4bf9cab7ab42b1aa7d886374bf0b51";


//        API fetching start
//             creating async object
        AsyncHttpClient client = new AsyncHttpClient();
        JSONObject jsonObject = new JSONObject();


//fetching the API with client.get

        client.get(URL_FETCH, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {

                //logging onSuccess to make sure onSuccess method is invoked
                Log.i("DetailTrending", "onSuccess");

                //Initiating a jsonObject of type json which will let us access the movie api, key and value
                JSONObject jsonObject = json.jsonObject;

                //To make sure we don't run into error, use try catch

                try {
                    //result is a json array that will fetch the results from movie api

                    //get the instruction
                    String instructions = jsonObject.getString("instructions");
                    String title = jsonObject.getString("title");
                    String imageUrl = jsonObject.getString("image");
                    Log.i("imageUrl", "image"  + imageUrl);

//                    URL url = new URL(imageUrl);
//                    Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//                    ivDetailImage.setImageBitmap(bmp);

//                    Glide.with(this).load("http://i.imgur.com/DvpvklR.png").into(imageView);
                    tvDetailTitle.setText(title);
                    tvInstructions.setText(instructions);
//                    URL req = new URL(imageUrl);
//                    Bitmap mIcon_val = BitmapFactory.decodeStream(req.openConnection().getInputStream());
//                    ivDetailImage.setImageBitmap(mIcon_val);
//                    Glide.with(context).load(imageUrl).into(ivDetailImage);
                      Glide.with(DetailTrendingActivity.context).load(imageUrl).into(ivDetailImage);




                    //get the image
//                    String imageUrl =jsonObject.getString();


//                  Toast.makeText(getApplicationContext(), "instruction" + instruction, Toast.LENGTH_SHORT).show();

                    //logging result to make sure it parses the api
//                    ..Log.i(TAG, "Results" + instructions.toString());

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
//        API fetching start ends here


    }


    }
