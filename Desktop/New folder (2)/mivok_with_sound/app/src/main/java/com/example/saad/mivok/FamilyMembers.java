package com.example.saad.mivok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {

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
        words.add(new Words("Father","Abu",R.mipmap.family_father,R.raw.kar_gai_chul));
        words.add(new Words("Mother","Ami",R.mipmap.family_mother,R.raw.kar_gai_chul));
        words.add(new Words("Older Brother","Bhai",R.mipmap.family_older_brother,R.raw.kar_gai_chul));
        words.add(new Words("Older Sister","Behan",R.mipmap.family_older_sister,R.raw.kar_gai_chul));
        words.add(new Words("GrandFather","Dada",R.mipmap.family_grandfather,R.raw.kar_gai_chul));
        words.add(new Words("GrandMother","Dadi",R.mipmap.family_grandmother,R.raw.kar_gai_chul));
        words.add(new Words("Younger Brother","Chota Bhai",R.mipmap.family_younger_brother,R.raw.kar_gai_chul));
        words.add(new Words("Younger Sister","Choti Behan",R.mipmap.family_younger_sister,R.raw.kar_gai_chul));
        words.add(new Words("Son","Beta",R.mipmap.family_son,R.raw.kar_gai_chul));
        words.add(new Words("Daughter","Beti",R.mipmap.family_daughter,R.raw.kar_gai_chul));

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
                mediaPlayer = MediaPlayer.create(FamilyMembers.this, words2.getmAudioResourceId());
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
