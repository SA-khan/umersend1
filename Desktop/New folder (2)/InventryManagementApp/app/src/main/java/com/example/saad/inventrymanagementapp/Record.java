package com.example.saad.inventrymanagementapp;

/**
 * Created by saad on 12/21/2016.
 */
public class Record {
    private int mID;
    private String mName;
    private String mType;
    private String mCost;
    public Record(int ID, String name, String type, String cost){
        mID = ID;
        mName = name;
        mType = type;
        mCost = cost;
    }
    public int getmID(){
        return mID;
    }
    public String getmName(){
        return mName;
    }
    public String getmType(){
        return mType;
    }
    public String getmCost(){
        return mCost;
    }
}
