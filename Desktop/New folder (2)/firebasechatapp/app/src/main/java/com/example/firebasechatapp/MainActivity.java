package com.example.firebasechatapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText userName;
    EditText password;
    FirebaseAuth mauth;
    FirebaseAuth.AuthStateListener mAuthListener;
    Button signin;
    CheckBox rememberMe;

    // Firebase instance variables
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        rememberMe = (CheckBox)findViewById(R.id.rememberMe);
        signin = (Button)findViewById(R.id.signin);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mauth = FirebaseAuth.getInstance();

               // mAuthListener = new FirebaseAuth.AuthStateListener() {
                 //   @Override
                  //  public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    //    FirebaseUser user = firebaseAuth.getCurrentUser();
                      //  if (user != null) {
                       //     Log.d("TAG", "onAuthStateChanged:signed_in:" + user.getUid());
                        //    startActivity(new Intent(getApplicationContext(),ActivitySecond.class));
                       // } else {
                            // User is signed out
                       //     Log.d("TAG", "onAuthStateChanged:signed_out");
                       // }
                        // ...
                   // }
               // };

                mFirebaseAuth = FirebaseAuth.getInstance();
                mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser == null) {
                    // Not signed in, launch the Sign In activity
                    password.setText("Access Denied!!");
                    finish();
                    return;
                } else {
                    userName.setText(mFirebaseUser.getDisplayName());
                    if (mFirebaseUser.getPhotoUrl() != null) {
                        //mPhotoUrl = mFirebaseUser.getPhotoUrl().toString();
                    }
                    startActivity(new Intent(getApplicationContext(),ActivitySecond.class));
                }

            }
        });

    }

    public void AuthF(){


    }
    public void signup(){
        mauth.createUserWithEmailAndPassword(userName.getText().toString(),password.getText().toString()).addOnCompleteListener((Activity) getApplicationContext(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Signup successfully",Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(),"Signup Unsuccessfully",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void signin(){
        mauth.signInWithEmailAndPassword(userName.getText().toString(),password.getText().toString()).addOnCompleteListener((Activity) getApplicationContext(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("TAG", "signInWithEmail:onComplete:" + task.isSuccessful());

                // If sign in fails, display a message to the user. If sign in succeeds
                // the auth state listener will be notified and logic to handle the
                // signed in user can be handled in the listener.
                if (!task.isSuccessful()) {
                    Log.w("TAG", "signInWithEmail:failed", task.getException());
                     Toast.makeText(getApplicationContext(), "auth_failed", Toast.LENGTH_SHORT).show();

            }

        }

    });
    }
    @Override
    public void onStart() {
         super.onStart();
        mauth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mauth.removeAuthStateListener(mAuthListener);
            }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sign_out_menu:
                mFirebaseAuth.signOut();
                Auth.GoogleSignInApi.signOut(mGoogleApiClient);
                userName.setText("ANONYMOUS");
                startActivity(new Intent(this, SignInActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
