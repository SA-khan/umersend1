package com.example.saad.mivok;

/**
 * Created by saad on 9/24/2016.
 */
public class Words {

    private String mDefaultTranslation;

    private String mMivokTranslation;

    private int mImageResourceId = N0_IMAGE_PROVIDED;

    private static final int N0_IMAGE_PROVIDED = -1;

    private int mAudioResourceId;

    public Words(String DefaultTranslation, String MivokTranslation){
        mDefaultTranslation = DefaultTranslation;
        mMivokTranslation = MivokTranslation;

    }

    public Words(String DefaultTranslation, String MivokTranslation, int audio){
        mDefaultTranslation = DefaultTranslation;
        mMivokTranslation = MivokTranslation;
        mAudioResourceId = audio;
    }

    public Words(String DefaultTranslation, String MivokTranslation, int Image, int audio){
        mDefaultTranslation = DefaultTranslation;
        mMivokTranslation = MivokTranslation;
        mImageResourceId = Image;
        mAudioResourceId = audio;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMivokTranslation() {
        return mMivokTranslation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }
    public boolean hasImage(){
        return mImageResourceId != N0_IMAGE_PROVIDED;
    }

    public int getmAudioResourceId(){
        return mAudioResourceId;
    }
}
