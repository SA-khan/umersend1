package com.example.saad.habittrackingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import org.xml.sax.Parser;

import java.sql.Time;

public class add_Habit extends AppCompatActivity {

    EditText title;
    EditText desc;
    DatePicker date;
    TimePicker time;
    RadioGroup alarm;
    RadioButton alarmOff;
    RadioButton alarmOn;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__habit);
        //alarmOff.setChecked(true);

        title = (EditText)findViewById(R.id.title_add);
        desc = (EditText)findViewById(R.id.desc_add);
        date = (DatePicker)findViewById(R.id.date_btn);
        time = (TimePicker)findViewById(R.id.time_btn);
        alarm = (RadioGroup)findViewById(R.id.alarm);
        alarmOn = (RadioButton)findViewById(R.id.Alarm_On);
        alarmOff = (RadioButton)findViewById(R.id.Alarm_Off);
        save = (Button)findViewById(R.id.save_btn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String col_title = title.getText().toString();
                String col_desc = desc.getText().toString();
                String col_date = date.getDayOfMonth()+"/"+(date.getMonth()+1)+"/"+date.getYear();
                String col_time = time.getCurrentHour()+":"+time.getCurrentMinute();
                int col_alarm = alarm.getCheckedRadioButtonId();

                boolean col_alarmOn = alarmOn.isChecked();
                String a = "false";
                if(col_alarmOn){
                    a = "Alarm is ON";}
                else
                {
                    a = "Alarm is OFF";
                }

                boolean col_alarmOff = alarmOff.isChecked();

                sql myclass = new sql(getApplicationContext());
                boolean result = myclass.insertData(col_title,col_desc,col_date,col_time,a);
                if(result)
                Toast.makeText(getApplicationContext(),"Habit is saved",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"Error while saving data",Toast.LENGTH_LONG).show();

            }
        });
    }
}
