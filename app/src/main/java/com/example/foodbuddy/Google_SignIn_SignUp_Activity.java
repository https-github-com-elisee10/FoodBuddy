package com.example.foodbuddy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class Google_SignIn_SignUp_Activity extends AppCompatActivity {
    private SignInButton signInButton;
    private GoogleSignInClient mGoogleSignInClient;
    private final String TAG = "MainActivity";
    private FirebaseAuth mAuth;
    private Button btnSignOut;
    private final int RC_SIGN_IN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      FirebaseApp.initializeApp(this);




        //Setting up the logic for the button functionality
        signInButton = findViewById(R.id.sign_in_button);
        mAuth = FirebaseAuth.getInstance();


        //Configuring google sign in authentication through firebase
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        signInButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                signIn();
            }

        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGoogleSignInClient.signOut();
                Toast.makeText(Google_SignIn_SignUp_Activity.this, "You are Logged Out!", Toast.LENGTH_SHORT).show();
                btnSignOut.setVisibility(View.INVISIBLE);
            }
        });

    }

    private void signIn(){
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED){
            if (requestCode == RC_SIGN_IN){
                Task<GoogleSignInAccount> task  =  GoogleSignIn.getSignedInAccountFromIntent(data);
                handleSignInResult(task);
            }
        }
    }




    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {

        try {
            GoogleSignInAccount  acc = completedTask.getResult(ApiException.class);
            Toast.makeText(Google_SignIn_SignUp_Activity.this, "Signed Out Successfully", Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(acc);
            startActivity(new Intent(Google_SignIn_SignUp_Activity.this, MainActivity.class));
            finish();
        }

        catch( ApiException e)  {
            Toast.makeText(Google_SignIn_SignUp_Activity.this, "Signed In Failed!", Toast.LENGTH_SHORT).show();
            //FirebaseGoogleAuth(null);
        }
    }


    private void  FirebaseGoogleAuth(GoogleSignInAccount acc) {
//        AuthCredential authCredential = GoogleAuthProvider.getCredential(acc.getIdToken(), null);
        AuthCredential authCredential = GoogleAuthProvider.getCredential(acc.getIdToken(), null);
        mAuth.signInWithCredential(authCredential).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Google_SignIn_SignUp_Activity.this, "Successful!", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            Toast.makeText(Google_SignIn_SignUp_Activity.this, "Failed", Toast.LENGTH_SHORT).show();

                        }
                    }

                });
    }

    }

