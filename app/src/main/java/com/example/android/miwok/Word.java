package com.example.android.miwok;

/**
 * Erzeugt von fengels am 15.09.2017.
 */

public class Word {
	
	private String mDefaultTranslation;
	private String mMiwokTranslation;
	private int mImageResourceId;
	private int mMediaResourceId;
	private boolean mHasImageAssociated;
	
	public Word(String defaultTranslation, String miwokTranslation, int mediaResourceID)
	{
		mDefaultTranslation = defaultTranslation;
		mMiwokTranslation = miwokTranslation;
		mMediaResourceId = mediaResourceID;
		mHasImageAssociated = false;
	}
	
	public Word(String defaultTranslation, String miwokTranslation,int mediaResourceID, int imageResourceId)
	{
		
		mDefaultTranslation = defaultTranslation;
		mMiwokTranslation = miwokTranslation;
		mImageResourceId = imageResourceId;
		mMediaResourceId = mediaResourceID;
		mHasImageAssociated = true;
		
	}
	
	
	public String getDefaultTranslation() {
		return mDefaultTranslation;
	}
	
	public String getMiwokTranslation() {
		return mMiwokTranslation;
	}
	
	public int getImageResourceId()
	{
		return  mImageResourceId;
	}
	
	public  int getMediaResourceId()
	{
		return mMediaResourceId;
	}
	
	public boolean HasImageAssociated()
	{
		return  mHasImageAssociated;
	}
	
}
