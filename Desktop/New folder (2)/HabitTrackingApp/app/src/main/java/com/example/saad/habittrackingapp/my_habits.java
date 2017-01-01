package com.example.saad.habittrackingapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class my_habits extends AppCompatActivity {

    TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_habits);
        view = (TextView)findViewById(R.id.values);
        sql myclass = new sql(getApplicationContext());
        Cursor res = myclass.showData();
        if(res.getCount()==0){
            view.setText(" No recent habit found.");
        }
        else {
            StringBuffer sb = new StringBuffer();
            while(res.moveToNext()){
                view.append(" ID:  "+res.getString(0)+"   Habit:"+res.getString(1));
                view.append("\n Desc:"+res.getString(2)+"   Date:"+res.getString(3));
                view.append("\nTime:"+res.getString(4)+"   Alarm:"+res.getString(5));
                view.append("\n\n\n");
            }

        }
    }
}
