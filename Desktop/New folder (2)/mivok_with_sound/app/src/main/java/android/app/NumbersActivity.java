package android.app;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.saad.mivok.R;
import com.example.saad.mivok.WordAdopter;
import com.example.saad.mivok.Words;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    public MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        final ArrayList<Words> words = new ArrayList<Words>(10);
        words.add(new Words("one","Ak",R.mipmap.number_one,R.raw.bulleya));
        words.add(new Words("Two","Doo",R.mipmap.number_two,R.raw.kar_gai_chul));
        words.add(new Words("Three","Teen",R.mipmap.number_three,R.raw.neendein));
        words.add(new Words("Four","Char",R.mipmap.number_four,R.raw.sau_tarha_k));
        words.add(new Words("Five","Paanch",R.mipmap.number_five,R.raw.tere_sang_yara));
        words.add(new Words("Six","Ch'y",R.mipmap.number_six,R.raw.bulleya));
        words.add(new Words("Seven","Saat",R.mipmap.number_seven,R.raw.kar_gai_chul));
        words.add(new Words("Eight","Aath",R.mipmap.number_eight,R.raw.neendein));
        words.add(new Words("Nine","No'o",R.mipmap.number_nine,R.raw.sau_tarha_k));
        words.add(new Words("Ten","Dus",R.mipmap.number_ten,R.raw.tere_sang_yara));

        WordAdopter Adopter = new WordAdopter(this,words);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(Adopter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Words words2 = words.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, words2.getmAudioResourceId());
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
