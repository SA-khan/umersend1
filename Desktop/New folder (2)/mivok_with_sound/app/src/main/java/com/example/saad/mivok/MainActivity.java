package com.example.saad.mivok;

import android.app.NumbersActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openNumber(View view){
        Intent myintent = new Intent(this,NumbersActivity.class);
        startActivity(myintent);
    }
    public void openFamily(View view){
        Intent myintent = new Intent(this,FamilyMembers.class);
        startActivity(myintent);
    }
    public void openColor(View view){
        Intent myintent = new Intent(this,Colors.class);
        startActivity(myintent);
    }
    public void openPhrases(View view){
        Intent myintent = new Intent(this,Phrases.class);
        startActivity(myintent);
    }
}
