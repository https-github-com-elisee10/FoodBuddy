package com.example.foodbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText mEtEmail, mEtPassword;
    private TextView mTvLogin;
    private FirebaseAuth mFirebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mEtEmail = findViewById(R.id.et_email_signup);
        mEtPassword = findViewById(R.id.et_pass_signup);
        mTvLogin = findViewById(R.id.tv_signin_signin);


        mFirebaseAuth = FirebaseAuth.getInstance();

        mTvLogin.setOnClickListener(view -> {
            String email = mEtEmail.getText().toString();
            String pass = mEtPassword.getText().toString();

            if (email.isEmpty() && !pass.isEmpty()) {
                mFirebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        //Sign in complete
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    } else {
                        //Something went wrong
                        Toast.makeText(LoginActivity.this, "Please enter values", Toast.LENGTH_SHORT).show();
                    }

                })
                        .addOnFailureListener(e -> Toast.makeText(LoginActivity.this, "Error: " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show())

                        .addOnCanceledListener(() -> Toast.makeText(LoginActivity.this, "Cancelled!", Toast.LENGTH_SHORT).show());