package com.example.saad.inventrymanagementapp;

/**
 * Created by saad on 12/22/2016.
 */
public class Word {
    private  int mId;
    private String mName;
    private String mType;
    private  double mPrice;
    public Word(int id, String name, String type,double price){
        mId = id;
        mName = name;
        mType = type;
        mPrice = price;
    }
    public String getmType(){
        return mType;
    }
    public int getMid(){
        return mId;
    }
    public String getmName(){
        return mName;
    }
    public double getMPrice()
    {
        return mPrice;
    }
}
