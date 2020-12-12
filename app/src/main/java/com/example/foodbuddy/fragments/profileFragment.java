package com.example.foodbuddy.fragments;

import android.annotation.SuppressLint;
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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
//
//import com.example.foodbuddy.Profile;
//import com.example.foodbuddy.ProfileAdapter;
import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.foodbuddy.R;
import com.example.foodbuddy.RecipeAdapter;
import com.example.foodbuddy.SearchItem;
import com.example.foodbuddy.SearchItemAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.Random;

public class profileFragment extends Fragment {
//
//     List<Profile> alldata;
//    ValueEventListener eventListener;

    public TextView tvJokes;
    Button btnJokes;

    String[] jokes = {
            "A Sandwich walks into a bar, the bartender says “Sorry, we don’t serve food here”",
            "Did you hear about the new restaurant on the moon? The food is great, but there’s just no atmosphere.",
            "I burned 2000 calories today, I left my food in the oven for too long.",
            "Dad I’m hungry’ … ‘Hi hungry I’m dad",
            "My sister bet me $15 that I couldn't build a car out of spaghetti. You should have seen the look on her face as I drove pasta.",
            "Q: What did the spaghetti say to the other spaghetti?" +
                    "A: Pasta la vista, baby!",
            "What did the grape do when he got stepped on? He let out a little wine.",
            "Child: Dad, make me a sandwich. Dad: Poof! You're a sandwich.",
            "Coffee has a tough time at my house, every morning it gets mugged.",
            "Why did the coffee file a police report? It got mugged.",
            "Hear about the new restaurant called Karma? There’s no menu: You get what you deserve.",
            "What does a clock do when it's hungry? It goes back four seconds!",
            "\"Dad, I'm hungry.\" Hello, Hungry. I'm Dad.",
            "Two muffins were sitting in an oven, and the first looks over to the second, and says, “man, it’s really hot in here”. The second looks over at the first with a surprised look, and answers, “WHOA, a talking muffin!”",
            "To the person who stole my anti-depressant pills: I hope you're happy now.",
            "Recent survey revealed 6 out of 7 dwarf's aren't happy.",
            "When Dad drops a pea off of his plate ‘oh dear I’ve pee’d on the table!",
            "The biggest knight at King Arthur's round table was Sir Cumference. He acquired his size from eating too much pi.",
            "Want to hear my pizza joke? Never mind, it's too cheesy.",
            "What did Romans use to cut pizza before the rolling cutter was invented? Lil Caesars",
            "What do you call a bee that lives in America? A USB.",
            "Americans can't switch from pounds to kilograms overnight. That would cause mass confusion.",
            "How many South Americans does it take to change a lightbulb? A Brazilian",
            "A police officer caught two kids playing with a firework and a car battery. He charged one and let the other one off.",
            "How many kids with ADD does it take to change a lightbulb? Let's go ride bikes!",
            "Vietnamese"
    };




    public profileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        tvJokes = view.findViewById(R.id.tvJokes);
        btnJokes = view.findViewById(R.id.btnJokes);


//
        btnJokes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int randomNumber = random.nextInt(jokes.length);

                tvJokes.setText(jokes[randomNumber]);


            }
        });

//        Log.i("jokes", jokes[randomNumber]);

    }
}