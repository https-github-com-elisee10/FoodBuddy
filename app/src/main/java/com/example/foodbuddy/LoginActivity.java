package com.example.foodbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private RelativeLayout mRLSignUp;
    private EditText mEtEmail, mEtPassword;
    private TextView mTvLogin;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);



    mEtEmail = findViewById(R.id.et_email_signup);
    mEtPassword = findViewById(R.id.et_pass_signup);
    mTvLogin = findViewById(R.id.tv_signin_signin);


    mTvLogin.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String email = mEtEmail.getText().toString();
                                        String pass = mEtPassword.getText().toString();

                                        if (!email.isEmpty() && !pass.isEmpty()) {

                                            mFirebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                @Override
                                                public void onComplete(@NonNull Task<AuthResult> task) {
                                                    if (task.isSuccessful()) {
                                                        //Sign in complete
                                                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                                        finish();
                                                    } else {
                                                        //Something went wrong
                                                        Toast.makeText(LoginActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                                                    }

                                                }
                                            })
                                                    .addOnFailureListener(e -> Toast.makeText(LoginActivity.this, "Error: " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show())

                                                    .addOnCanceledListener(() -> Toast.makeText(LoginActivity.this, "Cancelled!", Toast.LENGTH_SHORT).show());

                                        } else {
                                            Toast.makeText(LoginActivity.this, "Please Enter values!", Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                });


            mRLSignUp = findViewById(R.id.rl_signin_signin);
            mRLSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                }
            });

        }
    }
