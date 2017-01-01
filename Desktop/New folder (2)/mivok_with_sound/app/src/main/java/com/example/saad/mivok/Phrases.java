package com.example.saad.mivok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {

    public MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        final ArrayList<Words> words = new ArrayList<Words>(10);
        words.add(new Words("To kill two birds with one stone","Ak teer se do shikaar",R.mipmap.number_eight,R.raw.neendein));
        words.add(new Words("Let us see which way the wind blow ","Dekhty hain oo'nt kis karwat beethta hy",R.mipmap.number_eight,R.raw.neendein));
        words.add(new Words("Barking dogs sheldom bite","Jo garajty hain wo barasty nahin",R.mipmap.number_eight,R.raw.neendein));
        words.add(new Words("Jack of all trade master of none","Neem Hakeem khatra e jaan",R.mipmap.number_eight,R.raw.neendein));
        words.add(new Words("Try try again","kabhi haar na maano",R.mipmap.number_eight,R.raw.neendein));
        words.add(new Words("Tit for tat","Jesi karni wesi bharni",R.mipmap.number_eight,R.raw.neendein));
        words.add(new Words("Lie has no legs","Jhoot k pao ni hoty",R.mipmap.number_eight,R.raw.neendein));
        words.add(new Words("Something is better than nothing","kuch hona na hony se behtar hy",R.mipmap.number_eight,R.raw.neendein));
        words.add(new Words("A friend in need is a friend indeed","Dost wo hy jo waqt pe kaam aye",R.mipmap.number_eight,R.raw.neendein));
        words.add(new Words("Health is wealth","Tandrusti hazaar nemat hy",R.mipmap.number_eight,R.raw.neendein));

        WordAdopter Adopter = new WordAdopter(this,words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(Adopter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Words words2 = words.get(position);
                releaseMediaPlayer();
                mediaPlayer=MediaPlayer.create(Phrases.this, words2.getmAudioResourceId());
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
