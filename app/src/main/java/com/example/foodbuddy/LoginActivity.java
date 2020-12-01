package com.example.foodbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private RelativeLayout mRLSignUp;
    private EditText mEtuserName, mEtPassword;
    private TextView mTvLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEtuserName = findViewById(R.id.et_username_signin);
        mEtPassword = findViewById(R.id.et_pass_signin);
        mTvLogin = findViewById(R.id.tv_signin_signin);


        mRLSignUp = findViewById(R.id.rl_signin_signin);
        mRLSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });



        //register onClick event for login

        mTvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validatePassword()|| !validateUsername()){

                    return;
                }

                else{

                    isUser();
                }

            }
        });


    }



    //validate the userName

    private Boolean validateUsername(){
        String userEnteredName = mEtuserName.getText().toString().trim();

        if (!userEnteredName.isEmpty() ){
            mEtuserName.setError("field cannot be empty");
            return true;
        }

        else{
            mEtuserName.setError("Username must be entered");
            return false;
        }

    }


    //validate the password

    private Boolean validatePassword(){
        String userEnteredPassword = mEtPassword.getText().toString().trim();

        if (!userEnteredPassword.isEmpty() ){
            return true;
        }

        else{
            mEtPassword.setError("Password must be entered");
            return false;
        }

    }





    //fetch the user information

    private void isUser(){

        final String userNameEntered = mEtuserName.getText().toString().trim();
        final String userPasswordEntered = mEtPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUser = reference.orderByChild("userName").equalTo(userNameEntered);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String passFromDatabase = dataSnapshot.child(userNameEntered).child("password").getValue(String.class);


                    if (passFromDatabase.equals(userPasswordEntered)) {
//

                        //fetch the userName
                        String usernameFromDatabase = dataSnapshot.child(userNameEntered).child("userName").getValue(String.class);

                        //fetch the email

                        String userEmailFromDatabase = dataSnapshot.child(userNameEntered).child("email").getValue(String.class);
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        i.putExtra("userName", usernameFromDatabase);
                        i.putExtra("password", passFromDatabase);

                        startActivity(i);

                    } else {
                        mEtPassword.setError("wrong pass");
                    }
                }
                    else{
                    mEtuserName.setError("user doesn't exist");
                    }



                }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }





}


