package com.example.saad.mivok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {

    public MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        String[] numbers = new String[10];
        final ArrayList<Words> words = new ArrayList<Words>(10);
        numbers[0] = "One";
        numbers[1] = "Two";
        numbers[2] = "Three";
        numbers[3] = "Four";
        numbers[4] = "Five";
        numbers[5] = "Six";
        numbers[6] = "Sever";
        numbers[7] = "Eight";
        numbers[8] = "Nine";
        numbers[9] = "Ten";
        words.add(new Words("Black","Kaa'la",R.mipmap.color_black,R.raw.kar_gai_chul));
        words.add(new Words("White","Sufaid",R.mipmap.color_white,R.raw.kar_gai_chul));
        words.add(new Words("Dusty Yellow","Peela",R.mipmap.color_dusty_yellow,R.raw.kar_gai_chul));
        words.add(new Words("Mustard Yelloe","Peela",R.mipmap.color_mustard_yellow,R.raw.kar_gai_chul));
        words.add(new Words("Red","Laal",R.mipmap.color_red,R.raw.kar_gai_chul));
        words.add(new Words("Brown","kathai",R.mipmap.color_brown,R.raw.kar_gai_chul));
        words.add(new Words("Gray","gray",R.mipmap.color_gray,R.raw.kar_gai_chul));
        words.add(new Words("Green","Haara",R.mipmap.color_green,R.raw.kar_gai_chul));
        words.add(new Words("Magenda","Magenda",R.mipmap.color_white,R.raw.kar_gai_chul));
        words.add(new Words("Purple","Purple",R.mipmap.color_mustard_yellow,R.raw.kar_gai_chul));

        //LinearLayout rootview = (LinearLayout)findViewById(R.id.rootView);
        //for(int i=0;i<words.size();i++){
        //TextView myview = new TextView(this);
        //myview.setText(words.get(i));
        //rootview.addView(myview);}

        WordAdopter Adopter = new WordAdopter(this,words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(Adopter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Words words2 = words.get(position);
                releaseMediaPlayer();
                MediaPlayer mediaPlayer = MediaPlayer.create(Colors.this, words2.getmAudioResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });

            }
        });
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}
