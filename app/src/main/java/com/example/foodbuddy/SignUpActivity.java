package com.example.foodbuddy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class SignUpActivity extends AppCompatActivity {

    private EditText mEtuserName, mEtPassword, mEtuserEmail;
    private TextView mTvSignUp, tvLogmein;
    private FirebaseAuth mFirebaseAuth;

    //generate a random unique id for the user
    String id= UUID.randomUUID().toString();

    //setting up firebase
    FirebaseDatabase rootNode;
    DatabaseReference reference;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        tvLogmein = findViewById(R.id.tvLogmein);
        mEtuserName = findViewById(R.id.et_username_signup);
        mEtPassword = findViewById(R.id.et_pass_signup);
        mEtuserEmail = findViewById(R.id.et_user_email_signup);
        mTvSignUp = findViewById(R.id.tv_signup_signup);

        mFirebaseAuth = FirebaseAuth.getInstance();



        mTvSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                // Implementing firebase database

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");



                // end of database implementation


                //Get all the values from the text field
                String userName = mEtuserName.getText().toString();
                String password = mEtPassword.getText().toString();
                String userEmail = mEtuserEmail.getText().toString();




                //Check if it is all empty or not
                if (!userName.isEmpty() && !password.isEmpty() && !userEmail.isEmpty()) {
                        //Password Matched
                        if (password.length()>=6) {

                            //setup the field you want in the database
                            UserHelperClass helperClass =  new UserHelperClass(userName, password, userEmail);

                            // store the data in the database

                            reference.child(userName).setValue(helperClass);

                            startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                            finish();

                        }else{
                            //Password length too short according to firebase recommendation
                            Toast.makeText(SignUpActivity.this,"Too short, try again!", Toast.LENGTH_SHORT).show();
                        }


                }else{
                    //No field can be left blank
                    Toast.makeText(SignUpActivity.this,"Please fill all all the values", Toast.LENGTH_SHORT).show();
                }
            }

        });


        tvLogmein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });

    }
}