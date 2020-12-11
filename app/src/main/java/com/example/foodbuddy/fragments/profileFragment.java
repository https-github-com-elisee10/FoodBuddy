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
import android.widget.LinearLayout;

import com.example.foodbuddy.Profile;
import com.example.foodbuddy.ProfileAdapter;
import com.example.foodbuddy.R;
import com.example.foodbuddy.SearchItem;
import com.example.foodbuddy.SearchItemAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class profileFragment extends Fragment {
    RecyclerView rvProfile;
    List<Profile> profileRecipe;


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

        ValueEventListener eventListener;
        profileRecipe = new ArrayList<>();


        rvProfile = view.findViewById(R.id.rvProfile);

        final ProfileAdapter profileAdapter = new ProfileAdapter(getContext(), profileRecipe);

        rvProfile.setLayoutManager(new LinearLayoutManager(getContext()));


        //This is the database portion of the code to query all the stored data

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("posts");
//        Query getId = reference.orderByChild("id");

        eventListener = reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                //clear anything if item stored in the array list
                profileRecipe.clear();

                for (DataSnapshot itemSnapshot : snapshot.getChildren()) {

//                    Log.i("data" , "is "+  itemSnapshot);



                    Profile profileData = itemSnapshot.getValue(Profile.class);
////
//
//                    assert profileData != null;
//                    String profileImage = profileData.getProfileImage();
//                    String profileTitle = profileData.getProfileTitle();
//                    String profileInstruction = profileData.getprofileInstruction();
//                    String profileId = profileData.getprofileId();


//                    Profile items = new Profile(profileImage, profileTitle, profileInstruction, profileId);


//                    Log.i("data" , "is "+  profileData.getprofileId());

//                   add all the data to profileRecipe, profileData contains individual id and we can parse it using the getter methods

                    profileRecipe.add(profileData);



                }



                profileAdapter.notifyDataSetChanged();

//                Log.i("data" , "is "+  profileRecipe);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });

}
}