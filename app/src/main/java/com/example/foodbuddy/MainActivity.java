package com.example.foodbuddy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;
//    private Button btn_logout;
    private BottomNavigationView bottomNavigationView;
    final FragmentManager fragmentManager = getSupportFragmentManager();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



























        //API FETCH ENDS HERE

//        try {
//            get_json();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

//        btn_logout = findViewById(R.id.btnLogOut);
        bottomNavigationView = findViewById(R.id.bottom_navigation);



        // {Writing  a test message to  the database ===> Passed ✅}

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//        myRef.setValue("Hello, World!");



        //get google information
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);




        if (account!= null){

            //show the bottom navigation views


        }





        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.Jokes:
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
        bottomNavigationView.setSelectedItemId(R.id.Jokes);


//
//        btn_logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                FirebaseAuth.getInstance().signOut();
//
//                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
//                startActivity(i);
//                finish();
//            }
//        });
//    }

//
//    //open the json file from local
//    public void get_json() throws IOException, JSONException {
//        String json;
//
//
//            InputStream is = getAssets().open("recipe.json");
//            int size = is.available();
//            byte [] buffer = new byte[size];
//            is.read();
//            is.close();
//
//
//            json = new String(buffer, "UTF-8");
//            JSONArray jsonArray = new JSONArray(json);
//
//            for (int i=0; i< size; i++){
//                JSONObject obj = jsonArray.getJSONObject(i);
//
//
//
//            }
//
//        Toast.makeText(MainActivity.this,"json ", Toast.LENGTH_SHORT).show();
//    }




}
}