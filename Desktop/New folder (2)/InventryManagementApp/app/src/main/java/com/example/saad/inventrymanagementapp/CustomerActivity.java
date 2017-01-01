package com.example.saad.inventrymanagementapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomerActivity extends AppCompatActivity {

    sql_Connection sql = new sql_Connection(CustomerActivity.this);
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        ArrayList<Word> list = new ArrayList<Word>();
        tv=(TextView) findViewById(R.id.tv);

        Cursor res = sql.getData();
        if(res.getCount() == 0){
            Toast.makeText(getApplicationContext(),"No result found..",Toast.LENGTH_LONG).show();
            return;
        }
        while (res.moveToNext()){
            list.add(new Word(res.getInt(0),res.getString(1), res.getString(2),res.getDouble(6)));
        }
        WordAdaptor adapter = new WordAdaptor(this, list);
        ListView rootView = (ListView) findViewById(R.id.rootView);
        rootView.setAdapter(adapter);



    }
}
