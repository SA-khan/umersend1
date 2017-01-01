package com.example.saad.firebasechat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    CheckBox rememberMe;
    Button btn;
    ProgressDialog progressDialog;
    ProgressDialog progressDialog2;
    FirebaseAuth firebaseAuth;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText)findViewById(R.id.emailField);
        password = (EditText)findViewById(R.id.passwordField);
        rememberMe = (CheckBox)findViewById(R.id.rememberMe);
        btn = (Button) findViewById(R.id.btnSignUp);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        btnSignIn = (Button)findViewById(R.id.btnSignIn);

        SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        String emailremember = sharedPref.getString("email", null);
        final String passwordRemember = sharedPref.getString("password", null);
        if(emailremember != null && passwordRemember != null){
            rememberMe.isChecked();
        email.setText(emailremember);
        password.setText(passwordRemember);}

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rememberMe.isChecked() ==false){

                    SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("email",null );
                    editor.putString("password",null );
                    editor.commit();

                }
                if(rememberMe.isChecked()){
                    SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("email",email.getText().toString().trim() );
                    editor.putString("password",password.getText().toString().trim() );
                    editor.commit();
                }

                String textEmail = email.getText().toString().trim();
                String textPassword = password.getText().toString().trim();

                if(TextUtils.isEmpty(textEmail) || TextUtils.isEmpty(textPassword) ||(TextUtils.isEmpty(textEmail) && TextUtils.isEmpty(textPassword))){
                    Toast.makeText(getApplicationContext(), "Please provide complete Information !!!", Toast.LENGTH_LONG).show();
                }

                progressDialog.setMessage("Registering User..");
                progressDialog.show();
                firebaseAuth.createUserWithEmailAndPassword(textEmail,textPassword).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Registered Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog2 = new ProgressDialog(MainActivity.this);
                progressDialog2.setMessage("Login User..");
                progressDialog2.show();
                final String emailSignin = email.getText().toString().trim();
                final String passwordSignin = password.getText().toString().trim();

                firebaseAuth.signInWithEmailAndPassword(emailSignin,passwordSignin).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog2.dismiss();
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Login Successfully", Toast.LENGTH_SHORT).show();
                            Intent myintent = new Intent(MainActivity.this, chatActivity.class);
                            myintent.putExtra("email", emailSignin);
                            myintent.putExtra("password", passwordSignin);
                            startActivity(myintent);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}
