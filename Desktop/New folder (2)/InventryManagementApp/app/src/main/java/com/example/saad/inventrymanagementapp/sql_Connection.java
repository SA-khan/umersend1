package com.example.saad.inventrymanagementapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by saad on 12/20/2016.
 */
public class sql_Connection extends SQLiteOpenHelper {
    public static final String dbName = "inventory.db";
    public static final String tableName = "myTable";
    public static final String col_1 = "Item_ID";
    public static final String col_2 = "Item_Name";
    public static final String col_3 = "Item_Type";
    public static final String col_4 = "Item_Picture";
    public static final String col_5 = "Item_Manufacturer";
    public static final String col_6 = "Item_Cost_Price";
    public static final String col_7 = "Item_Sell_Price";
    public static final String col_8 = "Item_Available";
    public static final String col_9 = "Item_In_Stock";


    public sql_Connection(Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String s = "Create table " +tableName+ " ("+col_1+" INTEGER PRIMARY KEY,"+col_2+" varchar(20) not null,"+col_3+" varchar(20) not null,"+col_4+" INTEGER,"+col_5+" varchar(20), "+col_6+" decimal not null, "+col_7+" decimal not null, "+col_8+" text not null, "+col_9+" INTEGER not null );";
        db.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String s = "DROP TABLE IF EXISTS "+tableName;
        db.execSQL(s);
        onCreate(db);
    }
    public boolean insertData(int id, String name, String type, int picture, String manufacture, double cost_price, double sell_price, String available, int stock){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1, id);
        contentValues.put(col_2, name);
        contentValues.put(col_3, type);
        contentValues.put(col_4, picture);
        contentValues.put(col_5, manufacture);
        contentValues.put(col_6, cost_price);
        contentValues.put(col_7, sell_price);
        contentValues.put(col_8, available);
        contentValues.put(col_9, stock);
        long result = db.insert(tableName, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * from "+tableName,null);
        return res;
    }

    public int deleteAnItem(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(tableName,"Item_ID = ?", new String[]{String.valueOf(id)});
        return result;
    }

    public void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        //db.execSQL("DELETE * FROM "+tableName);
        //db.rawQuery("Delete * from "+tableName,null);
        db.delete(tableName,"Item_ID != 0", null);
    }

    public Boolean updateData(int id, String name, String type, int picture, String manufacture, double cost_price, double sell_price, String available, int stock){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col_1, id);
        cv.put(col_2, name);
        cv.put(col_3, type);
        cv.put(col_4, picture);
        cv.put(col_5, manufacture);
        cv.put(col_6, cost_price);
        cv.put(col_7, sell_price);
        cv.put(col_8, available);
        cv.put(col_9, stock);
        db.update(tableName, cv, "Item_ID = ?", new String[]{ String.valueOf(id) });
        return true;
    }
}
