package com.example.learndogri;

public class Word {
    private String mDogriTranslation;
    private String mDefaultTransaltion;
    private int mImageResourceId=NO_IMAGE;
    private static final int NO_IMAGE=-1;
    private int mSoundResourceId;
    public Word(String defaultT, String dogriT, int sound)
    {
        mDogriTranslation =dogriT;
        mDefaultTransaltion=defaultT;
        mSoundResourceId=sound;
    }
    public Word(String defaultT, String dogriT, int image, int sound)
    {
        mDogriTranslation =dogriT;
        mDefaultTransaltion=defaultT;
        mImageResourceId=image;
        mSoundResourceId=sound;
    }
    public String getmDogriTranslation()
    {
        return mDogriTranslation;
    }
    public String getmDefaultTransaltion()
    {
        return mDefaultTransaltion;
    }
    public int getmImageResourceId()
    {
        return mImageResourceId;
    }
    public boolean hasImage()
    {
        return mImageResourceId != NO_IMAGE;
    }

    public int getmSoundResourceId() {
        return mSoundResourceId;
    }
}
