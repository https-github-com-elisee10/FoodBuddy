package com.example.foodbuddy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText mEtEmail, mEtPassword, mEtRepeatPassword;
    private TextView mTvSignUp;
    private FirebaseAuth mFirebaseAuth;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        mEtEmail = findViewById(R.id.et_email_signup);
        mEtPassword = findViewById(R.id.et_pass_signup);
        mEtRepeatPassword = findViewById(R.id.et_pass_repeat_signup);
        mTvSignUp = findViewById(R.id.tv_signup_signup);

        mFirebaseAuth = FirebaseAuth.getInstance();




        mTvSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String email = mEtEmail.getText().toString();
                String password = mEtPassword.getText().toString();
                String RepeatPassword = mEtRepeatPassword.getText().toString();

                //Check if it is all empty or not

                if (!email.isEmpty() && !password.isEmpty() && ! RepeatPassword.isEmpty()) {
                    //got values in the sign up field
                    if (password.equals(RepeatPassword)){
                        //Password Matched
                        if (password.length()>=6) {

                            //Performing sign up now
                            mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()) {
                                    //user created!
                                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                                    finish();
                                }else {
                                    //Something went wrong
                                    Toast.makeText(SignUpActivity.this, "Check and TRy again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener(){
                            @Override
                            public void onFailure(@NonNull Exception e){
                                //Failed
                                Toast.makeText(SignUpActivity.this,"Error: " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                               }

                        })
                        .addOnCanceledListener(new OnCanceledListener() {
                            @Override
                            public void onCanceled() {
                                Toast.makeText(SignUpActivity.this, "Please fill all all the values", Toast.LENGTH_SHORT).show();

                            }
                        });


                        }else{
                            //Password length too short according to firebase recommendation
                            Toast.makeText(SignUpActivity.this,"Canceled, try again!", Toast.LENGTH_SHORT).show();
                        }





                    }else{
                        Toast.makeText(SignUpActivity.this,"Password do not match", Toast.LENGTH_SHORT).show();

                    }

                }else{
                    //No field can be left blank
                    Toast.makeText(SignUpActivity.this,"Please fill all all the values", Toast.LENGTH_SHORT).show();
                }
            }

        });


    }
}