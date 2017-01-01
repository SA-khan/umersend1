package com.example.saad.habittrackingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by saad on 11/25/2016.
 */
public class sql extends SQLiteOpenHelper {
    public static final String db_name = "habit.db";
    public static final String table_name = "habit_table";
    public static final String col_0 = "ID";
    public static final String col_1 = "habit_title";
    public static final String col_2 = "habit_desc";
    public static final String col_4 = "habit_time";
    public static final String col_3 = "habit_date";
    public static final String col_5 = "habit_alarm";

    @Override
    public void onCreate(SQLiteDatabase db) {
         String query = "Create table "+table_name+" ("+col_0+" integer primary key autoincrement,"+col_1+" text,"+col_2+" text,"+col_3+" text,"+col_4+" text,"+col_5+" text )";
         db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String s = "drop table if exists "+table_name;
        db.execSQL(s);
        onCreate(db);

    }

    public sql(Context context) {
        super(context, db_name, null, 1);
    }
    public boolean insertData(String title,String desc,String date,String time,String alarm){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cn = new ContentValues();
        cn.put(col_1,title);
        cn.put(col_2,desc);
        cn.put(col_3,date);
        cn.put(col_4,time);
        cn.put(col_5,alarm);
        long result = db.insert(table_name,null,cn);
        if(result == -1){
            return false;
        }
        else
            return true;
    }
    public Cursor showData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+table_name,null);
        return res;

    }
}
