package com.example.saad.firebasechat;

/**
 * Created by saad on 12/25/2016.
 */
public class Word {
    private String mDefault;
    private String mMivok;
    public Word(String defalt){
        mDefault = defalt;
        //mMivok = mivok;
    }
    public String getDefaultTranslate(){
        return mDefault;
    }
    public String getMivokTranslate(){
        return mMivok;
    }
}
