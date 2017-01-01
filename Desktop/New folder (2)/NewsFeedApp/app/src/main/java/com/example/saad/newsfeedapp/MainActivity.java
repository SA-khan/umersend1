package com.example.saad.newsfeedapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText aboutNews;
    EditText categoryNews;
    Button searchNews;
    RatingBar ratingApp;
    String mAboutNews;
    String mCategoryNews;
    int mRatingApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aboutNews = (EditText)findViewById(R.id.aboutNews);
        categoryNews = (EditText)findViewById(R.id.categoryNews);
        searchNews = (Button)findViewById(R.id.searchNews);
        ratingApp = (RatingBar)findViewById(R.id.ratingBar);

        searchNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAboutNews = aboutNews.getText().toString();
                mCategoryNews = categoryNews.getText().toString();
                mRatingApp = ratingApp.getNumStars();

                //async myasync = new async();
                //myasync.execute();
                Intent myIntent = new Intent(getApplicationContext(),newsList.class);
                myIntent.putExtra("title", mAboutNews);
                myIntent.putExtra("category", mCategoryNews);
                myIntent.putExtra("rating", mRatingApp);
                startActivity(myIntent);

            }
        });
    }


}
