package com.example.saad.mediaplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private float Right_Volume = 5;
    private float Left_Volume = 5;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mediaPlayer = MediaPlayer.create(this, R.raw.kgc);

        final TextView song_time = (TextView) findViewById(R.id.time1);

        TextView song_desc = (TextView) findViewById(R.id.song_desc);

        Button stop = (Button) findViewById(R.id.play);

        Button play = (Button) findViewById(R.id.play);

        Button pause = (Button) findViewById(R.id.pause);

        Button volume_up = (Button) findViewById(R.id.volume_up);

        Button volume_down = (Button) findViewById(R.id.volume_down);

        song_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                song_time.setText(mediaPlayer.getCurrentPosition()*1000);
            }
        });


        song_desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //mediaPlayer.getTrackInfo(R.raw.kgc);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mediaPlayer.reset();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer.stop();
            }
        });

        volume_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Right_Volume++;
                Left_Volume++;
                mediaPlayer.setVolume(Right_Volume, Left_Volume);
            }
        });

        volume_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Right_Volume--;
                Left_Volume--;
                mediaPlayer.setVolume(Right_Volume, Left_Volume);
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.saad.mediaplayer/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.saad.mediaplayer/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


}
