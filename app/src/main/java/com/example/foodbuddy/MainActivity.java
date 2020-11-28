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

import com.example.foodbuddy.fragments.profileFragment;
import com.example.foodbuddy.fragments.searchFragment;
import com.example.foodbuddy.fragments.trendingFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;
    private Button btn_logout;
    private BottomNavigationView bottomNavigationView;
    final FragmentManager fragmentManager = getSupportFragmentManager();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_logout = findViewById(R.id.btnLogOut);
        bottomNavigationView = findViewById(R.id.bottom_navigation);




        //get google informations

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);




        if (account!= null){

            //show the bottom navigation views


        }





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



