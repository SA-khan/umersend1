package com.example.saad.firebasechat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class chatActivity extends AppCompatActivity {

    MultiAutoCompleteTextView mtv;
    GridView rootView;
    EditText text1;
    Button btnSend;
    Firebase mRef;
    String result;
    int childName = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Firebase.setAndroidContext(chatActivity.this);
        mRef = new Firebase("https://fir-chat-3ef7e.firebaseio.com/");

        mtv = (MultiAutoCompleteTextView)findViewById(R.id.mtv);
        //rootView = (GridView)findViewById(R.id.rootView);
        text1 = (EditText)findViewById(R.id.text1);
        btnSend = (Button)findViewById(R.id.btnSend);
        Intent myintent = getIntent();
        final String e = myintent.getStringExtra("email");
        String p = myintent.getStringExtra("password");

        //ArrayList<Word> list = new ArrayList<Word>();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textModified = text1.getText().toString().trim();
               // mRef.push().setValue(textModified);
                Firebase child = mRef.child(e+childName++);
                child.setValue(textModified);
            }
        });

        mRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                mtv.append(value);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        //list.add(new Word(result));

        //WordAdapter adapter = new WordAdapter(this, list);
        //GridView rootView = (GridView) findViewById(R.id.rootView);
       // rootView.setAdapter(adapter);
    }
}
